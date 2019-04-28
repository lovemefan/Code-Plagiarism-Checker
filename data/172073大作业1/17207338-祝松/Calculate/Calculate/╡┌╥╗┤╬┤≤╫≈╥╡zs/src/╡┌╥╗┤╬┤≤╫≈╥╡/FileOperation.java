package 第一次大作业;

import java.io.File;
import java.io.FileNotFoundException;//系统找不到指定的路径
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FileOperation
{
	//检查文件状态
	public void testFile(File f)
	{
		System.out.println("文件" + f.getName() + "是可读的吗:" + f.canRead());
		System.out.println("文件" + f.getName() + "的长度:" + f.length());
		System.out.println("文件"+f.getName() +"的绝对路径:" + f.getAbsolutePath());
		System.out.println(f.getName() + "是目录吗？" + f.isDirectory());
	}
	//写入
	public void writeFile(File f,String inputString[],int outcome[],int length)
	{
		try (PrintWriter output = new PrintWriter(f);)
		{	//PrintWriter:该类可用来创建一个文件并向文本文件写入数据。可以理解为java中的文件输出
			for(int i=0;i<length;i++)
			{
				output.println(inputString[i].replaceAll("[#]","")+" = "+outcome[i]);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	//读取
	public int readLine(File f)
	{
		int num =0 ;
		try (Scanner input = new Scanner(f);)
		{
			//判断是否有下一个值，有的话返回true，进行while循环，否则为false！
			while (input.hasNextLine())
			{	//nextLine()接受一行数据 以/r为结束
				String s = input.nextLine();
				num++;
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return num;
	}
	
}
