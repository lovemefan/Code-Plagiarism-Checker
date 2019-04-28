//判断运算式类

public class Judge {

	String s = "";

	Judge(String s) {
		this.s = s;// 表达式
	}

	// 判错
	public String check(String s) {
		int t = 0; // 标记括号数量
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')')
				t++;
			if (s.charAt(i) == '(')
				t--;
		}
		if (t != 0)
			return "ERROR\r\n#括号数量不匹配";
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "ERROR\r\n#表达式中存在空括号";
		}
		// 多个运算符连续出现 +++.
		if (s.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
			return "ERROR\r\n#多个运算符连续出现";
		}
		// 两个运算符连续出现 不包括 +- -- /- *-
		if (s.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
			return "ERROR\r\n#两个运算符连续出现";
		}
		// ）右边是数字的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return "ERROR\r\n#表达式中)右边是数字";
		}
		// （ 左边是数字的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "ERROR\r\n#表达式中(左边是数字";
		}
		// （ 右边是*/的情况
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			return "ERROR\r\n#表达式中(右边是运算符";
		}
		if (s.matches("[\\S]*[)][(][\\S]*")) {
			return "ERROR\r\n#表达式中)右边是("; 
		}
		// 匹配）左边是+-*/的情况
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return "ERROR\r\n#表达式中)左边是运算符";
		}
		// 当所有的错误格式都不匹配时返回""
		return "";
	}

}


