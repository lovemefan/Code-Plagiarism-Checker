package assignment_one;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestExpression {
	
	public static boolean  testExpression(String expression,File p ) throws IOException {
		FileWriter outputfile = new FileWriter(p,true);
		if(nullexpression(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#表达式为空"+"\n\n");
			outputfile.close();
			return false;
		}
		if(bullBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#表达式中有空括号"+"\n\n");
			outputfile.close();
			return false;
		}
		if(illegalCharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#表达式包含非法字符"+"\n\n");
			outputfile.close();
			return false;
		}
		if(matchBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#表达式括号不匹配"+"\n\n");
			outputfile.close();
			return false;
		}
		if(characterContinue(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#运算符连续"+"\n\n");
			outputfile.close();
			return false;			
		}
		if(excharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#运算符前无运算数"+"\n\n");
			outputfile.close();
			return false;
		}
		if(postcharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#运算符后无运算数"+"\n\n");
			outputfile.close();
			return false;	
		}
		if(exBrackets (expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#括号非第一个字符且之前无运算符"+"\n\n");
			outputfile.close();
			return false;
		}
		if(postBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#小括号后无运算数括号非最后一个字符"+"\n\n");
			outputfile.close();
			return false;
		}
		outputfile.close();
		return true;
		
	}
	
	public static boolean nullexpression(String expression){//判断表达式是否为空，为空返回true
		if(expression.length()==0 ||expression.matches("\\s+"))
			return true;
		return false;
	}
	
	public static boolean bullBrackets(String expression){//判断表达式是否含有空括号，有返回true
		expression = expression.replaceAll("\\s+","");
		String string = "";
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '(')
				for(int j = i + 1; j < expression.length(); j++){
					if(expression.charAt(j)!=')')
						string += expression.charAt(j);
					else{
						if(string.length()==0)
							return true;
					}
				}
		}
		return false;
	}

	public static  boolean illegalCharacter(String expression) {//判断表达式是否包含非法字符，有返回true
		for(int i = 0; i < expression.length(); i++){
			char present = expression.charAt(i);
			if(present ==' ')
				continue;
			if(!TransferExpression.judgedigital(present))
				switch(present){
				case '+':
				case '-':
				case '*':
				case '/':
				case '(':
				case ')':
					return false;
				default:
					return true;
			}
		}
		return false;
	}
	
	public static boolean matchBrackets(String expression){//判断表达式中是否有括号不匹配，括号不匹配返回true
		StackOfChar stack = new StackOfChar();
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '('){
				stack.push(expression.charAt(i));
			}
			else{
				if(expression.charAt(i) == ')'){
					stack.pop();
				}
				else
					continue;
			}
		}
		if(!stack.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static boolean characterContinue(String expression) {//判断表达式中是否有运算符连续，连续返回true
		for(int i = 0; i < expression.length()-1; i++){
			if ((expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/')&&
				(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/')){
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean excharacter(String expression) {//判断表达式中是否包含运算符前无运算数的情况，包含返回false
		if(expression.matches(".*[(][\\+\\-\\*\\/].*|^[\\+\\-\\*\\/].*")){
			return true;
		}
		return false;
	}
	
	public static boolean postcharacter(String expression) {//判断表达式中是否包含运算符后运算数，包含返回false
		if(expression.matches(".*[\\+\\-\\*\\/][)].*|.*[\\+\\-\\*\\/]$")){
			return true;
		}
		return false;
	}
	
	public static boolean exBrackets (String expression) {//判断表达式中是否包含括号非第一个字符，且之前无运算符，包含返回false
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '(' ){
				if( i != 0 && TransferExpression.judgedigital(expression.charAt(i-1)))
				return true;
			}
		}
		return false;
	}
	
	public static boolean postBrackets (String expression) {//判断表达式中是否包含小括号后无运算符，括号非最后一个字符，包含返回false
		for(int i = 0; i < expression.length()-1; i++){
			if( expression.charAt(i) == ')' ){
				if(i!=expression.length()-1 && TransferExpression.judgedigital(expression.charAt(i+1)))
				return true;
			}
		}
		return false;
	}
}
