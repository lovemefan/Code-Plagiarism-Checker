package Ceshi;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Stack;
import java.util.Queue;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
public class Calculator {
	public static void main(String[] args) throws FileNotFoundException   {
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new  LinkedList<String>();
		String[] expression = new String[20];
		String[] legalExpression = new String[20];
		java.io.File file = new java.io.File("C:\\Users\\y\\eclipse-workspace\\Calculator\\src\\Ceshi\\cal.txt");
		Scanner input =new Scanner(file);
		int n=0;
		while(input.hasNextLine()) {
			expression[n]=input.nextLine();
			n++;
		}
		input.close();
		for(int i=0;i<n;i++) {
			expression[i]=expression[i].replace(" ","");//忽略空格
		}
		int k=1;
		for(int i=0;i<n;i++,k++) {
			int j=k;
			for( ;j<n;j++) {
				if(expression[i].equals(expression[j])) {
					break;
				}
			}
			if(j==n) {
				queue.add(expression[i]);
			}
		}
		k=0;
		while(!queue.isEmpty()) {
			expression[k++]=queue.poll();
		}
		int m=0;
		for(int i=0;i<k;i++) {
			if(checkExpressionValid(expression[i])) {
				legalExpression[m++]=expression[i];
			}
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for(int i=0;i<m;i++) {
			for(int j=0;j<legalExpression[i].length();j++) {
				String string=String.valueOf(legalExpression[i].charAt(j));
				if(Character.isDigit(string.charAt(0))) {
					char ch;
					String string2="";
					while(Character.isDigit(ch=(legalExpression[i].charAt(j)))) {//如果是数字就按字符串加起来
						string2+=ch;
						if((++j)>legalExpression[i].length()-1) {//如果数字到了底则跳出循环
							break;
						}
					}
					queue.add(string2);//将数字字符串放入队列
					if(j>expression[i].length()-1) {
						break;
					}else {
					j--;
					}
				}else if(string.equals("(")) {//碰到("直接压入栈
					stack.push(string);
				}else if(string.equals(")")) {
					String ch;
					while(!((ch=stack.pop()).equals("("))&&!stack.isEmpty()) {
					queue.add(ch);
					}
				}else if(string.equals("+")) {
					if(stack.isEmpty()) {
						stack.push("+");
					}else {
						String ch = null;	
						while(!stack.isEmpty()){
							    ch=stack.pop();
								if(ch.equals("(")) {
									stack.push(ch);
									stack.push("+");
									break;
								}else {
									queue.add(ch);
								}
						}
						if(stack.isEmpty()) {
							stack.push("+");
						}
					}
				}else if(string.equals("-")) {
					if(stack.isEmpty()) {
						stack.push("-");
					}else {
						String ch = null;	
						while(!stack.isEmpty()){
							    ch=stack.pop();
								if(ch.equals("(")) {
									stack.push(ch);
									stack.push("-");
									break;
								}else {
									queue.add(ch);
								}
						}
						if(stack.isEmpty()) {
							stack.push("-");
						}	
					}
				}else if(string.equals("*")) {
					if(stack.isEmpty()) {
						stack.push("*");
					}else {
						String ch;
						while(!stack.isEmpty()){
							    ch=stack.pop();
								if(ch.equals("(")) {
									stack.push(ch);
									stack.push("*");
									break;
								}else if(!operatorCompare("*",ch)) {
									queue.add(ch);
								}else if(operatorCompare("*",ch)){	
									stack.push(ch);
									stack.push("*");
									break;
								}	
						}
						if(stack.isEmpty()) {
							stack.push("*");
						}
					}	
				}else if(string.equals("/")) {
					if(stack.isEmpty()) {
						stack.push("/");
					}else {
						String ch;
						while(!stack.isEmpty()){
							    ch=stack.pop();
								if(ch.equals("(")) {
									stack.push(ch);
									stack.push("/");
									break;
								}else if(!operatorCompare("/",ch)) {
									queue.add(ch);
								}else if(operatorCompare("/",ch)){	
									stack.push(ch);
									stack.push("/");
									break;
								}	
						}
						if(stack.isEmpty()) {
							stack.push("/");
						}
						}
					}	
				}
			while(!stack.isEmpty()) {
				queue.add(stack.pop());
			}
			while(!queue.isEmpty()) {
				String string=queue.poll();
				if(Character.isDigit((string).charAt(0))) {
				stack.push(string);
				}else {
					int value2=Integer.parseInt(stack.pop());
					int value1=Integer.parseInt(stack.pop());
					if(string.charAt(0)=='+') {
						int value=value1 + value2;
						stack.push(String.valueOf(value));
					}else if(string.charAt(0)=='-') {
						int value=value1 - value2;
						stack.push(String.valueOf(value));
					}else if(string.charAt(0)=='*') {
						int value=value1 * value2;
						stack.push(String.valueOf(value));
					}else if(string.charAt(0)=='/') {
						int value=value1 / value2;
						stack.push(String.valueOf(value));
					}
				}
			}
			if(!stack.isEmpty()) {
			output.println(expression[i] + "="+ stack.pop());
			}
			}
			output.close();
	}
	public static boolean checkExpressionValid(String input) { 
		String pattern = "-?[\\d]+(\\.[\\d]+)?([+\\-*/]{1}-?[\\d]+(\\.[\\d]+)?)*";
	    boolean isMatch = false;
	    int leftBracket=0,rightBracket=0;
	    for(int i=0;i<input.length();i++) {//判断左右括号数量是否匹配
	    	if(input.charAt(i)=='(') {
	    		leftBracket++;
	    	}else if(input.charAt(i)==')') {
	    		rightBracket++;
	    	}
	    }
	    if(leftBracket!=rightBracket) {
	    	
	    	return false;
	    }
	    input=input.replace("(","");//去除左括号
	    input=input.replace(")","");//去除右括号
	    isMatch=input.matches(pattern);//匹配无括号表达式是否合法
		return isMatch;
	}	
	
	
	public static boolean operatorCompare(String ch1,String ch2) {
		if(stringInt(ch1)>stringInt(ch2)) {
			return true;
		}else {
			return false;
		}
	}
	public static int stringInt(String ch) {
			if(ch.equals("+")||ch.equals("-")) {
				return 1;
			}else {
				return 2;
			}
	}
}
//异常输入类
class ExpWrong{
		
