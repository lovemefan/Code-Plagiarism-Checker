import java.io.IOException;

public class Check {
	public Check() {

	}

	// 判断不满足计算表达式格式，如果不满足则返回true，反之返回false
	public static boolean CheckingRegularExpression(String expression,int i) throws IOException {
		if (checkOne(expression,i) || checkTwo(expression,i)) {
			return true;
		}

		if (checkThree(expression,i) || checkFour(expression,i)) {
			return true;
		}

		if (checkFive(expression,i) || matchingParentheses(expression,i)) {
			return true;
		}

		return false;
	}

	private static boolean checkFive(String expression,int num) throws IOException {
		// 最后一个字符为运算符
		if (expression.matches(".*[\\+\\-\\*\\/]")) {
			// System.out.println("最后一个字符为运算符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#最后一个字符为运算符";
			WriteToFile.writeToFile(out);
			return true;
		}
		// 括号匹配
		if (!expression.matches(".*(\\()?.*(\\))?.*")) {
			// System.out.println("括号匹配");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#括号匹配";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkFour(String expression,int num) throws IOException {
		// 左括号前不是运算符
		if (expression.matches(".*[^\\+\\-\\*\\/\\(\\s*]\\(.*")) {
			// System.out.println("左括号前不是运算符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#左括号前不是运算符";
			WriteToFile.writeToFile(out);
			return true;
		}
		// 右括号后不是运算符
		if (expression.matches(".*\\)[^\\+\\-\\*\\/\\)\\s*].*")) {
			// System.out.println("右括号后不是运算符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#右括号后不是运算符";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkThree(String expression,int num) throws IOException {
		// 左括号后有运算符
		if (expression.matches(".*\\([\\+\\-\\*\\/].*")) {
			// System.out.println("左括号后有运算符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#左括号后有运算符";
			WriteToFile.writeToFile(out);
			return true;
		}
		// 右括号前有运算符
		if (expression.matches(".*[\\+\\-\\*\\/]\\).*")) {
			// System.out.println("右括号前有运算符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#右括号前有运算符";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkTwo(String expression,int num) throws IOException {
		// 判断两个操作符连在一起
		if (expression.matches(".*[\\+\\-\\*\\/]\\s*[\\+\\-\\*\\/].*")) {
			// System.out.println("判断两个操作符连在一起");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#两个操作符连在一起";
			WriteToFile.writeToFile(out);
			return true;
		}
		// 判断以符号开头
		if (expression.matches("[\\+\\-\\*\\/\\)\\s].*")) {
			// System.out.println("判断以符号开头");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#以符号开头";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	private static boolean checkOne(String expression,int num) throws IOException {
		// 表达式内含非法字符
		if (!expression.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {
			// System.out.println("表达式内含非法字符");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#表达式内含非法字符";
			WriteToFile.writeToFile(out);
			return true;
		}
		// 匹配空括号
		if (expression.matches(".*(\\(\\)).*")) {
			// System.out.println("匹配空括号");
			String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#匹配空括号";
			WriteToFile.writeToFile(out);
			return true;
		}
		return false;
	}

	// 匹配括号，如果对则返回false，反之返回true
	public static boolean matchingParentheses(String expression,int num) throws IOException {
		int l1 = 0; // 记录(的个数
		int l2 = 0; // 记录)的个数
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				l1++;
			}
			if (c == ')') {
				l2++;
			}
		}
		if (l1 == l2) {
			return false;
		}
		String out = (num + 1) + ": " + "ERROR" + "\r\n" + "	#括号数量不匹配";
		WriteToFile.writeToFile(out);
		return true;
	}
}
