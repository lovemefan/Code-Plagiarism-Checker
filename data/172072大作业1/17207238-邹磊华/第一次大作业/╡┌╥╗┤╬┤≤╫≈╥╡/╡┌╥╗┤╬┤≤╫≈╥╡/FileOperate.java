package ��һ�δ���ҵ;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*�ļ�������*/
public class FileOperate {
	
	/*���ж�ȡ�ļ�����*/
	public String[] readLine(File f,int n) {
		String[] s = new String[n];
		try (Scanner input = new Scanner(f);){
			for(int i=0; i<n; i++)
				s[i] = input.nextLine();//��Scanner�ж�ȡһ�У��Ի��н���
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*�����д�뵽�ļ���*/
	public void writeFile(File f, String[] s, int[] value, int n) {
		try (PrintWriter output = new PrintWriter(f);){
			for(int i=0; i<n; i++)
				output.println(s[i] + "=" + value[i]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	
	}
	
}