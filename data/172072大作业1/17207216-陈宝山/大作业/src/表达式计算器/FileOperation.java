package ���ʽ������;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperation {
//�����ַ������飬���ڴ洢���ʽ
	public int readFile(String[] s) {
		File file=new File("expression.txt");
		int i=0;
		int count=0;
		try(Scanner input=new Scanner(file);){
			while(input.hasNext()) {
				s[i++]=input.nextLine();
				count++;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
	public void writeFile(String[] s,int count, double[] result) {
		File file=new File("result.txt");
		try(PrintWriter output=new PrintWriter(file)){
			for(int i=0;i<count;i++)
				output.println(s[i].substring(0, s[i].indexOf('#'))+"="+result[i]);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
