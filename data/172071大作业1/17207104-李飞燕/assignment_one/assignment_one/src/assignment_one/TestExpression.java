package assignment_one;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestExpression {
	
	public static boolean  testExpression(String expression,File p ) throws IOException {
		FileWriter outputfile = new FileWriter(p,true);
		if(nullexpression(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���ʽΪ��"+"\n\n");
			outputfile.close();
			return false;
		}
		if(bullBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���ʽ���п�����"+"\n\n");
			outputfile.close();
			return false;
		}
		if(illegalCharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���ʽ�����Ƿ��ַ�"+"\n\n");
			outputfile.close();
			return false;
		}
		if(matchBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���ʽ���Ų�ƥ��"+"\n\n");
			outputfile.close();
			return false;
		}
		if(characterContinue(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���������"+"\n\n");
			outputfile.close();
			return false;			
		}
		if(excharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#�����ǰ��������"+"\n\n");
			outputfile.close();
			return false;
		}
		if(postcharacter(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���������������"+"\n\n");
			outputfile.close();
			return false;	
		}
		if(exBrackets (expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#���ŷǵ�һ���ַ���֮ǰ�������"+"\n\n");
			outputfile.close();
			return false;
		}
		if(postBrackets(expression)){
			outputfile.write(expression+"\n"+"ERROR"+"\n"+"#С���ź������������ŷ����һ���ַ�"+"\n\n");
			outputfile.close();
			return false;
		}
		outputfile.close();
		return true;
		
	}
	
	public static boolean nullexpression(String expression){//�жϱ��ʽ�Ƿ�Ϊ�գ�Ϊ�շ���true
		if(expression.length()==0 ||expression.matches("\\s+"))
			return true;
		return false;
	}
	
	public static boolean bullBrackets(String expression){//�жϱ��ʽ�Ƿ��п����ţ��з���true
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

	public static  boolean illegalCharacter(String expression) {//�жϱ��ʽ�Ƿ�����Ƿ��ַ����з���true
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
	
	public static boolean matchBrackets(String expression){//�жϱ��ʽ���Ƿ������Ų�ƥ�䣬���Ų�ƥ�䷵��true
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
	
	public static boolean characterContinue(String expression) {//�жϱ��ʽ���Ƿ����������������������true
		for(int i = 0; i < expression.length()-1; i++){
			if ((expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/')&&
				(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/')){
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean excharacter(String expression) {//�жϱ��ʽ���Ƿ���������ǰ�����������������������false
		if(expression.matches(".*[(][\\+\\-\\*\\/].*|^[\\+\\-\\*\\/].*")){
			return true;
		}
		return false;
	}
	
	public static boolean postcharacter(String expression) {//�жϱ��ʽ���Ƿ���������������������������false
		if(expression.matches(".*[\\+\\-\\*\\/][)].*|.*[\\+\\-\\*\\/]$")){
			return true;
		}
		return false;
	}
	
	public static boolean exBrackets (String expression) {//�жϱ��ʽ���Ƿ�������ŷǵ�һ���ַ�����֮ǰ�����������������false
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '(' ){
				if( i != 0 && TransferExpression.judgedigital(expression.charAt(i-1)))
				return true;
			}
		}
		return false;
	}
	
	public static boolean postBrackets (String expression) {//�жϱ��ʽ���Ƿ����С���ź�������������ŷ����һ���ַ�����������false
		for(int i = 0; i < expression.length()-1; i++){
			if( expression.charAt(i) == ')' ){
				if(i!=expression.length()-1 && TransferExpression.judgedigital(expression.charAt(i+1)))
				return true;
			}
		}
		return false;
	}
}
