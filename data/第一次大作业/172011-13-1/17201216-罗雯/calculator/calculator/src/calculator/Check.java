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
		errorType[0] = "���ʽ�ں��Ƿ��ַ�";
		errorType[1] = "���������";
		errorType[2] = "������";
		errorType[3] = "\"(\"�����������";
		errorType[4] = "\")\"ǰ���������";
		errorType[5] = "\"(\"ǰ�治�������";
		errorType[6] = "\")\"���治�������";
		errorType[7] = "���ʽ��ͷ�������";
		errorType[8] = "���ʽĩβ�������";
		errorType[9] = "���ַ���";
		
		String errorInfo = "ERROR\r\n#";
		//����ƥ����
		if (!checkBrackets(expression)) {
			errorInfo += "���Ų�ƥ��";
			isError = true;
		}
		for (int i = 0 ; i < 10; i++) {
			if (Pattern.matches(exp[i], expression)) {
				if (isError) {
					errorInfo += "��";
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
