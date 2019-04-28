package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Check {
	
	
	public boolean checkExps(String expression, ArrayList<String> result) {
		boolean isError = false;
		String exp[] = new String[100];
		exp[0] = ".*[^0-9\\*/\\+\\-\\(\\)].*";
 		exp[1] = ".*[\\*/\\+\\-][\\*\\\\\\+\\-]+.*";
		exp[2] = ".*\\(\\).*";
		exp[3] = ".*\\([\\*/]";
		exp[4] = ".*[\\*/\\+\\-]\\).*";
		exp[5] = ".*[0-9]\\(.*";
		exp[6] = ".*\\)[0-9].*";
		exp[7] = "[\\*/].*";
		exp[8] = ".*[\\*/\\+\\-]";
		exp[9] = "";
		
		String errorType[] = new String[100];
		errorType[0] = "表达式内含非法字符";
		errorType[1] = "运算符连续";
		errorType[2] = "空括号";
		errorType[3] = "\"(\"后面是运算符";
		errorType[4] = "\")\"前面是运算符";
		errorType[5] = "\"(\"前面不是运算符";
		errorType[6] = "\")\"后面不是运算符";
		errorType[7] = "表达式开头有运算符";
		errorType[8] = "表达式末尾有运算符";
		errorType[9] = "空字符串";
		
		String errorInfo = "ERROR\r\n#";
		//括号匹配检测
		if (!checkBrackets(expression)) {
			errorInfo += "括号不匹配";
			isError = true;
		}
		for (int i = 0 ; i < 10; i++) {
			if (Pattern.matches(exp[i], expression)) {
				if (isError) {
					errorInfo += "、";
				}
				errorInfo += errorType[i];
				isError = true;
			}
		}
		
		if (isError) {
			System.out.println(errorInfo);
			result.add(errorInfo);
		}
		
		return isError;
	}
	
	
	public boolean checkBrackets(String exps) {
		Stack brackets = new Stack();
		char temp;
		
		for (int i = 0; i < exps.length(); i++) {
			temp = exps.charAt(i);
			if (temp == '(') {
				brackets.push(temp);
			}
			if (temp == ')') {
				if (brackets.isEmpty()) {
					return false;
				}
				else {
					brackets.pop();
				}
			}
		}
		
		if (brackets.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
