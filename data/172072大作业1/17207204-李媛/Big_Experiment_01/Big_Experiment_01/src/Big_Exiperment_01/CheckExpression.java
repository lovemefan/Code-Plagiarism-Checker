package Big_Exiperment_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpression {
	private static int i = 0;
	
	
	//检验表达式中是否为空
	public static void checkNullString(String str,PrintWriter output) {
		str = str.trim();
		if(str.equals("")) {
			str = "  ";
			output.print("\n" + "ERROR"+ "\n" + "#表达式为空");
			i++;
		}
	}
	
	//检验表达式中是否是空括号
	public static void checkEmptyBrackers(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("\\(\\s*(?=\\))");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#表达式中有空括号");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式中是否有非法字符
	public static void checkIllegalCharacter(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("(?=.*[^\\s\\d\\+\\-\\*\\/\\(\\)])");	//后面接了除了+-*/数字()之外的字符
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#表达式包含非法字符");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式中括号是否匹配
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
				output.print("\n" + "ERROR"+ "\n" + "#括号不匹配");
				i++;
			}
		}
		if(num1 != num2) {
			output.print("\n" + "ERROR"+ "\n" + "#括号不匹配");
			i++;
		}
	}
	
	//检验表达式中运算符是否连续
	public static void checkOperationCharacterContinue(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("[\\+\\-\\*\\/]\\s*[\\+\\-\\*\\/]");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#运算符连续");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式中运算符是否无效（运算符前无运算数）
	public static void checkOperationCharacterFrontNotnumber(String str,PrintWriter output) {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("\\(\\s*[\\*\\/\\+]");
		Pattern pattern1 = Pattern.compile("^[\\+\\*\\/]");
		Matcher matcher1 = pattern1.matcher(str1);
		Matcher matcher = pattern.matcher(str1);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#运算符前无运算数");
			i++;
		}
		matcher.reset(str1);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#运算符前无运算数");
			i++;
		}
		matcher.reset(str1);
	}
	
	//检验表达式中运算符是否无效（运算符后无运算数）
	public static void checkOperationCharacterBehindNotnumber(String str,PrintWriter output) {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("([\\+\\-\\*\\/]\\s*\\))");
		Pattern pattern1 = Pattern.compile("([\\+\\-\\*\\/]\\s*)$");
		Matcher matcher1 = pattern1.matcher(str1);
		Matcher matcher = pattern.matcher(str1);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#运算符后无运算数");
			i++;
		}
		matcher.reset(str1);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#运算符后无运算数");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式中运算符是否无效（小括号前无运算数，括号非第一个字符）
	public static void checkBracketFrontNotnumber(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("^((\\s*)([\\+\\-\\*\\/]+\\s*)(\\())");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#括号非第一个字符且之前无运算数");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式中运算符是否无效（小括号后无运算数，括号非最后一个字符
	public static void checkBracketBehindNotnumber(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("([\\)](\\s*)([\\+\\-\\*\\/]+\\s*))$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#小括号后无运算数，括号非最后一个字符");
			i++;
		}
		matcher.reset(str);
	}
	
	//数和括号之间没有运算符
	public static void checkBracketBehindNotOperator(String str,PrintWriter output) {
		Pattern pattern = Pattern.compile("\\)\\s*\\d");
		Pattern pattern1 = Pattern.compile("\\)\\s*\\(");
		Pattern pattern2 = Pattern.compile("\\d\\s*\\(");	
		Matcher matcher2 = pattern2.matcher(str);
		if(matcher2.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#括号和数之间要有运算符");
			i++;
		}
		Matcher matcher1 = pattern1.matcher(str);
		if(matcher1.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#括号和括号之间要有运算符");
			i++;
		}
		matcher1.reset(str);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			output.print("\n" + "ERROR"+ "\n" + "#括号和数之间要有运算符");
			i++;
		}
		matcher.reset(str);
	}
	
	//检验表达式是否正确
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
