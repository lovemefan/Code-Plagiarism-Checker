package ��һ�δ���ҵ;

import java.io.File;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1 = new File("��һ�δ���ҵ\\data");
		File f2 = new File("��һ�δ���ҵ\\anwner");
		FileOperate fo = new FileOperate();
		
		System.out.println("��ʽ���ʽ��ֵ��");
		Scanner input = new Scanner(System.in);
		
		System.out.print("������д��data�ļ������ݵ�������");
		int n = input.nextInt();
		String[] str = fo.readLine(f1,n);//��ȡ�ļ�ÿ�����ݲ���ֵ
		int[] result = new int[n];//���ʽ�����¼����
		
		CalculateExpression exp = new CalculateExpression();//��������	
		for(int i=0; i<n; i++) { 
		exp.compareOpstring(str[i]);
		result[i] = exp.opnumber.peek();//ÿ������浽������		
		}
		fo.writeFile(f2,str,result,n);//д���ļ�
	}

}
/*�����ջ*/
class StackOfChar {
	private char[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//Ĭ������
	
	public StackOfChar() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfChar(int capacity) {
		elements = new char[capacity];
	}
	/*Ԫ�ؽ�ջ*/
	public void push(char ch) {
		if(size >= elements.length) {//���ջ��
			char[] temp = new char[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = ch;
	} 
	/*Ԫ�س�ջ*/
	public char pop() {
		return elements[--size];
	}
	/*��ȡջ��Ԫ�أ�δ��ջ*/
	public char peek() {
		return elements[size - 1];
	}
	/*�ж�ջ�Ƿ�Ϊ��*/
	public boolean empty() {
		return size == 0;
	}
	/*ջ��Ԫ�ظ���*/
	public int getSize() {
		return size;
	}
}

/*������ջ*/
class StackOfInt {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//Ĭ������
	
	public StackOfInt() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfInt(int capacity) {
		elements = new int[capacity];
	}
	/*Ԫ�ؽ�ջ*/
	public void push(int ch) {
		if(size >= elements.length) {//���ջ��
			int[] temp = new int[elements.length * 2];//����һ���������������
			System.arraycopy(elements, 0, temp, 0, elements.length);//����ǰ��������ݸ��Ƶ�������
			elements = temp;//���������Ӧ�ø�ֵ��ջ�е�ǰ����
		}
		elements[size++] = ch;
	} 
	/*Ԫ�س�ջ*/
	public int pop() {
		return elements[--size];
	}
	/*��ȡջ��Ԫ�أ�δ��ջ*/
	public int  peek() {
		return elements[size - 1];
	}
	/*�ж�ջ�Ƿ�Ϊ��*/
	public boolean empty() {
		return size == 0;
	}
	/*ջ��Ԫ�ظ���*/
	public int getSize() {
		return size;
	}
}

class CalculateExpression {

		StackOfChar opstring = new StackOfChar();//��������ջ
		StackOfInt opnumber = new StackOfInt();//��������ջ  
		
		/*�ж��Ƿ����������������������������Ƚ����ȼ�Ȼ�������Ӧ������������ѹ���������ջ*/
		public void compareOpstring(String str) {
			String num = "";
			
			for(int i=0; i<str.length(); i++){
				char ch = str.charAt(i);
				if(Character.isDigit(ch)) {	
					num = num + ch;	
				}
				else {	
					if(num != "") {
						int intValue = Integer.parseInt(num);
						opnumber.push(intValue);
					}
					switch(ch){//�Ƚ�����������ȼ�������Ӧ����
						
					    case '*':
					    	break;
					    case '/':
					    	precede(ch,2);//��Ҫ�ж����ȼ�
					    	num = "";
				            break;
					
					    case '-':
					    	precede(ch,1);
					    	num = "";
					        break;
					    case '+':
					    	break;
					    case '(':
					        opstring.push(ch);//���������ȼ����ֱ�ӽ�ջ
					        num = "";
					        break;
					    case ')':
					    	rightParentheses();//�����ұ������漰��ջ
					    	num = "";
					        break;
					    default:
					    	num = "";
					        break;
					}
					
				}		
			}
			if(num != "") {
				int intValue = Integer.parseInt(num);
				opnumber.push(intValue);
			}
			while(!opstring.empty()) {
				int opChar1 = opnumber.pop();
				int opChar2 = opnumber.pop();
				char ch = opstring.pop();
				int sum = calculator(opChar1, ch, opChar2);
				opnumber.push(sum);
			}
		}
		
		/*�Ƚ���������ȼ�*/
		private void precede(char opThis, int n1) {
			
			while(!opstring.empty()){
				char opTop = opstring.peek();
				if(opTop == '('){  
					break;
				 }
				else{
					int n2;
					
					if(opTop == '+' || opTop == '-'){
						n2 = 1;
					}
					else{
						n2 = 2;
					}
					
					if(n2 < n1){
						opstring.push(opTop);
						break;
					 }
					
					 else{
						 	int opChar1 = opnumber.pop();
							int opChar2 = opnumber.pop(); 
							char ch = opstring.pop();
							int sum = calculator(opChar1, ch, opChar2);
							opnumber.push(sum);
					 }
				}
			}
		
			opstring.push(opThis);
			
		}
		
		/*��ǰ�����Ϊ������ʱ*/
		private void rightParentheses() {
			while(!opstring.empty()){
				if(opstring.peek() == '(') {//����������ֱ�ӳ�ջ
					opstring.pop();
					break;
				}
				else {
					int opChar1 = opnumber.pop();
					int opChar2 = opnumber.pop();
					char ch = opstring.pop();
					int sum = calculator(opChar1, ch, opChar2);
					opnumber.push(sum);
				}
			}
		}
		
		
		/*������ʽ���*/
		private int calculator(int opChar1, char ch, int opChar2) {
			int sum = 0;
			switch(ch) {
				case '+':
					sum = opChar2 + opChar1;
					break;
				case '-':
					sum = opChar2 - opChar1;
					break;
				case '*':
					sum = opChar2 * opChar1;
					break;
				case '/':
					sum = opChar2 / opChar1;
					break;
			}
			return sum;
		}
		
}