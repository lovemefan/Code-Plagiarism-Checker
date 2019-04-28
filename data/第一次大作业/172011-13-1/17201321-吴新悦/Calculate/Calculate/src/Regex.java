
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {
	public String[] judgeRegex(String[] str,int l){
		String[] error = {"(\\(\\)){1}","\\((\\+|\\*|\\/)","[\\+\\-\\*\\/]\\)",
				"\\d\\(","^\\s*$","。*[\\+\\-\\*\\/\\(]$","[\\+\\-\\*\\/]{2}","^[\\+\\*\\/\\)]"};
		String[] errorMessage = {"\r\nERROR\r\n#出现空括号","\r\nERROR\r\n#（后出现运算符",
				"\r\nERROR\r\n#）前出现运算符","\r\nERROR\r\n#（前不是运算符","\r\nERROR\r\n#空白字符",
				"\r\nERROR\r\n#以非法字符结尾","\r\nERROR\r\n#连续出现两次运算符","\r\nERROR \r\n#以非法字符开头"};
		for(int i = 0;i<l;i++){
			System.out.println(str[i]);
			if(!str[i].contains("ERROR")){
				for(int j = 0;j<error.length;j++){
				Pattern  pattern = Pattern.compile(error[j]);
	            Matcher matcher = pattern.matcher(str[i]); 
			     if(matcher.find()) {
			         str[i]+=errorMessage[j];
			     	}
				}
				 str[i] = judgeKuohao(str[i]);//判断左右括号是否匹配
				 str[i] = judgeFuShu(str[i]);//对负数的处理运算
			}
			else str[i] = str[i];
		}
		return str;
	}
	
	//判断左右括号是否匹配
	public static String judgeKuohao(String s){
		int number = 0;
		for(int i =0;i<s.length();i++){
			if(s.charAt(i)=='(')
				number++;
			if(s.charAt(i)==')'){
				number--;
			}
		}
			if(number!=0)
				s+="\r\nERROR\r\n#左右括号不匹配!";
			return s;
	}
	
	//对负数的判断和处理
	public static String judgeFuShu(String s){
		Pattern  pattern = Pattern.compile("\\(\\-");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
        	s = s.replaceAll("\\(\\-", "\\(\\0\\-");
        }
        Pattern  pattern1 = Pattern.compile("^\\-");
        Matcher matcher1 = pattern1.matcher(s);
        if(matcher1.find()){
        	s = s.replaceAll("^\\-", "\\0\\-");
        }
        return s;
	}
	
}
