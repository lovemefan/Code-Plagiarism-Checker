import java.util.Scanner;
import java.io.*;

//import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��������
		Write w = new Write();
		Evaluate e = new Evaluate();
		Regex r = new Regex();
		Io i = new Io(e,w,r);
		
		//�û�����
		System.out.println("������TXT�ļ��ļ���������Enter���Խ��в���");
		System.out.println("�����ʽ��X:\\filename.txt �� X:/filename.txt��filename.txt(�����ļ��ڹ����ļ��и�Ŀ¼��ʱ)");	
		
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();	
		File file = new File(str);
		
		//����У��
		while(!file.exists()) {
			System.out.println("�ļ�û���ҵ��������������׼�ļ���");
			String str2="";
			str2 = input.nextLine();
			//System.out.println(str2);
			File file2 = new File(str2);
			file = file2;
			str = str2;
			//System.out.println(str);
		}
		
		
		
		System.out.println(str);
		i.reader(str);
		
		

		System.out.println("Over");
		System.out.println("����ļ��������ڹ����ļ��и�Ŀ¼�� YourResults.txt");
		input.close();

		
		
		

	}

}
