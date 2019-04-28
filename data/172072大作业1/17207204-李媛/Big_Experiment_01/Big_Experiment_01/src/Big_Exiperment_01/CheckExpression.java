package Big_Exiperment_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpression {
	private static int i = 0;
	
	
	//������ʽ���Ƿ�Ϊ��
	public static void checkNullString(String str,PrintWriter output) {
		str = str.trim();
		if(str.equals("")) {
			str = "  ";
			output.print("\n" + "ERROR"+ "\n" + "#���ʽΪ��");
			i++;
		}
	}
	
	//������ʽ���Ƿ��ǿ�����
	public static void checkEmptyBrackers(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("\\(\\s*(?=\\))");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ʽ���п�����");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ���Ƿ��зǷ��ַ�
	public static void checkIllegalCharacter(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("(?=.*[^\\s\\d\\+\\-\\*\\/\\(\\)])");	//������˳���+-*/����()֮����ַ�
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ʽ�����Ƿ��ַ�");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ�������Ƿ�ƥ��
	public static void checkBracketMismatch(String str,PrintWriter output) {
		int num1 = 0;
		int num2 = 0;
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) == '(') {
				num1++;
			}
			if(str.charAt(i) == ')') {
				num2++;
			}
			if(num2 > num1) {
				output.print("\n" + "ERROR"+ "\n" + "#���Ų�ƥ��");
				i++;
			}
		}
		if(num1 != num2) {
			output.print("\n" + "ERROR"+ "\n" + "#���Ų�ƥ��");
			i++;
		}
	}
	
	//������ʽ��������Ƿ�����
	public static void checkOperationCharacterContinue(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("[\\+\\-\\*\\/]\\s*[\\+\\-\\*\\/]");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���������");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ��������Ƿ���Ч�������ǰ����������
	public static void checkOperationCharacterFrontNotnumber(String str,PrintWriter output) {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("\\(\\s*[\\*\\/\\+]");
		Pattern pattern1 = Pattern.compile("^[\\+\\*\\/]");
		Matcher matcher1 = pattern1.matcher(str1);
		Matcher matcher = pattern.matcher(str1);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#�����ǰ��������");
			i++;
		}
		matcher.reset(str1);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#�����ǰ��������");
			i++;
		}
		matcher.reset(str1);
	}
	
	//������ʽ��������Ƿ���Ч�������������������
	public static void checkOperationCharacterBehindNotnumber(String str,PrintWriter output) {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("([\\+\\-\\*\\/]\\s*\\))");
		Pattern pattern1 = Pattern.compile("([\\+\\-\\*\\/]\\s*)$");
		Matcher matcher1 = pattern1.matcher(str1);
		Matcher matcher = pattern.matcher(str1);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���������������");
			i++;
		}
		matcher.reset(str1);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���������������");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ��������Ƿ���Ч��С����ǰ�������������ŷǵ�һ���ַ���
	public static void checkBracketFrontNotnumber(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("^((\\s*)([\\+\\-\\*\\/]+\\s*)(\\())");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ŷǵ�һ���ַ���֮ǰ��������");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ��������Ƿ���Ч��С���ź��������������ŷ����һ���ַ�
	public static void checkBracketBehindNotnumber(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("([\\)](\\s*)([\\+\\-\\*\\/]+\\s*))$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#С���ź��������������ŷ����һ���ַ�");
			i++;
		}
		matcher.reset(str);
	}
	
	//��������֮��û�������
	public static void checkBracketBehindNotOperator(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("\\)\\s*\\d");
		Pattern pattern1 = Pattern.compile("\\)\\s*\\(");
		Pattern pattern2 = Pattern.compile("\\d\\s*\\(");	
		Matcher matcher2 = pattern2.matcher(str);
		if(matcher2.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ź���֮��Ҫ�������");
			i++;
		}
		Matcher matcher1 = pattern1.matcher(str);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ź�����֮��Ҫ�������");
			i++;
		}
		matcher1.reset(str);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#���ź���֮��Ҫ�������");
			i++;
		}
		matcher.reset(str);
	}
	
	//������ʽ�Ƿ���ȷ
	public static String check(String str,PrintWriter output) {
		checkNullString(str,output);
		checkEmptyBrackers(str,output);
		checkIllegalCharacter(str,output);
		checkBracketMismatch(str,output);
		checkOperationCharacterContinue(str,output);
		checkOperationCharacterFrontNotnumber(str,output);
		checkBracketBehindNotnumber(str,output);
		checkOperationCharacterBehindNotnumber(str,output);
		checkBracketFrontNotnumber(str,output);
		checkBracketBehindNotOperator(str,output);
		if(i != 0)
		{
			output.println();
			return "haserror";
		}
		else
			return "";
	}
	
}
