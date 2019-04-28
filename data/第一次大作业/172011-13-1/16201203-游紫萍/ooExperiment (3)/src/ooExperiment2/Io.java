package ooExperiment2;

//�ļ��������
import java.io.FileInputStream;


import java.io.InputStream;

import java.io.PrintStream;

import java.util.Scanner;

public class Io  {

	InputStream inputStream = System.in ;
	PrintStream outputStream = System.out;
	Scanner scan;
	
	Io() {
		try {
			inputStream = new FileInputStream("input.txt");
			outputStream = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
		scan = new Scanner(inputStream);
	}

	public Boolean getHasNextLine() {
		return scan.hasNextLine();// �ж��ļ��Ƿ�����һ��
	}

	public String getNextLine() {
		return scan.nextLine(); // �����ļ���������������
	}

	public void getAns(String ans) {
		outputStream.println(ans); // ���õ��Ľ��������ļ���
	}
}



