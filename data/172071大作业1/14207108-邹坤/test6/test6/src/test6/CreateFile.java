package test6;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateFile {
	//构造方法
	public CreateFile(){
		
	}
	
	//输入文件得到目标文件
	public void plintFile(String[] sentence) throws Exception{
		java.io.File file = new java.io.File("counter2.txt");
		if(file.exists()){
			System.out.println("文件已经存在");
			System.exit(1);
		}
		//创造一个文件
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for(int i = 0;i < line() ;i ++)
		 {
			output.println(sentence[i]);
		 }
		output.close();
	}
	
	//输出文件内容的方法
	public String[] scannerFlie() throws Exception{
		int i = 0;
		String[] expression = new String[line()];
		java.io.File file = new java.io.File("counter1.txt");
		if(!file.exists()){
			System.out.println("文件不存在");
			System.exit(1);
		}
		//为文件创造一个Scanner
		Scanner input = new Scanner(file);
		//读文件
		while (input.hasNext()){
			expression[i++] = input.nextLine();
		}
		//关闭文件；
		input.close();
		return expression;
	}
	
	//获得文件有多少行代码
	public int line() throws FileNotFoundException{
		int p = 0;
		java.io.File file = new java.io.File("counter1.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()){
			input.nextLine();
			p++;
		}
		input.close();
		return p;
	}
	
}
