
public class checkexpression {
	public String check(String s) {
		int number = 0;// 用来检验左括号和右括号的个数是否相等，以此判断括号是否配对
		int flag = 0;// 用来标记是否出现非法字符
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i) != '*' && s.charAt(i) != '-'
					&& s.charAt(i) != '+' && s.charAt(i) != '/' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				flag = 1;// 出现了非法字符
			if (s.charAt(i) == ')')
				number--;
			else if (s.charAt(i) == '(')
				number++;
		}
		// 匹配出现非法字符的情况
		if (flag == 1)
			return "出现了非法字符";
		// 匹配括号不配对的情况
		if (number != 0)
			return "括号不配对";
        //匹配运算符连续的情况
		if (s.matches("[\\S]*[+-/*/][+-/*/][\\S]*")) {
			return "运算符连续";
		}
		// 匹配(右边是运算符的情况
		if (s.matches("[\\S]*[(][/*+-][\\S]*")) {
			return "(后面是运算符";
		}
		// 匹配)左边是+-*/的情况
		if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return ")前面是运算符";
		}
		// 匹配(前不是运算符的情况
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			return "(前面不是运算符";
		}
		// 匹配)后不是运算符的情况
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			return ")后面不是运算符";
		}                                                                                
		// 匹配空括号
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			return "空括号";
		}
		// 匹配最后一个是运算符的情况
		if (s.matches("[\\S]*[+-/*[0-9]][+-/*][\\s]*")) {
			return "最后一个是运算符";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		}
		//匹配除数为0的情况
		if (s.matches("[\\S]*[/][0][\\S]*")){
			return "除数为0";
		}
		// 匹配空字符串情况
		if (s.length() == 0)
			return "空字符串";
		else
			return "1";
	}
}


