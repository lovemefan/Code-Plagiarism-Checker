
public class Suffix {
	Stack stack = new Stack();// 创建用于转换后缀的栈
	String post = "";// 后缀表达式的变量
	String expression;// 从文件中读取的表达式

	// Suffix构造方法
	public Suffix(String expression) {
		this.expression = expression;
	}

	// 中缀的处理:将原空格全部删去并在数字与符号之间统一插入空格
	public String Deal(String expression) {
		String dealExpression;
		String Deal1 = "";
		dealExpression = expression.replace(" ", "");
		for (int i = 0; i < dealExpression.length() - 1; i++) {
			if (dealExpression.charAt(i) <= '9' && dealExpression.charAt(i) >= '0') {
				if (dealExpression.charAt(i + 1) <= '9' && dealExpression.charAt(i + 1) >= '0') {
					Deal1 += dealExpression.charAt(i);
				}

				else
					Deal1 += dealExpression.charAt(i) + " ";
			} else
				Deal1 += dealExpression.charAt(i) + " ";

		}
		Deal1 += dealExpression.charAt(dealExpression.length() - 1);
		return Deal1;
	}

	// 判断运算符号优先级
	public int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	// 将中缀转换成后缀表达式
	public void process() {
		String[] strArr = Deal(expression).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				symbolEnter(str, 1);
				break;
			case "*":
			case "/":
				symbolEnter(str, 2);
				break;
			case "(":
				stack.push(str);
				break;
			case ")":
				rightOutput();
				break;
			default:
				post += str + " ";
				break;
			}
		}
		// 数字全部输出后，需要输出栈中剩余所有的符号
		while (!stack.isEmpty()) {
			post += stack.pop() + " ";
		}
	}

	// 遇见右括号使将栈内所有节点都出栈
	public void rightOutput() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += top + " ";
			}
		}
	}

	// 左括号 四则运算符号的入栈操作
	public void symbolEnter(String str, int priority) {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);// 提取优先级并判断
				if (priTop < priority) {
					stack.push(top);
					break;
				} else {
					post += top + " ";
				}
			}
		}
		stack.push(str);
	}
}
