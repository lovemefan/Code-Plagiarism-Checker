package ����ҵ;//���ʽ��һ��������������м���

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileAndMain {	
	static int num=1;
	public void writeFile(File f) {//д�ļ����������Ǹ�����֮ǰ�ļ����ı�����һ�����ʱ����ӡ��ʱ��д������
		try (PrintWriter output = new PrintWriter(f);){//�ı������ӡ�����ʽ����ʽ
			System.out.println("Please enter a expression,enter '#' to end:");
			Scanner input=new Scanner(System.in);
			String a=input.nextLine();
			while(!a.equals("#")) {
				output.println(a);
				System.out.println("Please enter a expression,enter '#' to end:");
				a=input.nextLine();
			}
			input.close();
								
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public void readLine(File f,File fw) throws IOException {
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//�س���һ�䣩Ϊ�ָ�
				String s = input.nextLine();//��ȡ�ļ��е��ַ�����Ϊ�����������
			//	System.out.print(s);
				Suffix.filetoexp(s,fw);
				continue;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {//main����������
		
		FileAndMain fo = new FileAndMain();//fo�ļ�������,�Լ�����
		File f = new File("src\\Waitforcalculate");	//f�����ļ�,java�ṩ��\\ת��,��ȡ�ļ�,f��Ϊ����
		File fw = new File("src\\output");
		//��̬�ļ���
		fo.writeFile(f);//������д���ļ���������ԭ������
		fo.readLine(f,fw);	//չʾ�ļ�����������
	}


}