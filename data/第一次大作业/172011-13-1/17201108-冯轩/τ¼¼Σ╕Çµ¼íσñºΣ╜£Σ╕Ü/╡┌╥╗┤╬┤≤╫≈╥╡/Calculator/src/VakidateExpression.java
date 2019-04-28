import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VakidateExpression {
	
	static String[] regexStr = new String[7];
	static String regexParenthesis = "\\(|\\)";
	static String parenthesisResult = "";
	static String statusString[] = {"ERROR\n#非法字符","ERROR\n#操作符连续","ERROR:\n#'('左边相连数字","ERROR\n#')'右边相连数字","ERROR\n#括号与运算符直接相连"
			,"ERROR\n#非法空行","ERROR\n#非法'()'"};
	static {

	regexStr[0]= "^\\s*$|[\\+\\*-/\\(\\)\\d]{1,}"; // 匹配 非法字符   反向匹配
	regexStr[1]= "[\\+-/\\*]{2,}";// 匹配操作符是否连续
	regexStr[2]= "\\d\\("; // ‘(’左边相连数字
	regexStr[3]= "\\)\\d"; // ‘)’右边相连数字
	regexStr[4]= "[-\\+/\\*]\\)|\\([-\\+/\\*]";
	regexStr[5]= "^\\s*$";
	regexStr[6]= "\\(\\)";
	}
	public static String isLegalExpression(String str){
		str = str.replaceAll("\\s+","");//替换字符串中的空格
		//System.out.println(str);
		if (!str.matches(regexStr[0])){ //匹配非法字符
			return statusString[0];
		}
		//编译正则表达式
		for (int i = 1; i < regexStr.length; i ++){
			Pattern pattern = Pattern.compile(regexStr[i]);
			Matcher matcher = pattern.matcher(str);
			if(matcher.find() == true){
				return statusString[i];
			}
		}
		Pattern pattern = Pattern.compile(regexParenthesis);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			parenthesisResult += matcher.group();
		}
		if (!isLegalParenthesis(parenthesisResult)){
			return "ERROE:#\n括号不匹配！";
		}
		return "legal";
	}
	
	//判断括号是否匹配
	private static boolean isLegalParenthesis(String parenthesisResult){
		int left = 0;
		for (int i = 0; i < parenthesisResult.length(); i ++){
			if (parenthesisResult.charAt(i) == '('){
				left ++;
			} else {
				left --;
			}
			if (left < 0){
				return false;
			}
		}
		if (left != 0){
			return false;
		}
		return true;
	}
	
	//删除重复的请求
	public static String[] removeRepetition(String[] strs){
		for (int i = 0; i < strs.length; i++){
			strs[i] = strs[i].replaceAll("//s+", "");
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < strs.length; i++){
			if(!list.contains(strs[i]) || strs[i].equals("")){
				list.add(strs[i]);
			}
		}	
		String[] newStrs = list.toArray(new String [1]);
		return newStrs;
	}
}
