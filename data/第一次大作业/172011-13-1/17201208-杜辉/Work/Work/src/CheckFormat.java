//判断类 判断输入的表达式是否正确
class CheckFormat {
	String s = "";
	String ans = null;

	CheckFormat(String s) {
		this.s = s;// 表达式
	}

	public String check() {
		// 匹配两个运算符连续出现 不包括 +- -- /- *-
		if (s.matches("[\\S]*[+\\-/*/][+\\-/*/][\\S]*")) {
			ans = "ERROR\n"
					+ "#两个运算符连续出现";

		}
		if(s.matches("[\\S]*[^0-9+\\-/*/()][\\S]*")){
			ans = "ERROR\n"
					+ "#表达式中含非法字符";
		}
		if (s.matches("[\\S]*[+\\-/*/]")) {
			ans = "ERROR\n"
					+ "#表达式中运算符右边没有数字";
		}if (s.matches("[+/*/][\\S]*")) {
			ans = "ERROR\n"
					+ "#表达式中运算符左边没有数字";
		}
		// 匹配）右边是数字的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			ans = "ERROR\n"
					+ "#表达式中)右边不能是数字";

		}
		// 匹配（左边是数字的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			ans = "ERROR\n"
					+ "#表达式中(左边不能是数字";
			// return true;
		}
		// 匹配（右边是*/的情况
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			// System.out.println(s);
			ans = "ERROR\n"
					+ "#表达式中(右边不能是*或者是/";
			// return true;
		}
		// 匹配）左边是+-*/的情况
		if (s.matches("[\\S]*[+\\-/*/][)][\\S]*")) {
			ans = "ERROR\n"
					+ "#表达式中)左边不能是运算符";
			// return true;
		}
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			ans = "ERROR\n"
					+ "#表达式中存在空括号";
			// return true;
		}
		// 当所有的错误格式都不匹配时返回null
		return ans;
	}
}
