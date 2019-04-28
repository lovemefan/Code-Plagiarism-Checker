package BigWork;

public class Regex {
	 Boolean judge = true;
	  
		public   void Initialization() { //��ʼ��judge
			judge = true;
		}
		
		public   Boolean Judge (String S) {//������ֱ���ķ���
			judgeEmpty(S);
			judgeTwoSymbol(S);
			judgeOtherChar(S);
			judgeParentheses(S);
			judgeStartSymbol(S);
			judgeNOSys(S);
			judgeSymbolAfterLeft(S);
			judgeSymbolBeforeRight(S);
			judgeNull(S);
			judgeSymbolNotAfterRight(S);
			judgeSymbolNotBeforeLeft(S);
			return judge;
		}
		
		public    String ErrorMessage(String S) {//���ش�����Ϣ
			String eM = "";
			eM += judgeEmpty(S);
			eM += judgeTwoSymbol(S);
			eM += judgeOtherChar(S);
			eM += judgeParentheses(S);
			eM += judgeStartSymbol(S);
			eM += judgeNOSys(S);
			eM += judgeSymbolAfterLeft(S);
			eM += judgeSymbolBeforeRight(S);
			eM += judgeNull(S);
			eM += judgeSymbolNotAfterRight(S);
			eM += judgeSymbolNotBeforeLeft(S);
			return eM;
		}


		public   String judgeEmpty(String S) {
			String massage = "";
			if (S.matches(".*\\(\\).*")) {
				massage = "#���ʽ���п�����\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeTwoSymbol(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
				massage = "#���������\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeOtherChar(String S) {
			String massage = "";
			if (S.matches(".*[^0-9\\+\\-\\*\\/\\(\\)].*")) {
				massage = "#���ʽ�����Ƿ��ַ�\r";
				judge = false;
			}
			return massage;
		}
		
		public   String judgeParentheses(String S) {
			String massage = "";
			int n1 = 0; // ��¼(�ĸ���
			int n2 = 0; // ��¼)�ĸ���
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				if (c == '(') 
					n1++;
				else if (c == ')') 
					n2++;
			}
			if (n1 != n2) {
				massage = "#���ʽ���ŶԲ�ƥ��\r";//�ɹ�
				judge = false;
				n1 = n2 = 0;
			}	
			return massage;
		}
		
		public   String  judgeStartSymbol(String S) {
			String massage = "";
			if (S.matches("^[\\+\\-\\*\\/\\)].*")) {
				massage = "#�����ǰ��������\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeNOSys(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/\\(]")) {
				massage = "#���������������\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeSymbolAfterLeft(String S) {
			String massage = "";
			if (S.matches(".*\\([\\+\\*\\/].*")) {
				massage = "#���ŷǵ�һ���ַ���֮ǰ��������\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeSymbolBeforeRight(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/]\\).*")) {
				massage = "#С���ź��������������ŷ����һ���ַ�\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		
		public   String judgeNull(String S) {
			String massage = "";
			if (S == null) {
				massage = "#���ʽΪ��\r";//�ɹ�
				judge = false;
			}
			return massage;
		}
		public   String  judgeSymbolNotAfterRight(String S) {
			String massage = "";
			if (S.matches(".*\\)[^\\+\\-\\*\\/\\)].*")) {
				massage = "#���ʽ�������ź��������\r\n";//�ɹ�
				judge = false;
			}
			return massage;
		}
		public   String judgeSymbolNotBeforeLeft(String S) {
			String massage = "";
			if (S.matches(".*[^\\+\\-\\*\\/\\(]\\(.*")) {
				massage = "#���ʽ��������ǰ���������\r\n";//�ɹ�
				judge = false;
			}
			return massage;
		}
	}

