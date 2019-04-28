package JSQ;

import java.util.*;
import java.io.*;

class FileOperation {// 读取文件
	public void readExpression(File f) throws FileNotFoundException {  
		File fw = new File("src//result");
		PrintWriter output = new PrintWriter(fw);
		
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				warning expre = new warning();
				expre.check(s,output);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		output.close();
	}
	
	public void readLine(File f) {  
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class  zhan {
	private ArrayList<Object> list = new ArrayList<>();
	public void push(Object o) {  //压栈
		list.add(o);
	}
	public Object pop() {  //出栈
		Object o =list.get(getSize()-1);
		list.remove(getSize()-1);
		return o;
	}
	public Object peek(){  //获取栈顶元素
		return list.get(getSize()-1);
	}
	public boolean isEmpty(){   //判断栈是否为空
		return list.isEmpty();
	}
	public int getSize(){//获取栈的长度
		return list.size();
	}
}

public class Calculator {
	
	public void trans(String s,PrintWriter output){  //转化为逆波兰式
		char[] chars = s.toCharArray();
		zhan stack1 = new zhan();  //声明栈
		int j=0;
		ArrayList<Object> list = new ArrayList<>();  //声明对象列表存储逆波兰式
		while(j<s.length()) {
			String st = new String();
			do{
				st = st + chars[j];
				j++;
				if(!Character.isDigit(chars[j-1])||j==s.length())
					break;
			}
			while(Character.isDigit(chars[j]));  //拆分字符串为数字或运算符
			if(st.matches("[\\(\\)+-/\\*]")) {   
				if(stack1.isEmpty()) {
					stack1.push(st);
				}//if
				else {
					switch(compare((String)stack1.peek(),st)){  //比较优先级
						case -1:
							stack1.push(st);
							break;
						case 0:
							stack1.pop();
							break;
						case 1:
							list.add((String)stack1.pop());
							j--;
							break;
					}
				}
			}
			else {
				list.add(st); 
			}
		}
		while(!stack1.isEmpty()) {
			list.add((String)stack1.pop());
		}
		jisuan(list,s,output);
	}
	
	public int compare(String x,String y){
		int num=0,sum=0;
		char A=x.charAt(0);
		char B=y.charAt(0);
		char[][] prior={{'>','>','<','<','<','>'},
						{'>','>','<','<','<','>'},
						{'>','>','>','>','<','>'},
						{'>','>','>','>','<','>'},
						{'<','<','<','<','<','='},
						{'>','>','>','>',' ','>'},
					
						 };	
		if(A=='+')	
			num=0;
		else if(A=='-')	
			num=1;
		else if(A=='*')	
			num=2;
		else if(A=='/')	
			num=3;
		else if(A=='(')	
			num=4;
		else if(A==')')	
			num=5;
	
		if(B=='+')	
			sum=0;
		else if(B=='-')	
			sum=1;
		else if(B=='*')	
			sum=2;
		else if(B=='/')	
			sum=3;
		else if(B=='(')	
			sum=4;
		else if(B==')')
			sum=5;
	
		if(prior[num][sum]=='>')
			return 1;
		else if(prior[num][sum]=='=')
			return 0;
		else 
			return -1;
	}
	
	public void jisuan(ArrayList list,String s1,PrintWriter output){   //计算逆波兰式
		zhan stack2 = new zhan();   //声明栈
		for(int i = 0;i<list.size();i++){
			String s = list.get(i)+"";   //从列表中读取数字或运算符
			if(s.matches("[+-/\\*]"))
			{
				int num=0;
				int x = Integer.parseInt((String)stack2.pop());
				int y = Integer.parseInt((String)stack2.pop());
				if(s.matches("[+]")) num = y+x;
				else if(s.matches("-")) num = y-x;
				else if(s.matches("\\*"))num = y*x;
				else if(s.matches("/")) num = y/x;
				stack2.push(num+"");
			}
			else{
				stack2.push(s);
			}
		}
		output.println(s1+" = "+stack2.peek());
	}
		
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("src//calculator");
		FileOperation fo = new FileOperation();
		fo.readExpression(f);
		File f1 = new File("src//result");
		fo.readLine(f1);  //输出结果
	}
}

class warning {
	public void check(String s,PrintWriter output){
		if(s.matches("\\s*|")) {
			output.println("ERROR");
			output.println("#表达式为空");		
		}//if
		else{
			s=fileZH(s);
			if(s.matches(".*\\(\\).*")) {
				output.println("ERROR");
				output.println("#表达式中有空括号");
			}
			else if(s.matches(".*\\)\\d{1}.+")) {
				output.println("ERROR");
				output.println("#小括号后无运算符,括号非最后一个字符");
			}
			else if(s.matches(".*[\\*+-/]{2,}.*")) {
				output.println("ERROR");
				output.println("#运算符连续");
			}
			else if(kuohao(s)!=0){
				output.println("ERROR");
				output.println("#括号不匹配");
			}
			else if(s.matches("([\\*+-/].*|.*\\([\\*+-/].*)")){
				output.println("ERROR");
				output.println("#运算符前无运算数");
			}
			else if(s.matches("(.*[\\*+-/]|.*[\\*+-/]\\))")){
				output.println("ERROR");
				output.println("#运算符后无运算数");
			}
			else if(s.matches(".+\\d{1}\\(.*")){
				output.println("ERROR");
				output.println("#括号非第一个字符且之前无运算符");
			}
			else if(s.matches(".*[^\\*+-/\\(\\)&&[^0-9]].*")){
				output.println("ERROR");
				output.println("#表达式包含非法字符");
			}
			else {
				Calculator ca = new Calculator();  
				ca.trans(s,output);
			}
		}
	}
	
	public String fileZH(String s){
		String cs=s.replaceAll("\\s*","");
		return cs;
	}
	
	public int kuohao(String s) {   //匹配括号数量
		int i=0;
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j)=='(') 
				i++;
			else if(s.charAt(j)==')')
				i--;
		}
		return i;
	}
}

	