package BigHomeWork1;
// 输入校验类，判断表达式是否正确
import java.util.regex.*;

public class InputCheck {
	private String str = ""; // 需要验证的字符串
	private boolean isTrue = true;
	private int error = 0;// 记录错误的类型
	// 传参构造方法，传入要验证的字符串
	public InputCheck(String newString){
		str = newString;
	    isTrue = true;
	}
	// 获得字符串str
	public String getStr(){
		return str;
	}
	// 设置str的值
	public void setStr(String newStr){
		str = newStr;
	}
	// 获得error的值
	public int getError(){
		return error;
	}
    // 获得isTrue的值
	public boolean getIsTrue(){
		return isTrue;
	}
	// 消去空格符
	public void cancelSpace(){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			s1 += matcher.group();
		}
		str = s1;
	}
	// 判断是否有其他字符（除+，-，*，/，（，）外）
	public void judgeOtherChar(){
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			System.out.println("ERROR\n#表达式中含有不合法字符");
			isTrue = false;
			error = 1;
		}
	}
	// 判断运算符是否连续，运算符和括号两边是否正确
	public void judgeSymbol(){
		String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[\\(][\\+\\*\\/]","[\\+\\-\\*\\/][\\)]","[0-9][\\(]","[\\)][0-9]","[\\(][\\)]"};
		for (int i = 0;i < s.length;i ++){
		    Pattern pattern = Pattern.compile(s[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()){
			    System.out.println("ERROR\n#表达式中运算符或括号使用错误");
			    isTrue = false;
			    error = 2;
			    return;
			    
		    }
		}
	}
	// 判断括号是否匹配
	public void judgeBracketNumber(){
		int bracketNum = 0;
		for (int i = 0;i < str.length();i ++){
			if (str.charAt(i) == '(')
				bracketNum += 1;
			if (str.charAt(i) ==')')
				bracketNum += -1;
			if (bracketNum < 0){ //右括号比左括号先出现
				System.out.println("ERROR\n#表达式中括号匹配错误");
				isTrue = false;
				error = 3;
				return;
			}
		}
		if (bracketNum != 0){ // 左右括号数量不等
			System.out.println("ERROR\n#表达式中括号匹配错误");
			error = 3;
			isTrue = false;
		}
	}
	// 判断表达式首尾出现运算符,(-,并调整
	public void judgeStartAndEnd(){
		if (str.charAt(0) == '-'||str.charAt(0) == '+')
			str = "0" + str;
		else if(str.charAt(0) == '*'||str.charAt(0) == '/'){
			System.out.println("ERROR\n#表达式首运算符使用错误");
			error = 4;
			isTrue = false;
		}
		if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
			System.out.println("ERROR\n#表达式尾运算符使用错误");
			error = 5; 
			isTrue = false;
		}
		str = str.replace("(-", "(0-");
	}
	// 所以判断操作集合
	public boolean judgeAll(){
		cancelSpace(); // 消去空格符
		if (str == ""){
			isTrue = false; 
			return isTrue;
		}
		judgeOtherChar(); // 判断是否有其他字符
		judgeSymbol(); // 判断运算符和括号的运用是否出错
		judgeStartAndEnd(); // 判断表达式首尾出现运算符并调整
		judgeBracketNumber(); // 判断括号的数量是否正确
		return isTrue;
	}	
}
