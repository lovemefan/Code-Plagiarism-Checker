package 正则表达式test;

import java.util.Stack;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Computer{ 
	
	private Stack<Character> priStack=new Stack<Character>(); //操作符栈
	private Stack<Integer> numStack=new Stack<Integer>(); //操作数栈
	public static void main(String[] args) {
		
		int t, k;		
		String str;
		Computer computer=new Computer();
		FileOperation fileOperation=new FileOperation();
		Judge judge=new Judge();
		File expression=new File("src//expression");
		File result=new File("src//result");
		//fileOperation.writerFile1(expression);
		k=fileOperation.readFile1(expression);//读取文件expression，得到表达式
		
		//刷新result文件
		try (PrintWriter output = new PrintWriter(result);){					
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<k;i++){
			str=fileOperation.temp[i];
			//判断str是否符合正确表达式
			if(judge.judge(str)){
				t=computer.caculate(str);
				fileOperation.writerFile(result,str,t);		
				fileOperation.readFile2(result);
			}
		}			
	}
	
	//进行表达式求值
	public int caculate(String str){
		String temp;
		StringBuilder tempNum=new StringBuilder();
		StringBuilder string=new StringBuilder().append(str);
		int result = 0;
		for(int i=0;i<string.length();i++) {
			temp = string.substring(i, i+1);
			// 判断temp是操作数还是操作符
			if (!isNum(temp)) {
				if (!"".equals( tempNum.toString())) {
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());
				}	
				// 判断当前运算符与栈顶元素优先级，
				while (!compare(temp.charAt(0)) && (!priStack.empty())) {
					int a = (int) numStack.pop();
					int b = (int) numStack.pop();
					char ope = priStack.pop();
					switch (ope) {
				
					case '+':
						result = b + a;
				
						numStack.push(result);
						break;
					case '-':
						result = b - a;
					
						numStack.push(result);
						break;
					case '*':
						result = b * a;
					
						numStack.push(result);
						break;
					case '/':
						result = b / a;
					
						numStack.push(result);
						break;
					}
				}
				if (temp.charAt(0) != '=') {
					priStack.push(temp.charAt(0));
					if (temp.charAt(0) == ')') {
						priStack.pop();
						priStack.pop();
					}
				}
			} 
			// 当为非操作符时（数字）
			else{
				tempNum = tempNum.append(temp);
			}
		}
		return result;
	}
	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}
		
	//比较当前操作符与栈顶元素操作符优先级，如果比栈顶元素优先级高，则返回true，低于或等于返回false 
	private boolean compare(char str) {
		if (priStack.empty()) {
		
			return true;
		}	
		char last = (char) priStack.lastElement();
		if (last == '(') {
			return true;
		}
		switch (str) {
		case '=':
			return false;
		case '(':
			return true;
		case ')':
			return false;
		case '*': {
		
			if (last == '+' || last == '-')
				return true;
			else
				return false;
			}
		case '/': {
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}	
}
