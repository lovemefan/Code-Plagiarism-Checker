package 大作业1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperation
{

	public void testFile(File f)
	{
		System.out.println("文件" + f.getName() + "是可读的吗:" + f.canRead());// 文件是否能读写
		System.out.println("文件" + f.getName() + "的长度:" + f.length());// 文件长度
		System.out.println("文件" + f.getName() + "的绝对路径:" + f.getAbsolutePath());// 文件地址
		System.out.println(f.getName() + "是目录吗？" + f.isDirectory());// 是否为文件夹的操作
	}

	public int  readLine(File f)
	{
		int num = 0; 
		try (Scanner input = new Scanner(f);)
		{
			while (input.hasNextLine())
			{
				String s = input.nextLine();// 以回车符判断
				num++;
				// System.out.println(s);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return num;
	}

	public void read(File f)
	{
		// 读取文件
		try (Scanner input = new Scanner(f);)
		{
			while (input.hasNext())
			{
				String s = input.next();// 以空格为基础
				System.out.println(s);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void writeFile(File f,String[] op,int[] result,int length)
	{
		try (PrintWriter output = new PrintWriter(f);)
		{
			 for (int i = 0; i < length; i++)
			 {
				 output.println(op[i].replaceAll("[#]","")+ " = " + result[i]);// 
			 }
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
	}
}
