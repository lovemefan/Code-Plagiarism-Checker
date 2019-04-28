package 大作业01;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*文件操作类*/
public class ExpFileOperate {
	
	/*按行读取文件内容*/
	public String[] readLine(File f,int n) {
		String[] s = new String[n];
		try (Scanner input = new Scanner(f);){
			//while(input.hasNextLine()) {//如果Scanner中还有更多数据可以读取，则返回true	
			for(int i=0; i<n; i++)
				s[i] = input.nextLine();//从Scanner中读取一行，以换行结束
				
		//		System.out.println(s);				
		//	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*输出、写入到文件中*/
	public void writeFile(File f, String[] s, int[] value, int n) {
		try (PrintWriter output = new PrintWriter(f);){
			for(int i=0; i<n; i++)
				output.println(s[i] + "=" + value[i]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	
	}
	/*
	public void writeFile(File f, int m) throws IOException {
		try(FileWriter fileWriter =new FileWriter(f, true);) {
			if(m == 1) {
				fileWriter.write("ERROR");
				fileWriter.write("#表达式为空");
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
