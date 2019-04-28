package jsq;
import java.util.regex.*;;
public class Verdict {
	String s = "";

	Verdict(String s) {
		s = s.replaceAll(" ", "");//删除表达式中的空格
		this.s = s;// 表达式
	}
	//判错
	public static String check(String s) {
		int t = 0; //标记括号数量
		for (int i = 0;i <s.length()-1;i++)
		{
			if (s.charAt(i)!=')'&&s.charAt(i)!='('&&s.charAt(i)!='+'&&s.charAt(i)!='-'&&s.charAt(i)!='*'&&s.charAt(i)!='/'&&(s.charAt(i)<'0'||s.charAt(i)>'9'))
				return "error: 表达式中出现了非法字符";
			if (s.charAt(i)==')')
				t++;
			if (s.charAt(i)=='(')
				t--;
		}
		
		if (t!=0)
				return "error: 括号数量不匹配";
		
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "error: 表达式中存在空括号";
		}
		// 多个运算符连续出现 +++.
		if (s.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
			return "error: 多个运算符连续出现";
		}
		// 两个运算符连续出现 不包括 +- -- /- *-
		if (s.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
			return "error: 两个运算符连续出现";
		}
		// ）右边是数字的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return "error: 表达式中)右边是数字";
		}
		// （ 左边是数字的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "error: 表达式中(左边是数字";
		}
		// （ 右边是*/的情况
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			// System.out.println(s);
			return "error: 表达式中(右边是运算符";
		}
		// 匹配）左边是+-*/的情况
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return "error: 表达式中)左边是运算符";
		}
		if (s.length()>1){
			if (s.charAt(0)==')'||s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/')
				return "error: 表达式运算符首位字符不合法";
			if (s.charAt(s.length()-2)=='('||s.charAt(s.length()-2)=='+'||s.charAt(s.length()-2)=='-'||s.charAt(s.length()-2)=='*'||s.charAt(s.length()-2)=='/')
				return "error: 表达式运算符末位字符不合法";
			}
		// 当所有的错误格式都不匹配时返回""
		return "";
	}

}
