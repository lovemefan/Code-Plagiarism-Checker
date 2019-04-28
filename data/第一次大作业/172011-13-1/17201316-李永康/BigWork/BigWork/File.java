package BigWork;
import java.util.Scanner;
import java.io.*;

public class File { 
	//构造函数	
	File(){
	}
	//读取文件的行数
	public int numFile()throws FileNotFoundException{
		java.io.File file = new java.io.File("BigWork.txt");
		Scanner input = new Scanner(file);
		int p = 0;
		while(input.hasNextLine()){
			String temp = input.nextLine();
			p ++;
		}
		input.close();
		return p;
	}
	//读取文件的内容
	public String[] readFile()throws FileNotFoundException{
		java.io.File file = new java.io.File("BigWork.txt");
		String[] posture = new String[numFile()];
		Scanner input = new Scanner(file);
		for(int i = 0;i < numFile();i ++){
			posture[i] = input.nextLine();
		}
		input.close();
		return posture;
	}
	//将结果写入文件
	public void writeFile(String[] a)throws FileNotFoundException{
		java.io.File file = new java.io.File("Write_BigWork.txt");
		try(PrintWriter output = new PrintWriter(file);){
			for(int k = 0;k < a.length;k ++){
				output.println(a[k]);
			}
		}
	}
}
