package 第一次大作业;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*文件操作类*/
public class FileOperate {
	
	/*按行读取文件内容*/
	public String[] readLine(File f,int n) {
		String[] s = new String[n];
		try (Scanner input = new Scanner(f);){
			for(int i=0; i<n; i++)
				s[i] = input.nextLine();//从Scanner中读取一行，以换行结束
		
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
	
}