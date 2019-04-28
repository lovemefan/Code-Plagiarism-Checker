package calcultor;

import java.util.regex.*;

public class Check {
	private String str = ""; // 需要验证的字符串
	private boolean isTrue = true;
	// 传参构造方法，传入要验证的字符串
	public Check(String newString){
		this.str = newString;
	    this.isTrue = true;
	}
	// 获得字符串str
	public String getStr(){
		return str;
	}
	// 消去空格符
	public void skipSpace(){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			s1 += matcher.group();
		}
		str = s1;
	}
	// 判断是否有其他字符
	public void checkOthers(){
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			System.out.println(str);
			System.out.println("ERROR\n表达式中含有不合法字符");
			isTrue = false;
			return;
		}
	}
	// 判断运算符是否连续，运算符和括号两边是否正确
	public void checkSymbol(){
		String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[^0-9\\)][\\+\\-\\*\\/]","[\\+\\-\\*\\/][^0-9\\(]","[0-9][\\(]","[\\)][0-9]","[\\(][\\)]"};
		for (int i = 0;i < s.length;i ++){
		    Pattern pattern = Pattern.compile(s[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()){
		    	System.out.println(str);
			    System.out.println("ERROR\n表达式中运算符或括号使用错误");
			    isTrue = false;
			    return;
		    }
		}
	}
	// 判断括号是否匹配
	public void checkBracket(){
		int bracketNum = 0;
		for (int i = 0;i < str.length();i ++){
			if (str.charAt(i) == '(')
				bracketNum += 1;
			if (str.charAt(i) ==')')
				bracketNum += -1;
			if (bracketNum < 0){ //右括号比左括号先出现
				System.out.println(str);
				System.out.println("ERROR\n表达式中括号运用错误");
				isTrue = false;
				return;
			}
		}
		if (bracketNum != 0){ // 左右括号数量不等
			System.out.println(str);
			System.out.println("ERROR\n表达式中括号运用错误");
			isTrue = false;
			return;
		}
	}
	// 判断表达式首尾出现运算符并调整
	public void checkStartAndEnd(){
		if (str.charAt(0) == '-'||str.charAt(0) == '+')
			str = "0" + str;
		else if(str.charAt(0) == '*'||str.charAt(0) == '/'){
			System.out.println(str);
			System.out.println("ERROR\n表达式首运算符使用错误");
			isTrue = false;
			return;
		}
		if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
			System.out.println(str);
			System.out.println("ERROR\n表达式尾运算符使用错误");
			isTrue = false;
			return;
		}
	}
	// 判断并调整数字以0开头
	public void checkZero(){
		String s = "[\\+\\-\\*\\/\\(][0][0-9]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()||(str.charAt(0) == '0' && Character.isDigit(str.charAt(1)))){
			System.out.println(str);
			System.out.println("ERROR\n表达式中含有以0开头的数字");
			isTrue = false;
			return;
		}
	}
	// 所以判断操作集合
	public boolean checkAll(){
		skipSpace(); // 消去空格符
		checkZero();// 判断并调整数字以0开头
		checkOthers(); // 判断是否有其他字符
		checkSymbol(); // 判断运算符和括号的运用是否出错
		checkStartAndEnd(); // 判断表达式首尾出现运算符并调整
		checkBracket(); // 判断括号的数量是否正确
		return isTrue;
	}	
}
