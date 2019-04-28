package bighomework;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class File {
	File() {

	}

	// 从文件中读取内容
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
			System.out.println("未找到指定文件");
			System.exit(1);
		}
		return Except2;
	}

	// 将结果写入文件
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
				output.println("#无效输入,空字符串");
			} else if (s1[j].equals("s1")) {
				output.println("ERROR");
				output.println("#括号数量或格式出现问题");
			} else if (s1[j].equals("s4")) {
				output.println("ERROR");
				output.println("#无效输入，输入了不符合表达式标准的字符");
			} else if (s1[j].equals("s3")) {
				output.println("ERROR");
				output.println("#括号或运算符格式输入错误");
			} else if (s1[j].equals("s5")) {
				
				 output.println("ERROR");
				 output.println("#表达式重复输入");
			} else if (s1[j].equals("s2")) {
				output.println("ERROR");
				output.println("#进行'/'运算时'/'后为零");

			} else {
				output.println(s[j] + "=" + s1[j]);
			}
		}
		output.close();
	}
}
