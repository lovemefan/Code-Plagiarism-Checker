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
			expression[i]=expression[i].replace(" ","");//���Կո�
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
					while(Character.isDigit(ch=(legalExpression[i].charAt(j)))) {//��������־Ͱ��ַ���������
						string2+=ch;
						if((++j)>legalExpression[i].length()-1) {//������ֵ��˵�������ѭ��
							break;
						}
					}
					queue.add(string2);//�������ַ����������
					if(j>expression[i].length()-1) {
						break;
					}else {
					j--;
					}
				}else if(string.equals("(")) {//����("ֱ��ѹ��ջ
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
	    for(int i=0;i<input.length();i++) {//�ж��������������Ƿ�ƥ��
	    	if(input.charAt(i)=='(') {
	    		leftBracket++;
	    	}else if(input.charAt(i)==')') {
	    		rightBracket++;
	    	}
	    }
	    if(leftBracket!=rightBracket) {
	    	
	    	return false;
	    }
	    input=input.replace("(","");//ȥ��������
	    input=input.replace(")","");//ȥ��������
	    isMatch=input.matches(pattern);//ƥ�������ű��ʽ�Ƿ�Ϸ�
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
//�쳣������
class ExpWrong{
		
		boolean wrong(String ch) {
			if(!exp_Empty(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽΪ�գ�\n");
				return false;
			}
			if(!exp_Bracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ���п����ţ�\n");
				return false;
			}
			if(!exp_IllegalChar(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ�����Ƿ��ַ���\n");
				return false;
			}
			if(!exp_Mismatch(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ�����Ų�ƥ�䣡\n");
				return false;
			}
			if(!exp_OperContinuity(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ�������������\n");
				return false;
			}
			if(!exp_BeforeOperator(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ�������ǰ����������\n");
				return false;
			}
			if(!exp_AfterOperator(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ�������������������\n");
				return false;
			}
			if(!exp_AfterEqualSign(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ��=�������һ���ַ���\n");
				return false;
			}
			if(!exp_beforeLeftBracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ��(�ǵ�һ���ַ���(ǰ���������\n");
				return false;
			}
			if(!exp_afterRightBracket(ch)) {
				System.out.println(ch+"\n"+"ERROR\n#���ʽ��)�����������Ⱥţ�\n");
				return false;
			}
			return true;
		}
		
		boolean exp_Empty(String ch){//�жϱ��ʽ�Ƿ�Ϊ��
			if(ch.equals(""))
				return false;
			return true;
		}
		
		boolean exp_Bracket(String ch) {//�жϱ��ʽ�Ƿ��п�����
			for(int i=0;i<ch.length();i++) {
				if(ch.charAt(i)=='('&&ch.charAt(i+1)==')')
					return false;
			}
			return true;
		}
		
		boolean exp_IllegalChar(String ch){//�жϱ��ʽ�Ƿ��зǷ��ַ�
			Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\(\\)\\=]");
			for(int i=0;i<ch.length()-1;i++) {
				Matcher match = pattern.matcher(ch.substring(i,i+1));
				if(match.matches())
					return false;
			}
			return true;
		}
		
		boolean exp_Mismatch(String ch){//���ʽ�����Ų�ƥ��
			int num=0;
			for(int i=0;i<ch.length();i++) {
				char c = ch.charAt(i);
				if(c=='(')
					num++;
				else if(c==')') {
					if(num==0)//��������ȴ��һ��������
						return false;
					else
						num--;
				}
			}
			if(num!=0)
				return false;
			return true;
		}
		
		boolean exp_OperContinuity(String ch){//���ʽ�����������
			Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		
		boolean exp_BeforeOperator(String ch) {//�����ǰ��������
			Pattern pattern = Pattern.compile("^[\\+\\-\\*\\/].*||.*[(][\\+\\*\\/].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		
		boolean exp_AfterOperator(String ch) {//���������������
			Pattern pattern = Pattern.compile(".*[\\+\\-\\*\\/][\\=]$||.*[\\+\\-\\*\\/][)].*");
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			return true;
		}
		boolean exp_AfterEqualSign(String ch) {//�Ⱥź��滹���ַ�
			Pattern pattern = Pattern.compile(".*[\\=]$");
				Matcher match = pattern.matcher(ch);
				if(!match.matches())
					return false;
			return true;
		}
		
		boolean exp_beforeLeftBracket(String ch) {//���ʽ��(�ǵ�һ���ַ���(ǰ�������
			Pattern pattern = Pattern.compile(".*[0-9][(].*");
			for(int i=0;i<ch.length()-2;i++) {
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			}
			return true;
		}
		
		boolean exp_afterRightBracket(String ch) {//���ʽ��)�����������Ⱥţ�
			Pattern pattern = Pattern.compile(".*[)][0-9].*");
			for(int i=0;i<ch.length()-2;i++) {
				Matcher match = pattern.matcher(ch);
				if(match.matches())
					return false;
			}
			return true;
		}
	}
