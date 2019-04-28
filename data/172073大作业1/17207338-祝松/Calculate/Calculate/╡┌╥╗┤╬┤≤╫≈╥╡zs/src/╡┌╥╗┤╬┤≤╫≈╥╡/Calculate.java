package 第一次大作业;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Calculate
{
	private static final String NULL = null;
	// 运算表达式中含有的字符
	static char[] OP = { '+', '-', '*', '/', '(', ')', '#' };
	// 优先级运算
	static char[][] compare = 
		{ 
			{ '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '>', '>' },
			{ '<', '<', '<', '<', '<', '=', '!' },
			{ '>', '>', '>', '>', '!', '>', '>' },
			{ '<', '<', '<', '<', '<', '!', '=' } 
		};
	//比较符号的优先级
	private static char Preceded(char c, char e)
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
	public static void allOperate(String operate[])//#19+4-7#
	{

		FileOperation fo = new FileOperation();
		File f = new File("src\\test");
		
		int length = 0;
		int outcome[] = new int[operate.length];
		
		for(int i=0;i<operate.length;i++)
		{
			if(operate[i] != null)
				length++;
		}
		System.out.println("length = "+length);
		for(int i=0;i<length;i++)
		{
			if(operate == null)
			{
				System.out.println("ERROR");
				System.out.println("#表达式为空");
			}
			else
			{
				String o=operate[i];
				outcome[i] = oneOperate(o);
			}

		}
		
		fo.writeFile(f,operate,outcome,length);
	}
	
	public static int oneOperate(String operate)
	{
		//用来存放有效运算表达式
		
		Test ex = new Test();
		char[] opera = {'+','-','*','/','(',')','#'};
		int tip = 0;//记数其中的运算符
		System.out.println("operate[] "+operate);
		int  i= 0;
		while(i < operate.length())//for(int i = 0;i < operate.length();i++)
		{ 
			if(ex.ch(operate.charAt(i), opera ) == 0)
				tip++;
			i++;	
		}	
		StackOfIntegers OPND = new StackOfIntegers();// 创建数字对象
		OPND.stackofint(tip);
		StackOfIntegers OPTR = new StackOfIntegers();// 创建字符对象
		OPTR.stackofchar(operate.length()-tip);
		
		char optr[] = new char[operate.length()-tip];
		int m = 0;// 作为运算符串的累加
		int n = 0;//运算符数组累加
		int result = 0;

		OPTR.charpush(operate.charAt(m));
		m++;
		
		char e = OPTR.charpeek();//取栈顶第一个元素
		while (operate.charAt(m) != '#' || e != '#')
		{
			if (In(operate.charAt(m)) == 1)
			{
				int p = 1;//标记仅限寻找一次
				int t = 0;//找到的标记
				for(int i2 = m+1;i2<operate.length()&& p == 1;i2++)
				{
					if(In(operate.charAt(i2)) == 0)
					{
						t = i2;
						p =0;
					}						
				}
				int inta = Integer.parseInt(operate.substring(m,t));
				OPND.push(inta);
				m = t;				

			} 
			else
			{
				e = OPTR.charpeek();// 得到栈顶元素
				switch (Preceded(e, operate.charAt(m)))// 将栈顶元素与当前元素比较大小
				{
				case '<':
				{
					OPTR.charpush(operate.charAt(m));
					m++;
					break;
				}
				case '>':
				{
					char ch = OPTR.charpeek();
					OPTR.charpop();
					optr[n++] =ch;
					result = calculate(ch,OPND);// 计算表达式的结果
					break;
				}
				case '=':
				{
					OPTR.charpop();
					m++;
					break;
				}
				}
				e = OPTR.charpeek();
			}
		}
		return result;
	}
	// 判断是否是数字
	private static int In(char c)
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
	
	private static int calculate(char thera,StackOfIntegers opnd)
	{

		int a = 0,b = 0,e = 0;
		
		b = opnd.peek();
		opnd.pop();
		a = opnd.peek();
		opnd.pop();
		opnd.push(operate(a, thera, b));
		
		e =  opnd.peek();	
		return e;

	}
	
	private static int operate(int a, char thera, int b)
	{
		int total = 0;
		switch (thera)
		{
		case '+':
			total = a + b;
			break;
		case '-':
			total = a - b;
			break;
		case '*':
			total = a * b;
			break;
		case '/':
			total = a / b;
			break;
		}
		return total;
	}
}
