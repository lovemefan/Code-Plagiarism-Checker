package 大作业01;

import java.util.Scanner;
import java.util.Stack;

import java.io.File;

public class Caculate {
	
	public static String converToPostfix(String expression)throws Exception{
		
		Stack<Character> st=new Stack<>();   //初始化一个运算符栈
		String postfix=new String();   //用于储存后缀表达式
		for(int i=0;expression!=null&&i<expression.length();i++){
			char c=expression.charAt(i);
			if(' '!=c){//为左括号
				if(isOpenParent(c)){
					st.push(c);
				}//为右括号
				else if(isCloseParent(c)){
					char ac=st.pop();
					while(!isOpenParent(ac)){
						postfix=postfix.concat(String.valueOf(ac));
						ac=st.pop();
					}
				}//为运算符
				else  if(isOperator(c)){
					//运算栈非空，取出栈顶优先级高的运算符送完后缀表达式
					if(!st.empty()){
						char ac=st.pop();
						//栈取出的字符优先级比c高
						while(!st.isEmpty()&&priority(ac)>=priority(c)){
							postfix=postfix.concat(String.valueOf(ac));
							ac=st.pop();
						}//栈取出的字符优先级比c低，则将取出的字符重新入栈
						if(ac!=' '){
							st.push(ac);
						}
					}st.push(c);    //将c入栈
				}//为操作数，直接串联到postfix内
				else {
					postfix=postfix.concat(String.valueOf(c));
				}
			}
		}//当表达式读完就将算术栈pop出加入postfix
		while(!st.isEmpty()){
			postfix=postfix.concat(String.valueOf(st.pop()));
			
		}
		return postfix;
	}
	//对后缀表达式进行运算
	public static double numberCalculate(String postfix)throws Exception{
		
		Stack st=new Stack<>();//创建一个操作数栈
		for(int i=0;postfix!=null&&i<postfix.length();i++){
			
			char c=postfix.charAt(i);
			//如果为运算符
			if(isOperator(c)&&!st.isEmpty()){
				double d2=Double.valueOf(st.pop().toString());
				double d1=Double.valueOf(st.pop().toString());
				double d3=0;
				if('+'==c){
					d3=d1+d2;
				}
				if('-'==c){
					d3=d1-d2;
				}
				if('/'==c){
					d3=d1/d2;
				}
				if('*'==c){
					d3=d1*d2;
				}
				//将运算结果压入操作数栈中
				st.push(d3);
			}else{//为操作数时直接压入操作数栈
			st.push(c);}
		}
		return (double) st.pop();//返回运算结果
	}
	//判断字符为运算符
	public static boolean isOperator(char c){
		if('+'==c||'-'==c||'/'==c||'*'==c){
			return true;
		}
		else {
			return false;
		}
	}
	//判断字符为左括号
	public static boolean isOpenParent(char c){
		return c=='(';
	}
	//判断字符为右括号
	public static boolean isCloseParent(char c){
		return c==')';
	}
	//判断算法的优先级
	public static int priority(char c){

		if(c=='/'||c=='*'){
			return 2;
		}
		else if(c=='-'||c=='+'){
			return 1;
		}
		else return 0;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			System.out.println("请先在表达式输入文件中输入要计算的表达式");
			int num;
			System.out.println("请输入你所输入表达式的条数，按回车继续");
			Scanner input = new Scanner(System.in);
			num = input.nextInt();
			System.out.println("计算结果将显示在计算结果文件中，对于无效输入将直接在下方显示无效输入类型");
			System.out.println();
			Verify b = new Verify();
		
			FileOperation fo = new FileOperation();
			File f = new File("大作业01\\表达式输入");	
			File f1 = new File("大作业01\\计算结果");
			
			String []s = new String[num];
			s = fo.read(f,num);//读入表达式
			double []result = new double[num];//计算结果存入数组
			for(int i=0;i<num;i++) {
				if(b.isTrue(s[i]) == true) {
				
				String postfix = converToPostfix(s[i]);//中缀表达式转为后缀表达式
				result[i] = numberCalculate(postfix);//计算结果
		//		System.out.println("表达式结果为："+result[i]);
				}
				else {
					s[i] = "输入的表达式无效";
				}
					
			}
				fo.write(f1,result,num,s);//结果写入文件
 
	}
}
