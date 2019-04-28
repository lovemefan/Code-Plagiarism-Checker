//非法字符类
public class Error {
	String s = "";

	Error(String s) {
		this.s = s;// 表达式
	}

	public String check(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i) != '+' && s.charAt(i) != '-'
					&& s.charAt(i) != '*' && s.charAt(i) != '/' && (s.charAt(i) < '0' || s.charAt(i) > '9'))
				return "ERROR\r\n#表达式中出现了非法字符";
		}
		if (check2(s) != "")
			return check2(s);
		return "";
	}

	public String check2(String s) {
		if (s.length() > 1) {
			if (s.charAt(0) == ')' || s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*'
					|| s.charAt(0) == '/')
				return "ERROR\r\n#表达式运算符首位字符不合法";
			if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-'
					|| s.charAt(s.length() - 1) == '*' || s.charAt(s.length() - 1) == '/')
				return "ERROR\r\n#表达式运算符末位字符不合法";
		}

		return "";
	}

}
