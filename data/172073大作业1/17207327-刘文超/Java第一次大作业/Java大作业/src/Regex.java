public class Regex {
	  Boolean judge = true;
	  
	public  void Initialization() { //��ʼ��judge
		judge = true;
	}
	
	public   Boolean Judge (String S) {
		RG_1(S);
		RG_2(S);
		RG_3(S);
		RG_4(S);
		RG_5(S);
		RG_6(S);
		RG_7(S);
		RG_8(S);
		RG_9(S);
		return judge;
	}
	
	public    String ErrorMassage(String S) {
		String E = "";
		E += RG_1(S);
		E += RG_2(S);
		E += RG_3(S);
		E += RG_4(S);
		E += RG_5(S);
		E += RG_6(S);
		E += RG_7(S);
		E += RG_8(S);
		E += RG_9(S);
		return E;
	}
//	if (judge = false)
//		System.out.println("ERROR");

	public   String RG_1(String S) {
		String massage = "";
		if (S.matches(".*\\(\\).*")) {
			massage = "#表达式中有空括号";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_2(String S) {
		String massage = "";
		if (S.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
			massage = "#运算符连续\r";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_3(String S) {
		String massage = "";
		if (S.matches("[^0-9\\+\\-\\*\\/\\(\\)]")) {
			massage = "#表达式包含非法字符\r";
			judge = false;
		}
		return massage;
	}
	
	public   String RG_4(String S) {
		String massage = "";
		int num1 = 0; // ��¼(�ĸ���
		int num2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') 
				num1++;
			else if (c == ')') 
				num2++;
		}
		if (num1 != num2) {
			massage = "#表达式括号对不匹配\r";//�ɹ�
			judge = false;
			num1 = num2 = 0;
		}	
		return massage;
	}
	
	public   String RG_5(String S) {
		String massage = "";
		if (S.matches("^[\\+\\-\\*\\/\\)].*")) {
			massage = "#运算符前无运算数\r";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_6(String S) {
		String massage = "";
		if (S.matches(".*[\\+\\-\\*\\/\\(]")) {
			massage = "#运算符后无运算数\r";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_7(String S) {
		String massage = "";
		if (S.matches("[\\+\\-\\*\\/]\\(.*")) {
			massage = "#括号非第一个字符且之前无运算数\r";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_8(String S) {
		String massage = "";
		if (S.matches(".*\\)[\\+\\-\\*\\/]")) {
			massage = "#小括号后无运算数，括号非最后一个字符\r";//�ɹ�
			judge = false;
		}
		return massage;
	}
	
	public   String RG_9(String S) {
		String massage = "";
		if (S == null) {
			massage = "#表达式为空";//�ɹ�
			judge = false;
		}
		return massage;
	}
}
