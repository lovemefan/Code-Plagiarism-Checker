package ooExperiment2;

//文件输入输出
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
		return scan.hasNextLine();// 判断文件是否有下一句
	}

	public String getNextLine() {
		return scan.nextLine(); // 返回文件所读的那行内容
	}

	public void getAns(String ans) {
		outputStream.println(ans); // 将得到的结果输出到文件中
	}
}



