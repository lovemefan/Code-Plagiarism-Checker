package javaAssignment;

public class Regex {
	Regex() {

	}

	public void regex(String[] expression, String[] result, boolean[] tf) {
		int i = 0;
		while (expression[i] != null) {
			if (!expression[i].matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// 非法字符
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			if (par(expression[i])) {// 匹配括号
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			// 连续符号
			if (expression[i]
					.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) { // 比如+++
																															// ---.
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\)\\d|\\d\\().*")) { // ）右边是数字的情况 或者
																// (左边是数字的情况
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\(\\)).*")) { // 匹配空括号
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // 右括号左边含有运算符
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*(\\(\\+|\\(/|\\(\\*).*")) { // 左括号右边有运算符
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches("[\\+\\*\\/].*")) {// 判断以符号开头
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}

			if (expression[i].matches(".*[\\+\\-\\*\\/]")) {// 最后一个字符为运算符
				result[i] = "ERROR\r\n";
				tf[i] = false;
				i++;
				continue;
			}
			tf[i] = true;
			i++;
		}

	}

	public Boolean par(String exp) {
		int i = 0;
		for (int k = 0; k < exp.length(); k++) {
			char ch = exp.charAt(k);
			if(i < 0)
				return true;
			if (ch == '(')
				i++;
			else if (ch == ')')
				i--;
		}
		if (i == 0)
			return false;
		else
			return true;
	}

}
