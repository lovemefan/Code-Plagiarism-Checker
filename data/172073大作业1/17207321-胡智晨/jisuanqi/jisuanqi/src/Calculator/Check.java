package Calculator;

public class Check {
	String s;
	String a;
	public boolean check(String s){
		//匹配非法字符
		if(!s.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {
			a = "ERROR:\r\n #表达式包含非法字符";
			return true;
		}
		//匹配分母为0
		if(s.matches("[\\S]*[/][0][\\S]*")){
			a = "ERROR:\r\n #表达式中分母为零";
			return true;
		}
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			a = "ERROR:\r\n #表达式中有空括号";
			return true;
		}
		if (s.matches("[\\S]*[)][(][\\S]*")) {
			a = "ERROR: \r\n #括号不匹配";
			return true;
		}
		// 两个运算符连续出现 
		if (s.matches("[\\S]*[+-/*][+-/*][\\S]*")) {
			a =  "ERROR: \r\n #运算符连续";
			return true;
		}
		// ）右边是数字的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			a = "ERROR:\r\n #小括号后无运算数，括号非最后一个字符";
			return true;
		}
		// （ 左边是数字的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			a =  "ERROR:\r\n #括号非第一个字符且之前无运算符";
			return true;
		}
		if (s.length()>1){
			if (s.charAt(0)==')'||s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'){
				a =  "ERROR: \r\n #运算符前无运算数";
				return true;
			}
			if (s.charAt(s.length()-1)=='('||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='*'||s.charAt(s.length()-1)=='/'){
				a = "ERROR: \r\n #运算符后无运算数";
			    return true;
			}
				
		}
		return false;

	}

}