		boolean wrong(String ch) {
			if(!exp_Empty(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式为空！\n");
				return false;
			}
			if(!exp_Bracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中有空括号！\n");
				return false;
			}
			if(!exp_IllegalChar(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式包含非法字符！\n");
				return false;
			}
			if(!exp_Mismatch(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中括号不匹配！\n");
				return false;
			}
			if(!exp_OperContinuity(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中运算符连续！\n");
				return false;
			}
			if(!exp_BeforeOperator(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中运算符前无运算数！\n");
				return false;
			}
			if(!exp_AfterOperator(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中运算符后无运算数！\n");
				return false;
			}
			if(!exp_AfterEqualSign(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中=不是最后一个字符！\n");
				return false;
			}
			if(!exp_beforeLeftBracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中(非第一个字符且(前无运算符！\n");
				return false;
			}
			if(!exp_afterRightBracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#表达式中)后无运算符或等号！\n");
				return false;
			}
			return true;
		}
		
		boolean exp_Empty(String ch){//判断表达式是否为空
			if(ch.equals(""))
				return false;
			return true;
		}
		
		boolean exp_Bracket(String ch) {//判断表达式是否有空括号
			for(int i=0;i<ch.length();i++) {
				if(ch.charAt(i)=='('&&ch.charAt(i+1)==')')
					return false;
			}
			return true;
		}
		
		boolean exp_IllegalChar(String ch){//判断表达式是否有非法字符
			Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\(\\)\\=]");
			for(int i=0;i<ch.length()-1;i++) {
				Matcher match = pattern.matcher(ch.substring(i,i+1));
				if(match.matches())
					return false;
			}
			return true;
		}
		
		boolean exp_Mismatch(String ch){//表达式中括号不匹配
			int num=0;
			for(int i=0;i<ch.length();i++) {
				char c = ch.charAt(i);
				if(c=='(')
					num++;
				else if(c==')') {
					if(num==0)//无左括号却有一个右括号
						return false;
					else
						num--;
				}
			}
			if(num!=0)
				return false;
			return true;
		}
		
		boolean exp_OperContinuity(String ch){//表达式中运算符连续
			Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		
		boolean exp_BeforeOperator(String ch) {//运算符前无运算数
			Pattern pattern = Pattern.compile("^[\\+\\-\\*\\/].*||.*[(][\\+\\*\\/].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		
		boolean exp_AfterOperator(String ch) {//运算符后无运算数
			Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\=]$||.*[\\+\\-\\*\\/][)].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		boolean exp_AfterEqualSign(String ch) {//等号后面还有字符
			Pattern pattern = Pattern.compile(".*[\\=]$");
				Matcher match = pattern.matcher(ch);
				if(!match.matches())
					return false;
			return true;
		}
		
		boolean exp_beforeLeftBracket(String ch) {//表达式中(非第一个字符且(前无运算符
			Pattern pattern = Pattern.compile(".*[0-9][(].*");
			for(int i=0;i<ch.length()-2;i++) {
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			}
			return true;
		}
		
		boolean exp_afterRightBracket(String ch) {//表达式中)后不是运算符或等号！
			Pattern pattern = Pattern.compile(".*[)][0-9].*");
			for(int i=0;i<ch.length()-2;i++) {
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			}
			return true;
		}
	}
