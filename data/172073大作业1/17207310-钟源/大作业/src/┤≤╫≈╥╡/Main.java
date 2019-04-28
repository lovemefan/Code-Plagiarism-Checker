	package 大作业;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		java.io.File file1 = new java.io.File("expression.txt");
		java.io.File file = new java.io.File("result.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		Scanner input = new Scanner(file1);
		
		LinkStack stack = new LinkStack();
		LinkStack1 stack1 = new LinkStack1();

		Loop: while (input.hasNext()) {// 如果文件内不为空
			String string = input.nextLine();// 文件读入

			Regexp regexp = new Regexp(string);// 创建了一个Regexp的类

			if (!regexp.isTure(string)) {// 正则表达式校验
				output.println("ERROR");
				output.println(regexp.export(string));
				System.out.println("you are wrong!");
				System.out.println(regexp.export(string));
				
				continue Loop;
			}

			Change x1 = new Change(string);// 创建一个Change类
			x1.transfer();// 使用Change类方法

			String temp = x1.nowlucky;
			Calculate x3 = new Calculate(temp, stack1);// 创建一个Calculate类
			x3.process();// 使用Calculate类方法

			int result = x3.getResult();
			output.println(result);// 文件写入结果
		}

		output.close();// 关闭文件

	}

}
