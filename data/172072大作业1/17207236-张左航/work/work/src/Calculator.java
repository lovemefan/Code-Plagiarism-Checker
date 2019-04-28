import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {
	public static void main(String[] args) throws FileNotFoundException   {
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new  LinkedList<String>();
		String[] expression = new String[20];
		String[] legalExpression = new String[20];
		java.io.File file = new java.io.File("src\\expression");
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
	    Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//匹配非法字符
		Matcher m2 = regularString2.matcher(input);
		if(m2.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式包含非法字符");
			return false;
		}
		Pattern regularString = Pattern.compile("\\s");//匹配空表达式
		Matcher m = regularString.matcher(input);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#表达式为空");
			return false;
		}
		Pattern regularString1 = Pattern.compile("\\(\\)");//匹配空括号
		Matcher m1 = regularString1.matcher(input);
		if(m1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式中有空括号");
			return false;
		}

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
	    input=input.replace(")","");//去除右括号*
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






