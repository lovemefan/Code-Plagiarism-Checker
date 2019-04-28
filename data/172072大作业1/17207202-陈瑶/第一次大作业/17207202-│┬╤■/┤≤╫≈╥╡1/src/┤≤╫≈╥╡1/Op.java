package 大作业1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//用来计算四则运算法则
public class Op
{
	
	// 运算表达式中含有的字符
	static char OP[] = { '+', '-', '*', '/', '(', ')', '#' };
	// 优先级运算
	static char[][] compare = { { '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '>', '>' }, { '>', '>', '>', '>', '<', '>', '>' },
			{ '<', '<', '<', '<', '<', '=', '!' }, { '>', '>', '>', '>', '!', '>', '>' },
			{ '<', '<', '<', '<', '<', '!', '=' } };

	private static char Preceded(char c, char e)// 决定符号的优先级
	{
		int m = 0, n = 0;
		for (int i = 0; i < OP.length; i++)
		{
			if (c == OP[i])
			{
				m = i;
			}
		}
		for (int j = 0; j < OP.length; j++)
		{
			if (e == OP[j])
			{
				n = j;
			}
		}
		return compare[m][n];
	}


	private static int Operate(int a, char thera, int b)
	{
		char T;
		int total = 0;
		int A = a ;
		int B = b ;
		switch (thera)
		{
		case '+':
			total = A + B;
			break;
		case '-':
			total = A - B;
			break;
		case '*':
			total = A * B;
			break;
		case '/':
			total = A / B;
			break;
		}
		return total;
	}

	public static int In(char c)// 判断是数字
	{
		int tip = 0;
		for (int i = 0; i < OP.length; i++)
		{
			if (c == OP[i])
				tip = 1;
		}
		if (tip == 1)
			return 0;
		else
			return 1;

	}
	private static int Calculate(char[] optr,char thera,Stack staco)
	{

		int i = 0;
		int a,b,e;
				
		b = staco.intpeek();
		staco.intpop();
		a = staco.intpeek();
		staco.intpop();
		staco.push(Operate(a, thera, b));

		e =  staco.intpeek();
		int result = e;
		return result;

	}

	public static void Op(String op[])
	{
		int Flength = 0;//计算表达式里有效的长度
		for(int n1 =0;n1<op.length;n1++)
		{
			if(op[n1] != null)
			{
				Flength ++;
			}
		}
		
		char[] opera = {'+','-','*','/','#','(',')'};//用于计算字符个数的字符比较
		char[] operac = {'+','-','*','/'};
		int[] result = new int [Flength];//计算结果的统计
		FileOperation fo = new FileOperation();//存储文件
		File f = new File("src\\OutPut");
		Expetion ex = new  Expetion();
		

		for (int i = 0; i < Flength; i++)
		{

			int m = 0;// 作为操作符栈的累加
			int m1 = 0;
			int n = 0;// +-*/个数的累加
			int s = 0;//追踪字符的位置
			
			Stack stack = new Stack(); // 创建堆栈对象
			Stack staco = new Stack(); // 存储数字对象
			//计算表达式中操作字符个数
			int i1 = 0;
			while(i1< op[i].length())
			{
				if(ex.Ch(op[i].charAt(i1),opera ) == 1)
					m ++;
				if(ex.Ch(op[i].charAt(i1),operac ) == 1)
					n ++;
				i1++;
			}
			
			char[] optr = new char[n];// 创建一个数组存放字符计算式
			stack.createStack(m);// 创建一个新字符的栈
			staco.stackofintergers(op[i].length()-m);// 创建一个数字的栈
			stack.push(op[i].charAt(s));
			s++;
			char e = stack.peek();
			
			while (op[i].charAt(s) != '#' || e != '#')
			{
				if(op[i].charAt(s) == ' ')
				{
					s++;
				}
				else if (In(op[i].charAt(s)) == 1)//如果该元素是数字
				{      
					int p = 1;//标记仅限寻找一次
					int tip = 0;//找到的标记
					for(int i2 = s+1;i2<op[i].length()&&  p == 1;i2++)
					{
						if(In(op[i].charAt(i2)) == 0)
						{
							tip = i2;
							p =0;
						}						
					}
					int inta = Integer.parseInt(op[i].substring(s,tip));
					staco.push(inta);
					s = tip;

				} else
				{
					
					e = stack.peek();// 得到栈顶元素
					switch (Preceded(e, op[i].charAt(s)))// 将栈顶元素与当前元素比较大小
					{
					case '<':
					{
						stack.push(op[i].charAt(s));
						s++;
						break;
					}
					case '>':
					{
						char ch = stack.peek();
						stack.pop();
						optr[m1++] = ch;
						// 计算表达式的结果
						int  sum = Calculate(optr,ch,staco);
						result[i] = sum;
						break;
					}
					case '=':
					{
						stack.pop();
						s++;
						break;
					}
					}
					e = stack.peek();				
					}
			}

			//存入文件
			fo.writeFile(f,op,result,Flength);
		}

	}


}
