package ����ҵ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FileOperation {	
	static int count = 0;
	
	int expressionNumber() {
		return count;//������ʽ����
	}
	
	public  String[] readexpression(File f) {//��ȡ���ʽ��ȥ���ո�
		String [] expression = new String[100];
		 count = 0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {			
				expression[count]=input.nextLine();
				expression[count]=expression[count].replace(" ","");
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();		
		}
		return expression;
	}	
	
	public void writeFile(File f,String[] expression) {
		Calculator calculator = new Calculator();
		try (PrintWriter output = new PrintWriter(f);){
			for(int i = 0;i<count;i++) {
				if(calculator.errorNumber(i)==0)
					output.println(expression[i]);
				else {
					output.println("ERROR");
					switch(calculator.errorNumber(i)) {
					case 1:
						output.println("#���ʽ�зǷ��ַ�");
					break;
					case 2:
						output.println("#�����ź����������");
					break;
					case 3:
						output.println("#������ǰ���������");
					break;
					case 4:
						output.println("#������");
					break;
					case 5:
						output.println("#С���ź�������������ŷ����һ���ַ�");
					break;
					case 6:
						output.println("#С����ǰ������������ŷ����һ���ַ�");
					break;
					case 7:
						output.println("#�����ǰ��������");
					break;
					case 8:
						output.println("#���������������");
					break;
					case 9:
						output.println("#������");
					}
				}
					
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}


class Calculation {

	 String[] main(String[] expression){
		Calculator calculator = new Calculator();
		FileOperation fo = new FileOperation();
		int i,error,data;
		String result[]=new String[100];
		for(i=0;i<fo.expressionNumber();i++) {	
			error=calculator.errorNumber(i);
			if(error==0) {
				data = evaluateExpression(expression[i]);//����
				result[i] = String.valueOf(data);
				expression[i] = expression[i].concat("=");
				expression[i] = expression[i].concat(result[i]);
			}
		}
		return expression;
	}
    static String insetBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }
    
	 static int evaluateExpression(String expression) {
	        Stack<Integer> operandStack = new Stack<>();
	        Stack<Character> operatorStack = new Stack<>();
	        expression = insetBlanks(expression);
	        String[] tokens = expression.split(" ");
	        for (String token : tokens) {
	            if (token.length() == 0)   
	                continue;
	            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
	                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
	                    processAnOperator(operandStack, operatorStack);   
	                }
	                operatorStack.push(token.charAt(0)); 
	            }
	            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
	                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
	                    processAnOperator(operandStack, operatorStack);
	                }
	                operatorStack.push(token.charAt(0));  
	            }
	            else if (token.trim().charAt(0) == '(') {
	                operatorStack.push('(');
	            }
	            else if (token.trim().charAt(0) == ')') {
	                while (operatorStack.peek() != '(') {
	                    processAnOperator(operandStack, operatorStack);  
	                }
	                operatorStack.pop();   
	            }
	            else {
	                operandStack.push(Integer.parseInt(token));  
	            }
	        }
	        while (!operatorStack.isEmpty()) {
	            processAnOperator(operandStack, operatorStack);
	        }
	        return operandStack.pop(); 
	    } 
	 
	 
	    static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
	        char op = operatorStack.pop(); 
	        int op1 = operandStack.pop();
	        int op2 = operandStack.pop();
	        if (op == '+')  
	            operandStack.push(op1 + op2);
	        else if (op == '-')
	            operandStack.push(op2 - op1); 
	        else if (op == '*')
	            operandStack.push(op1 * op2);
	        else if (op == '/')
	            operandStack.push(op2 / op1);
	    }   
}



public class Calculator {
	static int errorNumber[] = new int[100];//��¼�����ԭ��
	int errorNumber(int i) {
		return errorNumber[i];
	}
	static String[] isRight() {
		FileOperation fo = new FileOperation();
		File f = new File("src\\expression");
		String [] expression =fo.readexpression(f);	 
		for(int i = 0;i<fo.expressionNumber();i++) {
			
			errorNumber[i] = 0;
			if(expression[i].matches("[0-9+\\-*/()\\s]+")==false) {//�Ƿ�����
				errorNumber[i] = 1;
			}
			Pattern pattern = Pattern.compile("\\([\\+\\-\\*\\/]");
			Matcher matcher = pattern.matcher(expression[i]);
			 if(matcher.find()) {
				errorNumber[i] = 2;//�����ź����������,���������
			} 
			 pattern = Pattern.compile("[\\+\\-\\*\\/]\\)");
			 matcher = pattern.matcher(expression[i]);
			 if(matcher.find()) {
				errorNumber[i] = 3;//������ǰ���������,���������
			}
			 
			 if(expression[i].matches("\\(\\)")==true) {
				errorNumber[i] = 4;//������//
			}
			 
			pattern = Pattern.compile("\\)\\d");
			matcher = pattern.matcher(expression[i]);
			if(matcher.find()) {
				errorNumber[i] = 5;//С���ź�������������ŷ����һ���ַ�
			}
			pattern = Pattern.compile("\\d\\(");
			matcher = pattern.matcher(expression[i]);
			if(matcher.find()) {
				errorNumber[i] = 6;//С����ǰ������������ŷ����һ���ַ�
			}
			
			pattern = Pattern.compile("[\\+\\-\\*\\/]{2,}");//���������	
			matcher = pattern.matcher(expression[i]);
			if(matcher.find()) {
				errorNumber[i] = 7;//�����ǰ��������
			}
			
			pattern = Pattern.compile("[\\+\\-\\*\\/]$");//���������	
			matcher = pattern.matcher(expression[i]);
			if(matcher.find()) {
				errorNumber[i] = 8;//���������������
			}
			
			pattern = Pattern.compile("[\\S]");
			matcher = pattern.matcher(expression[i]);
			if(matcher.find()==false)
					errorNumber[i] = 9;
			 
			 
			System.out.println(errorNumber[i]);
			
		}
		return  expression;
	}
	
	public static void main(String[] args) {
		FileOperation fo = new FileOperation();
		File f = new File("src\\expression");//��ȡ�ļ�������
		String[] expression = new String[100];
		String[] result = new String[100];
		expression=isRight();//�ж���ȷ��������
		Calculation calculation = new Calculation();	
		result=calculation.main(expression);//������м���
		fo.writeFile(f,result);//�����д���ĵ���
		
	}

}






