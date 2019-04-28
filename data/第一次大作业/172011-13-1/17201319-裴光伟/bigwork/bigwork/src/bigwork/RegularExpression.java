package bigwork;

import java.util.regex.*;

public class RegularExpression {
	public static void RegularExp(String[] exp, int s) {
		equal(exp, s);// 判断相同的请求
		situation1(exp, s);// 表达式内含非法字符
		situation2(exp, s);// 空括号
		situation3(exp, s);// 运算符连续
		situation4(exp, s);// 左括号前面不是运算符
		situation5(exp, s);// 右括号后面不是运算符
		situation6(exp, s);// 左括号后非数字
		situation7(exp, s);// 右括号前非数字
		situation8(exp, s);// 以非法字符开头
		situation9(exp, s);// 括号不匹配
		situation10(exp, s);// 无运算符
		situation11(exp, s);// 以非法字符结尾
		situation12(exp, s);// 开头为－判断为负数
		minusPan(exp, s);// 判断负数
	}

	// 判断负数
	public static void minusPan(String[] exp, int s) {
		for (int i = 0; i < s; i++)
			exp[i] = exp[i].replaceAll("\\(-", "\\(0-");
	}

	// 判断相同的请求
	public static void equal(String[] exp, int s) {
		String error = "\r\nERROR\r\n#该等式与其他等式重复!!!";
		for (int i = 0; i < s - 1; i++)
			for (int j = i + 1; j < s; j++) {
				if (exp[i].equals(exp[j]) && !errorPan(exp[i]))
					exp[j] = exp[j] + error;
			}
	}

	// 判断是否含ERROR
	public static boolean errorPan(String exp) {
		Pattern p = Pattern.compile("ERROR");
		Matcher m = p.matcher(exp);
		return m.find();
	}

	// 判断是否为空字符串
	public static boolean blankPan(String exp) {
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(exp);
		return m.find();
	}

	// 表达式内含非法字符
	public static void situation1(String[] exp, int s) {
		Pattern p = Pattern.compile("[^\\(\\)\\*\\+-/\\d]");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find() && !errorPan(exp[i]))
				exp[i] = errorPrint(exp[i], "#表达式内含非法字符");
		}
	}

	// 空括号
	public static void situation2(String[] exp, int s) {
		Pattern p = Pattern.compile("\\(\\)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内空括号");
		}
	}

	// 运算符连续
	public static void situation3(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|-|\\*|/){2,}");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内运算符连续");
		}
	}

	// 左括号前面不是运算符
	public static void situation4(String[] exp, int s) {
		Pattern p = Pattern.compile("\\d\\(");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内左括号前面不是运算符");
		}
	}

	// 右括号后面不是运算符
	public static void situation5(String[] exp, int s) {
		Pattern p = Pattern.compile("\\)\\d");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内右括号后面不是运算符");
		}
	}

	// 左括号后非数字
	public static void situation6(String[] exp, int s) {
		Pattern p = Pattern.compile("\\((\\+|\\*|/)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内左括号后非数字");
		}
	}

	// 右括号前非数字
	public static void situation7(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|-|\\*|/|\\()\\)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (m.find())
				exp[i] = errorPrint(exp[i], "#表达式内右括号前非数字");
		}
	}

	// 以非法字符开头
	public static void situation8(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (exp[i].charAt(0) == '+' || exp[i].charAt(0) == ')' || exp[i].charAt(0) == '*'
					|| exp[i].charAt(0) == '/')
				exp[i] = errorPrint(exp[i], "#表达式内以非法字符开头");
		}
	}

	// 开头为－判断为负数
	public static void situation12(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (exp[i].charAt(0) == '-')
				exp[i] = "0" + exp[i];
		}
	}

	// 以非法字符结尾
	public static void situation11(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			int len = exp[i].length() - 1;
			if (exp[i].charAt(len) == '+' || exp[i].charAt(len) == '-' || exp[i].charAt(len) == '*'
					|| exp[i].charAt(len) == '/' || exp[i].charAt(len) == '(')
				exp[i] = errorPrint(exp[i], "#表达式内以非法字符结尾");
		}
	}

	// 括号不匹配
	public static void situation9(String[] exp, int s) {
		boolean t = false;
		for (int i = 0; i < s; i++) {
			t = bracketEqual(exp[i]);
			if (!t)
				exp[i] = errorPrint(exp[i], "#表达式内括号不匹配");
		}
	}

	// 无运算符
	public static void situation10(String[] exp, int s) {
		Pattern p = Pattern.compile("(\\+|\\*|-|/)");
		for (int i = 0; i < s; i++) {
			Matcher m = p.matcher(exp[i]);
			if (!m.find())
				exp[i] = errorPrint(exp[i], "#表达式内无运算符");
		}
	}

	// 向字符串中输入错误信息
	public static String errorPrint(String exp, String error) {
		String e = "\r\nERROR\r\n";
		if (errorPan(exp))
			exp = exp + error;
		else
			exp = exp + e + error;
		return exp;
	}

	// 判断左右括号是否相等
	public static boolean bracketEqual(String exp) {
		int p = 0;
		char[] ch = exp.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(')
				p++;
			if (ch[i] == ')')
				p--;
		}
		if (p == 0)
			return true;
		else
			return false;
	}
}
