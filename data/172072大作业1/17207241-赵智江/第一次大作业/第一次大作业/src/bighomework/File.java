package bighomework;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class File {
	File() {

	}

	// ���ļ��ж�ȡ����
	public String[] OutputFile() throws FileNotFoundException {
		String[] Except2 = new String[1000];
		java.io.File file = new java.io.File("kd.txt");
		if (file.exists()) {			
			Scanner input = new Scanner(file);
			int i = 0;
			while (input.hasNext()) {
				Except2[i] = input.nextLine();
				i++;
			}
			for (int m = i; m < 1000; m++) {
				Except2[m] = null;
			}
			
		}
		else{
			System.out.println("δ�ҵ�ָ���ļ�");
			System.exit(1);
		}
		return Except2;
	}

	// �����д���ļ�
	public void InputFile1(String[] s, String[] s1, int i) throws FileNotFoundException {
		int m = 0;
		java.io.File file = new java.io.File("kd3.txt");
		if (file.exists()) {
			System.out.println("File alrady exist");
			System.out.println("please change others file");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int j = 0; j < i; j++) {
			if (s1[j].equals("s0")) {
				output.println("ERROR");
				output.println("#��Ч����,���ַ���");
			} else if (s1[j].equals("s1")) {
				output.println("ERROR");
				output.println("#�����������ʽ��������");
			} else if (s1[j].equals("s4")) {
				output.println("ERROR");
				output.println("#��Ч���룬�����˲����ϱ��ʽ��׼���ַ�");
			} else if (s1[j].equals("s3")) {
				output.println("ERROR");
				output.println("#���Ż��������ʽ�������");
			} else if (s1[j].equals("s5")) {
				
				 output.println("ERROR");
				 output.println("#���ʽ�ظ�����");
			} else if (s1[j].equals("s2")) {
				output.println("ERROR");
				output.println("#����'/'����ʱ'/'��Ϊ��");

			} else {
				output.println(s[j] + "=" + s1[j]);
			}
		}
		output.close();
	}
}
