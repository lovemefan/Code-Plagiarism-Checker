package 第一次大作业;

import java.io.IOException;

public class Test
{
	
	public String[] outputString;
	//无参构造方法
	public Test()
	{

	}
	//有参构造方法
	public Test(String[] outputString)
	{
		this.outputString=outputString;
	}
	//判断是否是指定字符
	public static int ch(char c, char[] op)
	{
		int tip = 0;
		for (int i = 0; i < op.length; i++)
		{
			if (c == op[i])
				tip = 1;
		}
		if (tip == 0)
			return 0;//返回0表示不是指定字符
		else
			return 1;//返回1表达属于指定字符

	}
	public static int interesting(char c)//判断是否是数字
	{
		if(c >= 48 && c <= 57 )
			return 1;//返回1表达属于数字
		else
			return 0;//返回0表示不属于数字

	}
	public static String[] test(String[] inputString) throws IOException
	{	
		String[] string = new String[inputString.length];
		char[] opera = {'+','-','*','/'};
		Calculate test = new Calculate();
		int t = 0;
		for(int i = 0; i< inputString.length;i++)
		{

			int tip = 0;//
			int kuohao = 0;//作用于括号为空时
			int notDoc = 0;//作用表达式包含非法字符
			boolean mismatch = true; 
			boolean mismatch1 = true; 
			boolean continuope = true;
			boolean Fope = true;
			boolean Lope = true;
			boolean Fkuohao = true;
			boolean Lkuohao = true;
			boolean error = true;
			
			char[] ss = new char[inputString[i].length()];//取一个运算公式	
			ss = inputString[i].toCharArray();
			
			for(int n =i+1;n < inputString.length;n++)
			{
				if(inputString[i].equals(inputString[n]))
					error = false;
			}
			for(int j = 0;j<ss.length;j++)//计算一些特定值
			{
			
				//存在空括号
				if(ss[j] == '('&&ss[j+1] == ')')
				{
					kuohao = 1;
				}
				//interesting函数判断是否为数字   ch函数判断是否为指定运算里面的字符
				if((interesting(ss[j])== 1)||(ch(ss[j],test.OP) == 1))
				{
					notDoc ++;
				}
				//括号不匹配				
				if(ss[j] == '(' || ss[j] == ')')
				{
					tip ++;//计算括号数量，是否成对					
				}
				if(ss[j] == ')' && j != ss.length-2)//)(有问题，判断括号左边是运算符，右边是数字
				{
					if(ch(ss[j-1],opera) == 1||interesting(ss[j+1]) == 1||ss[j+1] == '(')
					{
						mismatch = false;
					}
				}
				if(ss[j] == '('&& j != 1)//判断括号左边是数字  右边是运算符
				{
					if(ch(ss[j+1],opera) == 1||interesting(ss[j-1]) == 1)
					{
						mismatch1 = false;
					}
				}
				//运算符连续
				if(ch(ss[j],opera) == 1 && ch(ss[j+1],opera) == 1 && !(j == 0|| j == ss.length-2))
				{
					continuope = false;
				}
				//运算符无效（运算符前无运算数）  可以接）+
				if(ch(ss[j],opera) == 1)
				{
					if(interesting(ss[j-1]) == 0 && ss[j-1] != ')')
						Fope = false;
				}
				//运算符无效（运算符后无运算数） 问题？可以接左括号+（
				if(ch(ss[j],opera) == 1)
				{
					if(interesting(ss[j+1]) == 0 && ss[j+1] != '(')
						Lope = false;
				}
				//运算符无效（小括号前无运算数，括号非第一个字符）
				if(ss[j] == '(')
				{
					if(interesting(ss[j-1]) == 1)
						Fkuohao = false;
				}
				
				//运算符无效（小括号后无运算数，括号非第一个字符）
				if(ss[j] == ')')
				{
					if(interesting(ss[j+1]) == 1)
						Lkuohao = false;
				}
			}
			//判断表达式是否为空
			if(inputString[i].length() == 0 || inputString[i].length() == 2)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#表达式为空");
			}
			//表达式中有空括号
			if(kuohao == 1)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#表达式中有空括号");
			}
			//表达式包含非法字符
			if(notDoc != ss.length)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#表达式包含非法字符");
			}
			//括号不匹配

			if(tip%2 != 0||mismatch == false||mismatch == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#括号不匹配");
			}
			//运算符连续
			if(continuope == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#运算符连续");
			}
			//运算符无效（运算符前无运算数）
			if(Fope == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#运算符无效（运算符前无运算数）");
			}
			//运算符无效（运算符后无运算数）
			if(Lope == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#运算符无效（运算符后无运算数）");
			}
			//运算符无效（小括号前无运算数，括号非第一个字符）
			if(Fkuohao == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#运算符无效（小括号前无运算数，括号非第一个字符）");
			}
			//运算符无效（小括号后无运算数，括号非第一个字符）
			if(Lkuohao == false)
			{
				error = false;
				System.out.println("ERROR");
				System.out.println("#运算符无效（小括号后无运算数，括号非第一个字符）");
			}
			if(error == true)
			{
				string[t++] = inputString[i];
			}
		}

		return string;
	}

}
