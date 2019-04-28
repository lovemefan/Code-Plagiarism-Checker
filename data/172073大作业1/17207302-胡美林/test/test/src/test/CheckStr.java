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
		
		// 判断以0开头的表达式
		public void judgeZeroInitially(){
			String s = "[0][0-9]";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()||(str.charAt(0) == '0' && Character.isDigit(str.charAt(1)))){
				error = "ERROR\r\n#表达式中含有以0开头的数字";
				isTrue = false;
			}
			/*if(str.charAt(0) == " ") {
				error = "ERROR\r\n#表达式为空";
				isTrue = false;	
			}*/
		}
		
		// 判断是否有其他字符（除+，-，*，/，（，）和数字外）
		public void judgeOtherChar(){
			String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()){
				error = "ERROR\r\n#表达式包含非法字符";
				isTrue = false;
			}
		}
		
		// 判断运算符是否连续，运算符和括号两边是否正确
		public void judgeChar(){
			String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[\\(][\\+\\*\\/]","[\\+\\-\\*\\/][\\)]",
					"[0-9][\\(]","[\\)][0-9]"};
			for (int i = 0;i < s.length;i ++){
			    Pattern pattern = Pattern.compile(s[i]);
			    Matcher matcher = pattern.matcher(str);
			    if (matcher.find()){
				    error = "ERROR\r\n#运算符连续";
				    isTrue = false;
			    }
			}
		}
		
		//判断是否有空括号
		public void judgeChar1(){
			String[] s1 = {"[\\(][\\)]"};
			for (int i = 0;i < s1.length;i ++){
			    Pattern pattern = Pattern.compile(s1[i]);
			    Matcher matcher = pattern.matcher(str);
			    if (matcher.find()){
				    error = "ERROR\r\n#表达式中有空括号";
				    isTrue = false;
			    }
			}
		}
		
		// 判断表达式首尾出现运算符
		public void judgeStartAndEnd(){
			if (str.charAt(0) == '+'||str.charAt(0) == '*'||str.charAt(0) == '/')	
		{
				error = "ERROR\r\n#运算符前无运算数";
				isTrue = false;
			}
			if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
				error = "ERROR\r\n#运算符后无运算数";
				isTrue = false;
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
					error = "ERROR\r\n#括号不匹配";
					isTrue = false;
				}
			}
			if (bracketNum != 0){ // 左右括号数量不等
				 error = "ERROR\r\n#括号不匹配";
				isTrue = false;}
		}
		
		//所有的错误情况放在一起的一个方法，并返回一个布尔值
		public boolean judgeAll(){
			cancelSpace();  // 消去空格符
			judgeOtherChar(); // 判断是否有其他字符
			judgeChar(); // 判断运算符和括号的运用是否出错
			judgeChar1();//判断是否有空括号
			judgeStartAndEnd(); // 判断表达式首尾出现运算符并调整
			judgeBracketNumber(); // 判断括号的数量是否正确
			judgeZeroInitially();//判断表达式首字符是否为0
			return isTrue;
		}	
		
		//所有的错误情况都放在一起，并返回一个字符串值
		public String error(){
			cancelSpace();  // 消去空格符
			judgeOtherChar(); // 判断是否有其他字符
			judgeChar(); // 判断运算符和括号的运用是否出错
			judgeChar1();//判断是否有空括号
			judgeStartAndEnd(); // 判断表达式首尾出现运算符并调整
			judgeBracketNumber(); // 判断括号的数量是否正确
			judgeZeroInitially();//判断表达式首字符是否为0
			return error;
		}		
}