public class Calculate {// 计算类，处理表达式序列
	LinkStack exp = null;// 表达式链表，用来计算结果
	LinkStack head = null;// 栈
	Filter filter = null;// 过滤类
	private double num = 0;// 计算结果

	public Calculate(String expString) {// 构造方法对表达式进行合法性检查
		filter = new Filter(expString);// 创建一个过滤类
		exp = filter.linkedExp();// 得到规范后的表达式
		compute();
	}

	private void calculate() {// 计算表达式的值
		if (filter.getIsLegal() == false)// 合法性检查
			return;
		head = new LinkStack();// 创建一个栈
		Node tmp = exp.getHead().getNext();// 创建一个节点指向后缀表达式表头
		while (tmp != null && filter.getIsLegal() == true) {// 遍历后缀表达式链表
			String s = tmp.getData();// 读取链表中的每个字符串
			if (s.matches("[\\+\\-\\*\\/]")) {// 正则表达式匹配符号
				double num2 = Double.valueOf(head.pop().getData());// 出栈
				double num1 = Double.valueOf(head.pop().getData());// 出栈
				plugSigns(s, num1, num2);// 处理加号
				minusSigns(s, num1, num2);// 处理减号
				mulSigns(s, num1, num2);// 处理乘号
				divisionSigns(s, num1, num2);// 处理除号，除数可能为0
				head.push(new Node(String.valueOf(num)));// 计算结果入栈
			} else {
				head.push(new Node(tmp.getData()));// 数字入栈
			}
			tmp = tmp.getNext();// 指向下一个节点
		}
	}

	private void plugSigns(String s, double num1, double num2) {// 计算加号
		if (s.matches("\\+")) {
			num = num1 + num2;
		}
	}

	private void minusSigns(String s, double num1, double num2) {// 计算减号
		if (s.matches("\\-")) {
			num = num1 - num2;
		}
	}

	private void mulSigns(String s, double num1, double num2) {// 计算乘号
		if (s.matches("\\*")) {
			num = num1 * num2;
		}
	}

	private void divisionSigns(String s, double num1, double num2) {// 计算除号
		if (s.matches("\\/")) {
			if (num2 == 0) {// 除数为0的错误
				filter.setErrorString("ERROR\n#The divisor can't be zero");
				filter.setLegal(false);
				return;
			}
			num = num1 / num2;
		}
	}

	private void toPostList() {// 将中缀表达式转换为后缀表达式
		if (filter.getIsLegal() == false)// 如果表达式不合法直接退出
			return;
		head = new LinkStack();// 创建栈
		LinkStack tmpExp = new LinkStack();// 创建链表，存放后缀表达式
		Node tmp = exp.getHead().getNext();// 遍历中缀表达式节点
		while (tmp != null) {// 遍历表达式，将不同操作合并
			plugOrMinusSigns(tmpExp, tmp);// 判断加减号
			mulOrDivSigns(tmpExp, tmp);// 判断乘除号
			leftBracket(tmpExp, tmp);// 判断左括号
			rightBracket(tmpExp, tmp);// 判断右括号
			nums(tmpExp, tmp);// 判断数字
			tmp = tmp.getNext();// 指向下一个节点
		}
		while (head.isEmpty() == false) {// 将栈中剩余符号全部出栈
			tmpExp.addNode(head.pop());
		}
		exp = tmpExp;// 返回后缀表达式
	}

	private void plugOrMinusSigns(LinkStack tmpExp, Node tmp) {// 处理加减号
		if (tmp.getData().equals("+") || tmp.getData().equals("-")) {
			// 如果栈不为空且不为左括号
			while (head.isEmpty() == false && head.top().equals("(") == false) {
				tmpExp.addNode(head.pop());// 出栈到后缀表达式中
			}
			head.push(new Node(tmp.getData()));// 符号入栈
		}
	}

	private void mulOrDivSigns(LinkStack tmpExp, Node tmp) {// 处理乘除号
		if (tmp.getData().equals("*") || tmp.getData().equals("/")) {
			// 如果栈顶符号优先级大于等于该符号则持续出栈
			while (head.isEmpty() == false && (head.top().equals("*") || head.top().equals("/"))) {
				tmpExp.addNode(head.pop());
			}
			head.push(new Node(tmp.getData()));// 符号入栈
		}
	}

	private void leftBracket(LinkStack tmpExp, Node tmp) {// 处理左括号
		if (tmp.getData().equals("(")) {// 左括号直接入栈
			head.push(new Node(tmp.getData()));
		}
	}

	private void rightBracket(LinkStack tmpExp, Node tmp) {// 处理右括号
		if (tmp.getData().equals(")")) {
			while (head.top().equals("(") == false) {// 持续出栈直到遇到左括号
				tmpExp.addNode(head.pop());
			}
			head.pop();// 左括号出栈丢弃
		}
	}

	private void nums(LinkStack tmpExp, Node tmp) {// 处理数字
		if (tmp.getData().charAt(0) >= '0' && tmp.getData().charAt(0) <= '9') {
			num = Double.valueOf(tmp.getData());
			tmpExp.addNode(new Node(tmp.getData()));
		}
	}

	private void compute() {
		toPostList();// 转换为后缀表达式
		calculate();// 计算表达式
	}

	public String printExp() {// 打印表达式值
		if (filter.getIsLegal()) {// 如果合法输出表达式结果
			String str = filter.getFinalString() + "=" + num;
			return str;
		}
		return null;
	}

	public double getNum() {
		return num;
	}
	
}
