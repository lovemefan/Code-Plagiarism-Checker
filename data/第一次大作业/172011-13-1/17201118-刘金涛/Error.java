//�Ƿ��ַ���
public class Error {
	String s = "";

	Error(String s) {
		this.s = s;// ���ʽ
	}

	public String check(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i) != '+' && s.charAt(i) != '-'
					&& s.charAt(i) != '*' && s.charAt(i) != '/' && (s.charAt(i) < '0' || s.charAt(i) > '9'))
				return "ERROR\r\n#���ʽ�г����˷Ƿ��ַ�";
		}
		if (check2(s) != "")
			return check2(s);
		return "";
	}

	public String check2(String s) {
		if (s.length() > 1) {
			if (s.charAt(0) == ')' || s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*'
					|| s.charAt(0) == '/')
				return "ERROR\r\n#���ʽ�������λ�ַ����Ϸ�";
			if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-'
					|| s.charAt(s.length() - 1) == '*' || s.charAt(s.length() - 1) == '/')
				return "ERROR\r\n#���ʽ�����ĩλ�ַ����Ϸ�";
		}

		return "";
	}

}
