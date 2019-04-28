package 大作业1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Midd
{
	

	public static void main(String[] args) throws IOException 
	{
		int length = 0;//返回文件行数
		
		FileOperation fo = new FileOperation();
		File f = new File("src\\Operation");
		
		length = fo.readLine(f);
		String[] op = new String[length];//读取文件中的运算表达式进行异常判断
		String[] Nop = new String[length];//得到新的完整无错的表达式
		int i = 0;
		//将文件里的算术表达式放入数组里
		try (Scanner sc = new Scanner(f);)
		{
			while (sc.hasNextLine())
			{
				String s = sc.nextLine();// 以回车符判断
				op[i] = s;
				i++;
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		//检测表达式是否符合规范
		Expetion ex = new Expetion();
		Nop = ex.Expetion(op,length);
		//进行计算操作

		Op ope = new Op();
		ope.Op(Nop);
		

	}

}
