package packgge;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("src//calculator");
		FileOperation of = new FileOperation();
		of.readLine(f);
		File fr = new File("src//result");
		of.readLine2(fr);  //输出结果
	}
	public void transform(String s,PrintWriter output){  //转化为逆波兰式
		char[] chars = s.toCharArray();
		Stack stack1 = new Stack();  //声明栈
		int i=0;
		ArrayList<Object> list = new ArrayList<>();  //声明对象列表存储逆波兰式
		while(i<s.length()) {
			String s1 = new String();
			do{
				s1 = s1 + chars[i];
				i++;
				if(!Character.isDigit(chars[i-1])||i==s.length())break;
			}while(Character.isDigit(chars[i]));  //拆分字符串为数字或运算符
			if(s1.matches("[\\(\\)+-/\\*]")) {   
				if(stack1.isEmpty()) {
					stack1.push(s1);
				}//if
				else {
					switch(compare((String)stack1.peek(),s1)){  //比较优先级
						case 1:
							list.add((String)stack1.pop());
							i--;
							break;
						case 0:
							stack1.pop();
							break;
						case -1:
							stack1.push(s1);
							break;
					}//switch
				}//else
			}//if
			else {
				list.add(s1); 
			}
		}//while
		while(!stack1.isEmpty()) {
			list.add((String)stack1.pop());
		}
//		System.out.println(list.toString());
		count(list,s,output);
	}//transform
	
	public void count(ArrayList list,String s1,PrintWriter output){   //计算逆波兰式
		Stack stack2 = new Stack();   //声明栈
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
		}//for
		output.println(s1+" = "+stack2.peek());
	}//count
	
	public int compare(String x,String y)//比较优先级函数 
	{
		int i=0,j=0;
		char Prior[][] = {{'>','>','<','<','<','>','>',},
						  {'>','>','<','<','<','>','>',},
						  {'>','>','>','>','<','>','>',},
						  {'>','>','>','>','<','>','>',},
						  {'<','<','<','<','<','=',' ',},
						  {'>','>','>','>',' ','>','>',},
						  {'<','<','<','<','<',' ','='},
						 };
		switch(x.charAt(0)){
			case '+':
				i=0;
				break;
			case '-':
				i=1;
				break;
			case '*':
				i=2;
				break;
			case '/':
				i=3;
				break;
			case '(':
				i=4;
				break;
			case ')':
				i=5;
				break;
			case '#':
				i=6;
				break;
		}
		switch(y.charAt(0)){
			case '+':
				j=0;
				break;
			case '-':
				j=1;
				break;
			case '*':
				j=2;
				break;
			case '/':
				j=3;
				break;
			case '(':
				j=4;
				break;
			case ')':
				j=5;
				break;
			case '#':
				j=6;
				break;
		}
		if(Prior[i][j]=='>') return 1;
		else if(Prior[i][j]=='=') return 0;
		else return -1;
	 } //compare
}//Calculator

class RegularExpression {
	public void checkout(String s,PrintWriter output){
		if(s.matches("\\s*|")) {
			output.println("ERROR");
			output.println("#表达式为空");		
		}//if
		else{
			s=filtration(s);
			if(s.matches(".*\\(\\).*")) {
				output.println("ERROR");
				output.println("#表达式中有空括号");
			}
			else if(s.matches(".*[^\\*+-/\\(\\)&&[^0-9]].*")){
				output.println("ERROR");
				output.println("#表达式包含非法字符");
			}
			else if(s.matches(".*[\\*+-/]{2,}.*")) {
				output.println("ERROR");
				output.println("#运算符连续");
			}
			else if(bracket(s)!=0){
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
			else if(s.matches(".*\\)\\d{1}.+")) {
				output.println("ERROR");
				output.println("#小括号后无运算符,括号非最后一个字符");
			}
			else {
				Calculator ca = new Calculator();  
				ca.transform(s,output);
			}
		}//else if
	}
	public String filtration(String s){   //过滤掉空格字符
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				stringBuilder.append(s.charAt(i));
			}//if
		}//for
		return stringBuilder.toString();
	}//filtration
	public int bracket(String s) {   //匹配括号数量
		int i=0;
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j)=='(') i++;
			else if(s.charAt(j)==')')i--;
		}
		return i;
	}//bracket
}//RegularExpression

class FileOperation {
	public void readLine(File f) throws FileNotFoundException {  // 读文件
		File fw = new File("src//result");
		PrintWriter output = new PrintWriter(fw);
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
			//	System.out.println(s);
				RegularExpression expre = new RegularExpression();
				expre.checkout(s,output);
			}//while
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		output.close();
	}//readLine
	public void readLine2(File f) {  
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class  Stack {
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