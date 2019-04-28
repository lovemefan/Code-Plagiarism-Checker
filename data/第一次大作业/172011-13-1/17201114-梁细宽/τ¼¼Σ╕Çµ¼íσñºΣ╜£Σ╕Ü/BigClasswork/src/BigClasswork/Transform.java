package BigClasswork;

public class Transform {
	private String input;
	private String output = "";
	private Stack stack;

	public Transform(String input, Stack stack) {
		this.input = input;
		this.stack = stack;
	}

	public String getOutput() {
		return output.trim();
	}

	// 将文件中正确读取的表达式加上空格
	public String addBlank(String input) {
		String result = "";

		for (int i = 0; i < input.length() - 1; i++) {
			char ch1 = input.charAt(i);
			char ch2 = input.charAt(i + 1);

			if (ch1 >= '0' && ch1 <= '9' && ch2 >= '0' && ch2 <= '9') {// 两个连续的数字则不加空格否则加空格
				result += ch1;
			} else {
				result += ch1 + " ";
			}
		}
		result += input.charAt(input.length() - 1);// 将表达式中剩余的字符加上
		return result;

	}

	public void transform() {
		String[] string = addBlank(input).split(" ");// 以空格为折点将数字和字符分开存入数组

		for (int i = 0; i < string.length; i++) {
			String str = string[i];

			switch (str) {
			case "(":
				stack.PushStack(str);
				break;
			case ")":
				parent();
				break;
			case "+":
			case "-":
				operate(str, 1);
				break;
			case "*":
			case "/":
				operate(str, 2);
				break;
			default:
				output += " " + str;
				break;
			}
		}
		// 数字全部输出后，需要输出栈中剩余的符号
		while (!stack.isEmpty()) {
			output += " " + stack.PopStack();
		}

	}

	// 如果下个字符是+-*/则进行此操作
	public void operate(String str, int pri1) {

		while (!stack.isEmpty()) {
			String top = stack.PopStack();

			if (top.equals("(")) {
				stack.PushStack(top);
				break;
			} else {
				int pri2 = 0;

				if (top.equals("+") || top.equals("-")) {
					pri2 = 1;
				} else {
					pri2 = 2;
				}

				if (pri2 < pri1) {
					stack.PushStack(top);// 如果栈顶元素的优先级小于要插入栈中元素的优先级就将top放回栈中
					break;
				} else {
					output += " " + top;// 如果栈顶元素优先级大，则将其赋给output
				}
			}
		}
		stack.PushStack(str);// 如果栈为空则直接将符号入栈

	}

	// 如果下个字符是）则将前面（后的运算符全部弹出加入后缀表达式
	public void parent() {
		while (!stack.isEmpty()) {
			String top = stack.PopStack();

			if (top.equals("(")) {
				break;
			} else {

				output += " " + top;
			}
		}
	}

}
