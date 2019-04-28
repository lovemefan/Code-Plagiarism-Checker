package calculator;

import java.io.*;
import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		

		FileOperat fo=new FileOperat();
		File f = new File("src\\calculatordemo");
		File fr = new File("src\\result");
		fo.fileInput(f,fr,FileOperat.count);
		fo.readLine(fr);
	}

}

/*
 * 文件操作类
 * 按行浏览
 * 结果写入（初次写入、追加写入）
 * 
 **/
class FileOperat {	

	static int count=0;//文件是否初次写入   0未开始写入此次结果  1为已开始写入
	
	public void readLine(File f) {
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void fileInput(File f,File fr,int count){
		try (Scanner input = new Scanner(f);){
		//	int count=0;
			while(input.hasNextLine()) {
				
				LineList L=new LineList();
				LineList NBLS=new LineList();
				Operation Op=new Operation();
				Detection deal=new Detection();
			//	String[] s={"(","3","+","2",")","*","4","-","2","8"};
			//	char[] s={'(','3','+','2',')','*','4','-','2','8'};
				
				String s = input.nextLine();
				String ts=deal.removeBlank(s);
				
				if(deal.regular(ts, fr,count)){
					char[] arr=ts.toCharArray();
					//	char[] arr=s.toCharArray();
					L.creatList(arr);
					Op.transition(L, NBLS);
					int result=Op.evaluation(NBLS);
					if(count==0){
						writeResultFile(fr,ts,result);
						count=1;
					}else
						addResultFile(fr,ts,result);
					
					L.destory();
					NBLS.destory();	
				}		
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeResultFile(File f,String s,int result) {
		try (PrintWriter output = new PrintWriter(f);){

			output.println(s+"="+result);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public void addResultFile(File f,String s,int result){
		try{

			FileWriter fileWriter = new FileWriter(f,true);
			PrintWriter output = new PrintWriter(fileWriter);

			output.println(s+"="+result);
			output.close();
			fileWriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

/*
 * 数据类型
 * 将num、symbol、judge整合在一个数据对象中
 **/
class DataType{
	char symbol;//字符类型数据
	int num;//整型数据
	boolean judge;//用于区分该节点保存的为何种数据 
	//true为字符型，false为整型
	
	DataType(){}
	
}


/*
 * 栈
 * 获取栈长度
 * 压栈
 * 出栈
 * 查看栈顶元素
 * 栈是否为空
 * 栈销毁
 **/
class Stack{
	private ArrayList<Object> list=new ArrayList<>();
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public Object peek(){
		return list.get(getSize()-1);
	}
	
	public Object pop(){
		Object o=list.get(getSize()-1);
		list.remove(getSize()-1);
		return o;
	}
	
	public void push(Object o){
		list.add(o);
	}
	
	public void destory(){
		list.clear();
		list=null;
	}
}
/*
 * 线性表
 * 表长
 * 表是否为空
 * 线性表销毁
 * 存入中缀表达式
 **/
class LineList{
	ArrayList<Object> list=new ArrayList<>();
	
	LineList(){}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void add(Object o){
		list.add(o);
	}
	
	//存入中缀表达式
	public void creatList(char[] s){
		for(int i=0;i<s.length;i++){
			this.add(s[i]);
		}
	}
	
	public void destory(){
		list.clear();
		list=null;
	}
}

/*
 * 运算类
 * 计算逆波兰式
 * 中缀表达式转逆波兰式
 * 运算符优先级比较
 * String型转整形
 * 对A、B两数进行四则运算
 **/
class Operation{
	Operation(){}
	
	int evaluation(LineList NBLS){
		Stack RESULT=new Stack();

		DataType e=new DataType();

		int result=0;

		for(int i=0;i<NBLS.getSize();)
		{
		//	DataType e=new DataType();
			e=(DataType) NBLS.list.get(i);
			if(!e.judge)
			{
		
				RESULT.push(e);
				i++;
			}
			else if(e.judge)
			{
			
				DataType t=new DataType();
				DataType numA=new DataType();
				DataType numB=new DataType();
				numB=(DataType) RESULT.pop();
				numA=(DataType) RESULT.pop();
				result=abOperation(numA.num,e.symbol,numB.num);
				t.num=result;
				RESULT.push(t);
				t=null;
				numA=null;
				numB=null;
				i++;
			}
		}
		if(NBLS.getSize()==1){
			e=(DataType) NBLS.list.get(0);
			result=e.num;
		}
		e=null;	
	//	System.out.println(result);
		RESULT=null;
		return result;
	}
	
	public void transition(LineList L,LineList NBLS){
		Stack OPTR=new Stack();
		Stack S=new Stack();
		
	//	String turnnum="";
		
		char ch;
		boolean count=true;
		for(int i=0;i<L.getSize();)
		{
		
			ch=(char) L.list.get(i);
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||ch=='#')
			{
				
				if(count!=true)
				{	
					DataType t=new DataType();
					t.num=conversion(S);
				//	t.num=Integer.parseInt(turnnum);
					t.judge=false;
					NBLS.list.add(t);
					t=null;
				 	count=true;
				}
				if(OPTR.getSize()==0)
				{		
				
					DataType t=new DataType();
					t.symbol=ch;
					OPTR.push(t);
					t=null;
				 	i++;
				}
				else if(OPTR.getSize()>0)
				{
				 
					DataType e=new DataType();
					DataType copy=new DataType();
					copy=(DataType)OPTR.peek();
					e.symbol=copy.symbol;
				 	switch(priority(e,ch))
				 	{
				 		case '>':
				 		
				 			e.judge=true;
				 			NBLS.add(e);
				 			e=null;
				 			OPTR.pop();
				 			break;
				 		case '<':
				 		
				 			e.symbol=ch;
				 			OPTR.push(e);
				 			e=null;
				 			i++;
				 			break;
				 		case '=':
				 		
				 			OPTR.pop();
				 			e=null;
				 			i++;
				 			break;
					}
				}
			}
			else if(ch>=48&&ch<=57)
			{
				DataType e=new DataType();
				e.num=ch-48;
				count=false;
				S.push(e);
				e=null;
				
		//		turnnum+=ch;
				
				i++; 
			}
			if(i==L.getSize()&&ch!=')')
			{
			
				DataType e=new DataType();
				e.num=conversion(S);
				e.judge=false;
				NBLS.add(e);
				e=null;
				count=true;
			}
		}
		while(OPTR.getSize()!=0)
		{
		
			DataType e=new DataType();
			e=(DataType) OPTR.pop();
			e.judge=true;
			NBLS.add(e);
			e=null;
		}
		OPTR=null;
		S=null;
	}
	//字符转数字
	public int conversion(Stack S){

		int sum=0,count=S.getSize();
		DataType e=new DataType();
		for(int i=0;i<count;i++)
		{
			e=(DataType) S.pop();
			sum=sum+(e.num)*(int)Math.pow(10,i);
		}
		return sum;
	}
	//比较运算符优先级
	public char priority(DataType A,char B){
		int col=0,line=0;
					   // +   -   *   /   (   )   #
		char[][] prior={{'>','>','<','<','<','>','>'},// +
						{'>','>','<','<','<','>','>'},// -
						{'>','>','>','>','<','>','>'},// *
						{'>','>','>','>','<','>','>'},// /
						{'<','<','<','<','<','=',' '},// (
						{'>','>','>','>',' ','>','>'},// )
						{'<','<','<','<','<',' ','='},// #
						 };
		
		if(A.symbol=='+')	col=0;
		else if(A.symbol=='-')	col=1;
		else if(A.symbol=='*')	col=2;
		else if(A.symbol=='/')	col=3;
		else if(A.symbol=='(')	col=4;
		else if(A.symbol==')')	col=5;
		else if(A.symbol=='#')	col=6;
		if(B=='+')	line=0;
		else if(B=='-')	line=1;
		else if(B=='*')	line=2;
		else if(B=='/')	line=3;
		else if(B=='(')	line=4;
		else if(B==')')	line=5;
		else if(B=='#')	line=6;
		return prior[col][line];
	}
	//对A、B计算并返回结果
	public int abOperation(int numA,char OP,int numB){
		if(OP=='+')
			return numA+numB;
		else if(OP=='-')
			return numA-numB;
		else if(OP=='*')
			return numA*numB;
		else
			return numA/numB;	
	}
	
}

/*
 * 检测类
 * 正则匹配
 * 空白去除
 * 括号匹配
 **/
class Detection{
	public boolean regular(String s,File f,int count){
		try{
			PrintWriter output;
			if(count!=0){
				FileWriter fileWriter = new FileWriter(f,true);
				output = new PrintWriter(fileWriter);
			}else
				output=new PrintWriter(f);
			
			
			
			if(s.matches("\\s*|")){
				output.println("ERROR");
				output.println("#表达式为空");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches(".*\\(\\).*|.*\\(\\)|\\(\\).*|\\(\\)")){
				output.println("ERROR");
				output.println("#表达式中有空括号");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches(".*[^a-zA-Z0-9+-/()\\*]"
					+"|.*[^a-zA-Z0-9+-/()\\*].*"
					+"|[^a-zA-Z0-9+-/()\\*].*")){
				output.println("ERROR");
				output.println("#表达式包含非法字符");
				output.close();
				count=1;
				return false;
			}
			else if(!bracketDetection(s)){
				output.println("ERROR");
				output.println("#括号不匹配");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches(".*[+-/\\*]{2,}.*"
					+"|.*[+-/\\*]{2,}"
					+"|[+-/\\*]{2,}.*")){
				output.println("ERROR");
				output.println("#运算符连续");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches("[+-/\\*]{1,2}.*")){
				output.println("ERROR");
				output.println("#运算符前无运算数");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches(".*[+//\\*]{1,2}")){
				output.println("ERROR");
				output.println("#运算符后无运算数");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches("[0-9]+\\(.*"
					+"|.*[0-9]+\\(.*")){
				output.println("ERROR");
				output.println("#括号非第一个字符且之前无运算符");
				output.close();
				count=1;
				return false;
			}
			else if(s.matches(".*\\)[0-9]+"
					+"|.*\\)[0-9].*")){
				output.println("ERROR");
				output.println("#小括号后无运算符，括号非最后一个字符");
				output.close();
				count=1;
				return false;
			}
			output.close();
		//	fileWriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean bracketDetection(String s){
		int judge=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='(')
				judge--;
			else if(ch==')')
				judge++;
		}
		if(judge==0)
			return true;
		else
			return false;
	}
	
	public String removeBlank(String s){
		String str=s.replaceAll("\\s*", "");
		return str;
	}
}