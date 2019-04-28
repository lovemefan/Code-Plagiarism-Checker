//将中缀表达式转化为后缀表达式类
public class ToString {
	private SeqStack<String> stack; // 中缀表达式转换为后缀表达式所需要的栈
	private String expstr; // 输入的中缀表达式
	private String postfix = ""; // 后缀表达式

	public ToString(SeqStack<String> stack, String expstr) {// 构造函数
		this.stack = stack;
		this.expstr = expstr;
	}

	private String processExpstr(String expstr) {// 将中缀表达式中加入空格来划分
		String result = "";
		for (int i = 0; i < expstr.length() - 1; i++) {
			char temp1 = expstr.charAt(i);
			char temp2 = expstr.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {// 如果两个字符均为数字
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += expstr.charAt(expstr.length() - 1); // 将最后一个元素添加进去
		return result;
	}

	private boolean isDigital(char ch) {// 判断是否为数字
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

	public String process() {// 前缀表达式转换为后缀表达式
		String[] strArr = processExpstr(expstr).split(" ");// 以空格划分
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				getOperation(str, 1);
				break;
			case "*":
			case "/":
				getOperation(str, 2);
				break;
			case "(":
				stack.push(str);
				break;
			case ")":
				getParent();
				break;
			default:
				postfix += str + " ";// 如果是数字则放入字符串中 数字之间以空格划分
				break;
			}
		}
		while (!stack.isEmpty()) {// 输出栈中剩余的符号
			postfix += stack.pop();
		}

		return postfix;
	}

	private void getParent() {// 当字符串为右括号时将栈中元素出栈知道遇到左括号
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {// 左括号为界
				break;
			} else {
				postfix += top;
			}
		}
	}

	private void getOperation(String str, int priority) {// 将栈顶的元素优先级与表达式中的进行比较
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {// 如果栈顶为左括号则将运算符入栈
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {// 如果栈顶元素优先级低则将运算符入栈
					stack.push(top);
					break;
				} else {// 否则先将栈顶元素出栈放入字符串中再将运算符入栈
					postfix += top;
				}
			}
		}
		stack.push(str);
	}

	private int getPriority(String str) {// 将运算符的优先级转化为数字来比较
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {// +-优先级为1
			pri = 1;
		} else {// 括号*/优先级为2
			pri = 2;
		}
		return pri;
	}

}