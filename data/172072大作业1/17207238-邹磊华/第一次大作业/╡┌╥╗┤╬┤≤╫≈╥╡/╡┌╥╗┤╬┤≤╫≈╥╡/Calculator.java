package 第一次大作业;

import java.io.File;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1 = new File("第一次大作业\\data");
		File f2 = new File("第一次大作业\\anwner");
		FileOperate fo = new FileOperate();
		
		System.out.println("算式表达式求值：");
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入写入data文件中内容的行数：");
		int n = input.nextInt();
		String[] str = fo.readLine(f1,n);//读取文件每条内容并赋值
		int[] result = new int[n];//表达式结果记录数组
		
		CalculateExpression exp = new CalculateExpression();//创建对象	
		for(int i=0; i<n; i++) { 
		exp.compareOpstring(str[i]);
		result[i] = exp.opnumber.peek();//每个结果存到数组中		
		}
		fo.writeFile(f2,str,result,n);//写入文件
	}

}
/*运算符栈*/
class StackOfChar {
	private char[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//默认容量
	
	public StackOfChar() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfChar(int capacity) {
		elements = new char[capacity];
	}
	/*元素进栈*/
	public void push(char ch) {
		if(size >= elements.length) {//如果栈满
			char[] temp = new char[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = ch;
	} 
	/*元素出栈*/
	public char pop() {
		return elements[--size];
	}
	/*获取栈顶元素，未出栈*/
	public char peek() {
		return elements[size - 1];
	}
	/*判断栈是否为空*/
	public boolean empty() {
		return size == 0;
	}
	/*栈中元素个数*/
	public int getSize() {
		return size;
	}
}

/*运算数栈*/
class StackOfInt {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//默认容量
	
	public StackOfInt() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfInt(int capacity) {
		elements = new int[capacity];
	}
	/*元素进栈*/
	public void push(int ch) {
		if(size >= elements.length) {//如果栈满
			int[] temp = new int[elements.length * 2];//创建一个容量更大的数组
			System.arraycopy(elements, 0, temp, 0, elements.length);//将当前数组的内容复制到新数组
			elements = temp;//将新数组的应用赋值给栈中当前数组
		}
		elements[size++] = ch;
	} 
	/*元素出栈*/
	public int pop() {
		return elements[--size];
	}
	/*获取栈顶元素，未出栈*/
	public int  peek() {
		return elements[size - 1];
	}
	/*判断栈是否为空*/
	public boolean empty() {
		return size == 0;
	}
	/*栈中元素个数*/
	public int getSize() {
		return size;
	}
}

class CalculateExpression {

		StackOfChar opstring = new StackOfChar();//操作符堆栈
		StackOfInt opnumber = new StackOfInt();//操作数堆栈  
		
		/*判断是否是运算符还是运算数；是运算符比较优先级然后进行相应操作，是数则压入操作数堆栈*/
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
					switch(ch){//比较运算符的优先级进行相应操作
						
					    case '*':
					    	break;
					    case '/':
					    	precede(ch,2);//需要判断优先级
					    	num = "";
				            break;
					
					    case '-':
					    	precede(ch,1);
					    	num = "";
					        break;
					    case '+':
					    	break;
					    case '(':
					        opstring.push(ch);//左括号优先级最高直接进栈
					        num = "";
					        break;
					    case ')':
					    	rightParentheses();//碰到右边括号涉及出栈
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
		
		/*比较运算符优先级*/
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
		
		/*当前运算符为右括号时*/
		private void rightParentheses() {
			while(!opstring.empty()){
				if(opstring.peek() == '(') {//括号相遇，直接出栈
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
		
		
		/*计算算式结果*/
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