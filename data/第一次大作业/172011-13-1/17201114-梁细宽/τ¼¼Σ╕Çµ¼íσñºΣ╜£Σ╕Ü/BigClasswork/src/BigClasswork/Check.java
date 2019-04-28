package BigClasswork;

public class Check {
	private String expression;// 传入判断的表达式

	public Check() {

	}

	public Check(String expression) {
		this.expression = expression;
	}

	public int check() {
		String[] str = { ".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*",
				".*(\\)\\d).*", ".*(\\d\\().*", ".*(\\(\\)).*", ".*(\\+\\)|\\*\\)|-\\)|/\\)).*",
				".*(\\(-|\\(\\+|\\(/|\\(\\*).*", ".*(/0).*", "[\\+\\-\\*\\/\\)\\s].*", ".*[\\+\\-\\*\\/]",
				"[\\S]*[)][(][\\S]*" };
		// String[] message =
		// {"运算符连续出现","）右边是数字的情况","(左边是数字的情况","匹配空括号","右括号左边含有运算符","左括号右边有运算符","除数后面是0","第一个为运算符","以符号结尾",")(连续"};
		for (int i = 0; i < str.length; i++) {
			if (expression.matches(str[i])) {
				return i + 1;
			}
		}
		if (!judge(expression)) {// 括号配对
			return 11;
		} else if (!expression.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// 匹配非法字符
			return 12;
		} else {
			return 0; // 当所有的错误格式都不匹配时就是真
		}

	}

	// 判断左右括号的个数是否一致
	public static boolean judge(String expression) {
		int i1 = 0;
		int i2 = 0;

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				i1++;
			} else if (ch == ')') {
				i2++;
			}
		}

		return i1 == i2;
	}

}
