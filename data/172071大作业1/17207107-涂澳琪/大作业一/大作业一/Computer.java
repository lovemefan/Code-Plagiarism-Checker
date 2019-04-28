package 大作业一;
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
		// TODO Auto-generated method stub
		int t;
		int k;//表示有k个表达式
		String str;
		Computer computer=new Computer();//实例化类Computer
		FileOperation fileOperation=new FileOperation();//实例化类FileOperation
		File expression=new File("src//expression");
		File result=new File("src//result");
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
			if(computer.judge(str)){//str符合正确表达式
				t=computer.caculate(str);//计算表达式所得结果赋值给t
				fileOperation.writerFile(result,str,t);//将表达式和求值结果写入文件result			
				fileOperation.readFile2(result);//读取文件result
			}
		}			
	}
	
	//判断str是否符合正确表达式
	public boolean judge(String str){
		String temp1="";
		String temp2="";
		String temp="Null";
		int k=0;//表示小括号(的个数
		int m=0;//表示小括号)的个数
		if( str.compareTo(temp)==0 ){
			System.out.println("ERROR #表达式为空");
			return false;
		}
		temp1=str.substring(0,1);
		if((temp1.matches("[\\+\\-\\*\\/]"))){
			System.out.println("ERROR #运算符前无运算数");
			return false;
		}
		//判断整个字符串是否含非法字符	
		for(int i=0;i<str.length()-1;i++){
			temp1=str.substring(i, i+1);
			if(!temp1.matches("[[0-9]\\+\\-\\*\\/\\(\\)]")){
				System.out.println("ERROR #表达式中含非法字符");
				return false;
			}
		}
		//判断表达式的其它错误
		for(int i=0;i<str.length()-1;i++){
			temp1=str.substring(i,i+1);
			temp2=str.substring(i+1,i+2);
			if(temp1.matches("\\(")&&temp2.matches("\\)")){
				System.out.println("ERROR #表达式中有空括号");
				return false;
			}
			else if( (temp1.matches("[\\+\\-\\*\\/]")) &&temp2.matches("[\\+\\-\\*\\/]") ){
				System.out.println("ERROR #运算符继续");
				return false;
			}
			else if((!temp1.matches("[[0-9]\\)]")) && (temp2.matches("[\\+\\-\\*\\/]"))){
				if(!temp1.matches("[0-9]")){
				System.out.println("ERROR #运算符前无运算数");
				return false;
				}
			}
			else if((temp2.matches("\\(")) && (!temp1.matches("[\\+\\-\\*\\/]")) && (i!=0)){
				System.out.println("ERROR #括号非第一个字符且之前无运算符");
				return false;
			}
			else if((temp1.matches("[\\+\\-\\*\\/]")) && (!temp2.matches("[[0-9]\\(]"))){
				if(!temp2.matches("[0-9]")){
				System.out.println("ERROR #运算符后无运算数");
				return false;
				}
			}
			else if((temp1.matches("\\)")) && (!temp2.matches("[\\+\\-\\*\\/]")) && (i!=(str.length()-2))){
				System.out.println("ERROR #小括号后无运算符，括号非最后一个字符");
				return false;
			}
		}
		
		//判断括号是否匹配
		for(int i=0;i<str.length();i++){
			temp1=str.substring(i,i+1);
			if( (temp.matches("\\(")) ){
				k++;
			}
			else if(temp.matches("\\)")){
				m++;
			}
		}
		if(k!=m){
			System.out.println("ERROR	#括号不匹配");
			return false;
		}
		
		return true;
	}
	//进行表达式求值
	public int caculate(String str){
		String temp;//用来临时存放读取的字符
		StringBuilder tempNum=new StringBuilder();//用来临时存放数字字符串
		StringBuilder string=new StringBuilder().append(str);//用来保存，提高效率
		int result = 0;// 运算结果
		for(int i=0;i<string.length();i++) {
			temp = string.substring(i, i+1);//依次截取字符串的字符
			// 判断temp是操作数还是操作符,当为操作符时
			if (!isNum(temp)) {
				//此时的tenpNum内即为需要操作的数，取出数，压栈，并清空tempNum				
				if (!"".equals( tempNum.toString())) {
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());//请空tempNum
				}	
				// 判断当前运算符与栈顶元素优先级，若小于或等于，取出元素，进行计算(因为优先级可能小于栈顶元素，还小于第二个元素等等，需要用循环判断)
				while (!compare(temp.charAt(0)) && (!priStack.empty())) {
					int a = (int) numStack.pop();// 第二个运算数
					int b = (int) numStack.pop();// 第一个运算数
					char ope = priStack.pop();
					switch (ope) {
					// 如果是加号或者减号，则
					case '+':
						result = b + a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '/':
						result = b / a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					}
				}
				//计算完后，将当前操作符号，放入操作符栈
				//或者当前运算符高于栈顶元素优先级，直接放入操作符栈
				if (temp.charAt(0) != '=') {
					priStack.push(temp.charAt(0));
					if (temp.charAt(0) == ')') {// 当栈顶为'('，而当前元素为')'时，则是括号内以算完，去掉括号
						priStack.pop();
						priStack.pop();
					}
				}
			} 
			// 当为非操作符时（数字）
			else{
				tempNum = tempNum.append(temp);// 将读到的这一位数接到以读出的数后(当不是个位数的时候)
			}
		}
		return result;
	}
	
	// 判断传入的字符是不是0-9的数字
	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}
		
	//比较当前操作符与栈顶元素操作符优先级，如果比栈顶元素优先级高，则返回true，低于或等于返回false 
	private boolean compare(char str) {
		if (priStack.empty()) {
			// 当为空时，显然 当前优先级最低，返回高
			return true;
		}	
		char last = (char) priStack.lastElement();//取出栈顶元素并且栈长度减一
		if (last == '(') {// 如果栈顶为'('显然，优先级最低，')'不可能为栈顶。
			return true;
		}
		switch (str) {
		case '=':
			return false;// 结束符
		case '(':
			return true;// '('优先级最高,显然返回true
		case ')':
			return false;// ')'优先级最低
		case '*': {
			// '*/'优先级只比'+-'高
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
		// '+-'为最低，一直返回false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}	
}

//文件操作
class FileOperation{
	FileOperation(){}
	String temp[]=new String[50];
	//读取文件expression
	int readFile1(File expression){
		int i=0;
		try (Scanner input = new Scanner(expression);){
			while(input.hasNextLine()) {
				String s = input.nextLine();//读取文件中一行数据
				temp[i]=s;
				i++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	//写文件result
	public void writerFile(File result,String str,int t) {
		try (FileWriter fileWriter=new FileWriter(result,true);){
			fileWriter.write(str+t+"\n");	
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	//读取文件result,每次读取都只读取最后一行
	void readFile2(File result){
		String line=null;
		try(Scanner input = new Scanner(result);){
			while(input.hasNextLine() && (line=input.nextLine())!=null){
				if(!input.hasNextLine()){
					System.out.println(line);
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}