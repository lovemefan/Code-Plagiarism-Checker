package Calculator;

public class Check {
	String s;
	String a;
	public boolean check(String s){
		//匹配非法字符
		
		if(!s.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {
			a = "ERROR:\r\n #表达式内含非法字符";
			return true;
		}
		//匹配分母为0
		if(s.matches("[\\S]*[/][0][\\S]*")){
			a = "ERROR:\r\n #表达式中分母为零";
			return true;
		}
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			a = "ERROR:\r\n #表达式中存在空括号";
			return true;
		}
		if (s.matches("[\\S]*[)][(][\\S]*")) {
			a = "ERROR: \r\n #表达式中右括号后面是左括号";
			return true;
		}
		// 多个运算符连续出现 +++.
		if (s.matches("[\\S]*[+-/*][+-/*][+-/*][\\S]*")) {
			a = "ERROR: \r\n #多个运算符连续出现";
			return true;
		}
		// 两个运算符连续出现 
		if (s.matches("[\\S]*[+-/*][+-/*][\\S]*")) {
			a =  "ERROR: \r\n #两个运算符连续出现";
			return true;
		}
		// ）右边是数字的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			a = "ERROR:\r\n #表达式中)右边是数字";
			return true;
		}
		// （ 左边是数字的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			a =  "ERROR:\r\n #表达式中(左边是数字";
			return true;
		}
		// （ 右边是*/的情况
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			a =  "ERROR: \r\n#表达式中(右边是运算符";
			return true;
		}
		// 匹配）左边是+-*/的情况
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			a =  "ERROR:\r\n #表达式中)左边是运算符";
			return true;
		}
		if (s.length()>1){
			if (s.charAt(0)==')'||s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'){
				a =  "ERROR: 表达式运算符首位字符不合法";
				return true;
			}
			if (s.charAt(s.length()-1)=='('||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='*'||s.charAt(s.length()-1)=='/'){
				a = "ERROR: #表达式运算符末位字符不合法";
			    return true;
			}
				
		}
		return false;

	}

}
