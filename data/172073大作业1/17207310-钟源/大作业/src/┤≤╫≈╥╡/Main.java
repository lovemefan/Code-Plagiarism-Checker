	package ����ҵ;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		java.io.File file1 = new java.io.File("expression.txt");
		java.io.File file = new java.io.File("result.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		Scanner input = new Scanner(file1);
		
		LinkStack stack = new LinkStack();
		LinkStack1 stack1 = new LinkStack1();

		Loop: while (input.hasNext()) {// ����ļ��ڲ�Ϊ��
			String string = input.nextLine();// �ļ�����

			Regexp regexp = new Regexp(string);// ������һ��Regexp����

			if (!regexp.isTure(string)) {// ������ʽУ��
				output.println("ERROR");
				output.println(regexp.export(string));
				System.out.println("you are wrong!");
				System.out.println(regexp.export(string));
				
				continue Loop;
			}

			Change x1 = new Change(string);// ����һ��Change��
			x1.transfer();// ʹ��Change�෽��

			String temp = x1.nowlucky;
			Calculate x3 = new Calculate(temp, stack1);// ����һ��Calculate��
			x3.process();// ʹ��Calculate�෽��

			int result = x3.getResult();
			output.println(result);// �ļ�д����
		}

		output.close();// �ر��ļ�

	}

}
