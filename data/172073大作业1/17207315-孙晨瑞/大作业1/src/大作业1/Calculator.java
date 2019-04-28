package 大作业1;
import java.util.Scanner;
import java.io.*;

public class Calculator {
	//判断运算符还是操作数
	public static boolean IsOperator(char c)
	{
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
		case '#':
		return true;
		default: return false;
		}
	}
	static  char OP[][]= {
			{'>','>','<','<','<','>','>'},
			{'>','>','<','<','<','>','>'},
			{'>','>','>','>','<','>','>'},
			{'>','>','>','>','<','>','>'},
			{'<','<','<','<','<','=','E'},
			{'>','>','>','>','E','>','>'},
			{'<','<','<','<','<','E','='}
	};
	//
	public static int GetOperatorID(char Operator)// 
	{
		int reatCode;
		reatCode =-1;
		switch(Operator)
		{
		case '+':reatCode=0;break;
		case '-':reatCode=1;break;
		case '*':reatCode=2;break;
		case '/':reatCode=3;break;
		case '(':reatCode=4;break;
		case ')':reatCode=5;break;
		case '#':reatCode=6;break;
		}
		return reatCode;
	}
	public static char Precede(char Operator1, char Operator2)//返回符号
	{
		int OperatorID1,OperatorID2;
		OperatorID1=GetOperatorID(Operator1);
		OperatorID2=GetOperatorID(Operator2);
		if(OperatorID1<0||OperatorID1>6||OperatorID2<0||OperatorID2>6)
			return 'E';
		return OP[OperatorID1][OperatorID2];
	}
	public static int Operate(int op1,char cal,int op2)//符号运算
	{
		switch(cal)
		{
		case '+':return op1+op2;
		case '-':return op1-op2;
		case '*':return op1*op2;
		case '/':return op1/op2;
		default:return 0;
		}
	}
	public static int DuQuBiaoDaShi(char[] exp)
	{
		char thera;
		int i=0;
		int b,a,val;
		//从参考资料中  :泛型的类型推导用来解决两个栈的元素返回值类型不同的问题
		Stack<Character> OPTR= new Stack<Character>();//运算符
		Stack<Integer> OPND= new Stack<Integer>();//操作数
		OPTR.push('#');
		while(exp[i]!='#'||OPTR.getHead()!='#')
		{
			if(!IsOperator(exp[i])) {
				int temp;
				temp=exp[i]-'0';
				i++;
				while(!IsOperator(exp[i])&&i<exp.length)
				{
					//将逐个读入的操作数各位转化为十进制数
					temp=temp*10+exp[i]-'0';
					i++;
				}
				OPND.push(temp);
			}
			else
			{
				switch(Precede(OPTR.getHead(),exp[i]))
				{
				case '<':
					OPTR.push(exp[i]);
					i++;
					break;
				case '=':
					OPTR.pop();
					i++;
					break; 
				case '>':
					thera=OPTR.pop();
					b=OPND.pop();
					a=OPND.pop();
					OPND.push(Operate(a,thera,b));
					break;			
				}
			}
		}
		val=OPND.getHead();
		return val;
	}
	public static void main(String[] args){
		// TODO 自动生成的方法存根
/*		BufferedReader br;
	 	String s;
		try {
			br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("输入一个以#为结束的表达式: ");
			s=br.readLine();
			char[] us=s.toCharArray();
			System.out.println("表达式的值为: "+DuQuBiaoDaShi(us));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
*/	
		FileOperator fo=new FileOperator();
		File f=new File("src\\this_in");
		File f1=new File("src\\this_out");
		fo.readLine(f,f1);
	}
}
class Stack<T>{
	final int MaxSize=10;
	private T[] stackArray;
	private int top;
	public Stack()
	{
		top=-1;
		stackArray=(T[])new Object[MaxSize];
	}
	public Stack(int n)
	{
		if(n<=0)
			System.exit(1);
		top=-1;
		stackArray=(T[])new Object[n];
	}
	public void push(T obj)
	{
		if(top==stackArray.length-1)
		{
			T []p=(T[])new Object [top*2+2];
			for(int i=0;i<=top;i++)
				p[i] =stackArray[i];
			stackArray=p;
		}
		top++;
		stackArray[top]=obj;
	}
	public T pop()
	{
		if(top==-1)
			return null;
		top--;
		return stackArray[top+1];
	}
	public T getHead()
	{
		if(top==-1)
		{
			return null;
		}
		return stackArray[top];
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public int size()
	{
		return top+1;
	}
}
class CheckOut{
	public static boolean feifazifu(String s)
	{
		
		String regex ="[\\d\\u002b\\u002d\\u002a\\u002f\\u0028\\u0029\\u0023]*";			
			if(!s.matches(regex))
			{
				System.out.println("ERROR\n#表达式中包含非法字符");
				return false;
			}
			else
			{
				return true;
			}
	}
	public static boolean biaodashiweikong(String s)
	{
		String regex="\\s*\\u0023";
		if(s.matches(regex))
		{
			System.out.println("ERROR\n#表达式为空");
			return false;
		}
		else
		{
			return true;
		}
	}
	public static boolean biaodashizhongkongkuohao(String s)
	{
		String regex=".*\\u0028\\u0029.*";
		if(s.matches(regex))
		{
			System.out.println("ERROR\n#有空括号");
			return false;
		}
		else 
		{
			return true;
		}
	}
	public static boolean kuohaobupipei(String s)
	{
		int fromIndex=0;
		int fromIndex1=0;
		int count1=0;
		int count2=0;
		while(true){
            int index1 = s.indexOf("(", fromIndex);
            if(index1!=-1){
                fromIndex = index1 + 1;
                count1++;
            }else{
                break;
            }
        }
		while(true){
            int index2 = s.indexOf(")", fromIndex1);
            if(index2!=-1){
                fromIndex1 = index2 + 1;
                count2++;
            }else{
                break;
            }
        }
		
		if(count1==count2)
			return true;
		else {
			System.out.println("ERROR\n#括号不匹配");
			return false;
		}
	}	
	public static boolean yunsuanfulianxu(String s)//+002b, -002d,*002a,/002f
	{
		String redex =".*\\u002b\\u002b.*|.*\\u002b\\u002d.*|.*\\u002b\\u002a.*|.*\\u002b\\u002f.*|.*\\u002d\\u002b.*|.*\\u002d\\u002d.*|.*\\u002d\\u002a.*|.*\\u002d\\u002f.*|.*\\u002a\\u002b.*|.*\\u002a\\u002d.*|.*\\u002a\\u002a.*|.*\\u002a\\u002f.*|.*\\u002f\\u002b.*|.*\\u002f\\u002d.*|.*\\u002f\\u002a.*|.*\\u002f\\u002f.*";
		if(s.matches(redex))
		{
			System.out.println("ERROR\n#运算符连续");
			return false;
		}
		else
			return true;
		
	}
	public static boolean yunsuanfuqianwuyunsuanshu(String s)
	{
		String redex="\\u002b.*|\\u002d.*|\\u002a.*|\\u002f.*";
		if(s.matches(redex))
		{
			System.out.println("ERROR\n#运算符前无运算数");
			return false;
		}
		else
			return true;
	}
	public static boolean yunsuanfuhouwuyunsuanshu(String s)
	{
		String regex=".*\\u002b\\u0023|.*\\u002d\\u0023|.*\\u002a\\u0023|.*\\u002f\\u0023";
		if(s.matches(regex))
		{
			System.out.println("ERROR\n#运算符后无运算数");
			return false;
		}
		else
			return true;
	}
	public static boolean kuohaoqianwuyunsuanshu(String s)
	{
		String regex=".*[^\\u0028\\u002b\\u002d\\u002a\\u002a]\\u0028.*";
		if(s.matches(regex))
		{
			System.out.println("ERROR\n#括号非第一个字符且之前无运算数");
			return false;
		}
		else
			return true;
	}
	public static boolean kuohaohouwuyunsuanshu(String s)
	{
		String regex=".*\\u0029[\\d].*";
		if(s.matches(regex))
		{
			System.out.println("ERROR\n#小括号后无运算数，括号非最后一个字符");
			return false;
		}
		else
			return true;
	}
}
class FileOperator{
	public void readLine(File f,File f1) {//以回车为识别断点
		try (Scanner input = new Scanner(f);PrintWriter output=new PrintWriter(f1);){
				while(input.hasNextLine())
				{
					CheckOut s1=new CheckOut();
					String s= input.nextLine();//从控制台读取字符串，以回车为结束符
					if(s1.biaodashiweikong(s)&&s1.biaodashizhongkongkuohao(s)&&s1.feifazifu(s)&&s1.yunsuanfulianxu(s)&&s1.kuohaobupipei(s)&&s1.yunsuanfuqianwuyunsuanshu(s)&&s1.yunsuanfuhouwuyunsuanshu(s)&&s1.kuohaoqianwuyunsuanshu(s)&&s1.kuohaohouwuyunsuanshu(s)) 
					{
						char[] us=s.toCharArray();
						Calculator c =new Calculator();
						System.out.println(s.substring(0, s.length()-1)+"="+c.DuQuBiaoDaShi(us));
						output.println(s.substring(0, s.length()-1)+"="+c.DuQuBiaoDaShi(us));
					}
				}
		}
			catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/*	public void writeLine(File f,String s){
		try (PrintWriter output = new PrintWriter(f);){
			char[] us=s.toCharArray();
			Calculator c =new Calculator();
			output.println(s.substring(0, s.length()-1)+"="+c.DuQuBiaoDaShi(us));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}*/
}
//把读入的字符串 转为字符串数组 ，对这个数组求值