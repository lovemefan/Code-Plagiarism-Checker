package Project;

import java.io.*;
import java.util.Scanner;

public class File {
	// ���췽��
	public File() {

	}

	// �ļ���Ϣ���
	public String[] outputFile() throws FileNotFoundException {
		java.io.File file = new java.io.File("expression.txt");
		Scanner input = new Scanner(file);
		String[] expression = new String[10000];
		int i = 0;
		while (input.hasNext()) {
			//���ж�ȡ�ļ��������
			expression[i] = input.nextLine();
			i++;
		}
		input.close();
		return expression;
	}

	// ��Ϣд���ļ�
	public void inputFile(String[] expression, int s, String[] dealBlankExc, String[] postExpression)
			throws FileNotFoundException {
		java.io.File file = new java.io.File("result.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int i = 0; i < s; i++) {
			if (!dealEqual(dealBlankExc[i], dealBlankExc, i)) {
				continue;
			} else if (dealBlankExc[i].equals("")) {
				output.println("ERROR");
				output.println("#���ַ���");
			} else {
				input(postExpression[i], dealBlankExc[i], output);
			}
		}
		output.close();
	}

	// �±����
	public static int index(String[] expression) {
		int index = 0;
		while (expression[index] != null)
			index++;
		return index;
	}

	// �ж��Ƿ���ʽ��ͬ
	public boolean dealEqual(String string, String[] dealBlankExc, int n) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (string.equals(dealBlankExc[i])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	
//��Ϣ���� �ļ�
	public void input(String post, String DBE, PrintWriter output) {
		JudgeValid judge = new JudgeValid();
		Calculate culresult = new Calculate();
		if (judge.judge(DBE) == 1) {
			output.println("ERROR");
			output.println("#���ʽ�ں��Ƿ��ַ�");
		} else if (judge.judge(DBE) == 2) {
			output.println("ERROR");
			output.println("#���Ų����");
		} else if (judge.judge(DBE) == 3) {
			output.println("ERROR");
			output.println("#���ڿ�����");
		} else if (judge.judge(DBE) == 4) {
			output.println("ERROR");
			output.println("#���ʽ�������Ž�����");
		} else if (judge.judge(DBE) == 5) {
			output.println("ERROR");
			output.println("#�������Ž�����");
		} else if (judge.judge(DBE) == 6) {
			output.println("ERROR");
			output.println("#�������Ž��������)(֮��û�������");
		} else if (judge.judge(DBE) == 7) {
			output.println("ERROR");
			output.println("#���������");
		} else if (judge.judge(DBE) == 8) {
			output.println("ERROR");
			output.println("#������ﲻ�淶");
		} else {
			double result = culresult.calResult(post);
			if (String.valueOf(result) == "Infinity") {
				output.println("ERROR");
				output.println("#���ڷ�ĸΪ���");
			} else {
				output.println(DBE + "=" + result);
			}
		}
	}
}
