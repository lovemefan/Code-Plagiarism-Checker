package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CheckStr {
    String str = "";//需要验证的字符串
    boolean isTrue = true;
    String error;

    //传参构造方法，传入要验证的字符串
    public CheckStr(){
    
    }
    
	public CheckStr(String newStr){
		str = newStr;
	}
	
	// 获得字符串
	public String getStr(){
		return str;
	}
		
	// 获得isTrue的值
	public boolean getIsTrue(){
		return isTrue;
	}
		
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
	
	//判断表达式中有空括号
	public void judgeEmptyBracket() {
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i)=='(' && str.charAt(i+1)==')') {
				error = "ERROR\r\n#表达式中有空括号";
			}	
		}
	}	
	// 判断表达式中是否包含非法字符（除+，-，*，/，（，）和数字外的字符）
	public void judgeOtherChar(){
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			error = "ERROR\r\n#表达式包含非法字符";
			isTrue = false;
		}
	}
	// 判断括号是否匹配
	public void judgeBracket(){
		int Num = 0;//括号的数量
		for (int i=0;i<str.length();i++){
			if (str.charAt(i) == '(')
				Num += 1;
			else if (str.charAt(i) ==')')
				Num += -1;
			if (Num < 0){ //右括号比左括号先出现
				error = "ERROR\r\n#括号不匹配";
				isTrue = false;
			}
		}
		if (Num != 0){ //左右括号数量不等
			error = "ERROR\r\n#括号不匹配";
			isTrue = false;	
		}
	}	
	// 判断运算符是否连续
	public void judgeChar(){
		String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[\\(][\\+\\*\\/]","[\\+\\-\\*\\/][\\)]",
				"[0-9][\\(]","[\\)][0-9]"};//"[\\(][\\)]"
		for (int i = 0;i < s.length;i ++){
		    Pattern pattern = Pattern.compile(s[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()){
			    error = "ERROR\r\n#运算符连续";
			    isTrue = false;
		    }
		}
	}
	// 判断运算符前，后有无运算数（即首尾出现运算符）
	public void judgeStartAndEnd(){
		if (str.charAt(0) == '+'||str.charAt(0) == '-'||str.charAt(0) == '*'||str.charAt(0) == '/')	
		{
			error = "ERROR\r\n#运算符前无运算数";
			isTrue = false;
		}
		if (str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-' || str.charAt(str.length()-1)=='*' || str.charAt(str.length()-1)=='/')
		{
			error = "ERROR\r\n#运算符后无运算数";
			isTrue = false;
		}
	}			
	//小括号非第一个字符但之前无运算数
		
	//小括号非最后一个字符但之后无运算数
		
	
	//所有的错误情况放在一起，并返回一个布尔值
	public boolean judgeAll(){
		cancelSpace();  // 消去空格符
		judgeEmptyBracket();//判断表达式中是否有空括号
		judgeOtherChar(); // 判断是否有非法字符
		judgeBracket(); // 判断括号是否匹配
		judgeChar(); // 判断运算符是否连续
		judgeStartAndEnd(); // 判断运算符前，后有无运算数
		return isTrue;
	}	
		
	//所有的错误情况都放在一起，并返回一个错误原因
	public String error(){
		cancelSpace();  // 消去空格符
		judgeEmptyBracket();//判断表达式中是否有空括号
		judgeOtherChar(); // 判断是否有其他字符
		judgeBracket(); // 判断括号是否匹配
		judgeChar(); // 判断运算符和括号的运用是否出错	
		judgeStartAndEnd(); // 判断运算符前，后有无运算数
		return error;
	}		
}
