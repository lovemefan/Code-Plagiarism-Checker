package 第一次大作业;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hello
{
	public static void main(String[] args) throws IOException
	{
		//让用户输入表达式，并将其暂存入数组中
		Enter e=new Enter();
		String[] inputString=e.enter();
	
		//表达式校验
		Test t=new Test(inputString);
		String[] string=t.test(inputString);//经过检验的值返回到string数组里

		//将经过检验的表达式进行计算
		Calculate c=new Calculate();
		c.allOperate(string);	


	}

}
