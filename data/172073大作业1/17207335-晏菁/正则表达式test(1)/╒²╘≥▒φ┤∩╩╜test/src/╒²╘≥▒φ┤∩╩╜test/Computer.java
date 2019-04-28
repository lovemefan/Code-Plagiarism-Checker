package ������ʽtest;

import java.util.Stack;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Computer{ 
	
	private Stack<Character> priStack=new Stack<Character>(); //������ջ
	private Stack<Integer> numStack=new Stack<Integer>(); //������ջ
	public static void main(String[] args) {
		
		int t, k;		
		String str;
		Computer computer=new Computer();
		FileOperation fileOperation=new FileOperation();
		Judge judge=new Judge();
		File expression=new File("src//expression");
		File result=new File("src//result");
		//fileOperation.writerFile1(expression);
		k=fileOperation.readFile1(expression);//��ȡ�ļ�expression���õ����ʽ
		
		//ˢ��result�ļ�
		try (PrintWriter output = new PrintWriter(result);){					
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<k;i++){
			str=fileOperation.temp[i];
			//�ж�str�Ƿ������ȷ���ʽ
			if(judge.judge(str)){
				t=computer.caculate(str);
				fileOperation.writerFile(result,str,t);		
				fileOperation.readFile2(result);
			}
		}			
	}
	
	//���б��ʽ��ֵ
	public int caculate(String str){
		String temp;
		StringBuilder tempNum=new StringBuilder();
		StringBuilder string=new StringBuilder().append(str);
		int result = 0;
		for(int i=0;i<string.length();i++) {
			temp = string.substring(i, i+1);
			// �ж�temp�ǲ��������ǲ�����
			if (!isNum(temp)) {
				if (!"".equals( tempNum.toString())) {
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());
				}	
				// �жϵ�ǰ�������ջ��Ԫ�����ȼ���
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
			// ��Ϊ�ǲ�����ʱ�����֣�
			else{
				tempNum = tempNum.append(temp);
			}
		}
		return result;
	}
	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}
		
	//�Ƚϵ�ǰ��������ջ��Ԫ�ز��������ȼ��������ջ��Ԫ�����ȼ��ߣ��򷵻�true�����ڻ���ڷ���false 
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
