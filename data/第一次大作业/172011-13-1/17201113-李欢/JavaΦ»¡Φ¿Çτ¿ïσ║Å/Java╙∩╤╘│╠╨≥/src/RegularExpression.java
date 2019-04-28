
public class RegularExpression {

	public RegularExpression() {

	}

	public String check(String x) {//判断表达式是否规范，若规范，则返回true，否则返回出错信息。

		if (x.matches(".*(\\+\\+|\\+-|\\+\\*|\\+/|-\\+|--|-\\*|-/|\\*\\+|\\*-|\\*\\*|\\*/|/\\+|/-|/\\*|//).*")) {
			return "ERROR" + "\r\n" + "#运算符连续出现";
		} else if (x.matches(".*(\\(\\)).*")) {
			return "ERROR" + "\r\n" + "#空括号";
		}

		else if (x.matches(".*(\\+\\)|\\-\\)|\\*\\)|\\/\\)|\\(\\+|\\(\\-|\\(\\*|\\(\\/).*")) {
			return "ERROR" + "\r\n" + "#括号与运算符搭配错误";
		}

		else if (x.matches(".*(/0).*")) {
			return "ERROR" + "\r\n" + "#除数为0";
		}

		else if (!x.matches(".*(\\+|\\-|\\*|\\/|\\d|\\s|\\(|\\)).*")) {
			return "ERROR" + "\r\n" + "#非法字符";
		}

		else if (x.matches(".*(\\d\\(|\\)\\d).*")) {
			return "ERROR" + "\r\n" + "#左括号前面是数字或者右括号后面是数字";
		}

		else if (x.matches("(\\)|\\*|\\+|\\-|\\/).*")) {
			return "ERROR" + "\r\n" + "#第一个字符不是数字或者左括号";
		}

		else if (x.matches(".*(\\(|\\+|\\-|\\*|\\/)")) {
			return "ERROR" + "\r\n" + "#最后一个字符不是数字或者右括号";
		} else if (x.matches("[\\S]*[)][(][\\S]*")) {
			return "ERROR" + "\r\n" + "#右括号后面直接连接左括号";
		}

		else {
			return "right";
		}

	}

	public static int MP(String x) {//判断表达式的左右括号数量是否匹配
		int m = 0; // 记录(的个数
		int n = 0; // 记录)的个数
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if (c == '(') {
				m++;
			} else if (c == ')') {
				n++;
			}
		}
		if (m == n) {
			return 1;
		} else {
			return 2;
		}
	}
}
