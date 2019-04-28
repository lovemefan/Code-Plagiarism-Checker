package BigWork;

public class Regex {
	 Boolean judge = true;
	  
		public   void Initialization() { //初始化judge
			judge = true;
		}
		
		public   Boolean Judge (String S) {//定义各种报错的方法
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
		
		public    String ErrorMessage(String S) {//返回错误信息
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
				massage = "#表达式中有空括号\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeTwoSymbol(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
				massage = "#运算符连续\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeOtherChar(String S) {
			String massage = "";
			if (S.matches(".*[^0-9\\+\\-\\*\\/\\(\\)].*")) {
				massage = "#表达式包含非法字符\r";
				judge = false;
			}
			return massage;
		}
		
		public   String judgeParentheses(String S) {
			String massage = "";
			int n1 = 0; // 记录(的个数
			int n2 = 0; // 记录)的个数
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				if (c == '(') 
					n1++;
				else if (c == ')') 
					n2++;
			}
			if (n1 != n2) {
				massage = "#表达式括号对不匹配\r";//成功
				judge = false;
				n1 = n2 = 0;
			}	
			return massage;
		}
		
		public   String  judgeStartSymbol(String S) {
			String massage = "";
			if (S.matches("^[\\+\\-\\*\\/\\)].*")) {
				massage = "#运算符前无运算数\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeNOSys(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/\\(]")) {
				massage = "#运算符后无运算数\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeSymbolAfterLeft(String S) {
			String massage = "";
			if (S.matches(".*\\([\\+\\*\\/].*")) {
				massage = "#括号非第一个字符且之前无运算数\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeSymbolBeforeRight(String S) {
			String massage = "";
			if (S.matches(".*[\\+\\-\\*\\/]\\).*")) {
				massage = "#小括号后无运算数，括号非最后一个字符\r";//成功
				judge = false;
			}
			return massage;
		}
		
		public   String judgeNull(String S) {
			String massage = "";
			if (S == null) {
				massage = "#表达式为空\r";//成功
				judge = false;
			}
			return massage;
		}
		public   String  judgeSymbolNotAfterRight(String S) {
			String massage = "";
			if (S.matches(".*\\)[^\\+\\-\\*\\/\\)].*")) {
				massage = "#表达式中右括号后不是运算符\r\n";//成功
				judge = false;
			}
			return massage;
		}
		public   String judgeSymbolNotBeforeLeft(String S) {
			String massage = "";
			if (S.matches(".*[^\\+\\-\\*\\/\\(]\\(.*")) {
				massage = "#表达式中左括号前不是运算符\r\n";//成功
				judge = false;
			}
			return massage;
		}
	}

