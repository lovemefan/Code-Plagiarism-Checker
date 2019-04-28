package ����ҵһ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class FileOperate {
	public int readFile(String[] s) {
		File file = new File("src//expression");
		int i = 0;
		int count = 0;
		try (Scanner input = new Scanner(file);) {
			while (input.hasNext()) {
				s[i++] = input.nextLine();
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void writeFile(String[] s, int count, double[] result) {
		File file = new File("src//result");
		try (PrintWriter output = new PrintWriter(file)) {
			for (int i = 0; i < count; i++)
				output.println(s[i].substring(0, s[i].indexOf('#')) + "=" + result[i]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Error {
	public static void e_null(String[] s, int count) {
		if (count == 0) {
			System.out.println("ERROR" + "\n" + "#���ʽΪ��");
			System.exit(0);
		}
	}

	public static void e_kkh(String[] s, int count) {// ���ʽ���п�����
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			int j = 0;
			temp = s[i].split("");
			char ch1 = temp[j].charAt(0);
			char ch2 = temp[j + 1].charAt(0);
			if (ch1 == '(' && ch2 == ')') {
				System.out.println("ERROR" + "\n" + "#���ʽ���п�����");
				System.exit(0);
			}
			j++;
		}
	}
/*
	public static void e_character(String[] s, int count) {// ���ʽ���зǷ��ַ�
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			for (int j = 0; j < temp.length; j++) {
				char ch = temp[j].charAt(0);
				if ((ch < 48 || ch > 57)
						&& (ch != '#' && ch != '(' && ch != ')' && ch != '+' && ch != '-' && ch != '*' && ch != '/')) {
					System.out.println("ERROR" + "\n" + "#���ʽ���зǷ��ַ�");
					System.exit(0);
				}
			}
		}
	}
*/
	public static void e_khbpp(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			int indexf = 0;
			int indext = 0;
			String[] temp = new String[40];
			temp = s[i].split("");
			for (int j = 0; j < temp.length; j++) {
				char ch = temp[j].charAt(0);
				if (ch == '(') {
					indexf++;
				} else if (ch == ')') {
					indext++;
				}
			}
			if (indexf != indext) {
				System.out.println("ERROR" + "\n" + "#���ʽ���Ų�ƥ��");
				System.exit(0);
			}
		}
	}

	public static void e_first(String[] s, int count) {// ���ŷǵ�һ���ַ���֮ǰ��������
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			char ch = temp[0].charAt(0);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				System.out.println("ERROR" + "\n" + "#���ŷǵ�һ���ַ���֮ǰ�������� ");
				System.exit(0);
			}
		}
	}

	public static void e_yswx(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			int j = 0;
			temp = s[i].split("");
			char ch1 = temp[j].charAt(0);
			char ch2 = temp[j + 1].charAt(0);
			if ((ch1 == '(') && (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')) {
				System.out.println("ERROR" + "\n" + "#С���ź��������������ŷ����һ���ַ�");
				System.exit(0);
			}

			j++;
		}
	}
/*
	public static void e_trnd(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			for (int j = 0; j < temp.length - 2; j++) {
				char ch1 = temp[j].charAt(0);
				char ch2 = temp[j + 1].charAt(0);
				char ch3 = temp[j + 2].charAt(0);
				if ((ch1 >= 48 && ch1 <= 57) && (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')
						&& (ch3 == '+' || ch3 == '-' || ch3 == '*' || ch3 == '/')) {
					System.out.println("ERROR" + "\n" + "#���������������");
					System.exit(0);
				} else if ((ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/')
						&& (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/') && (ch3 >= 48 && ch3 <= 57)) {
					System.out.println("ERROR" + "\n" + "#�����ǰ��������");
					System.exit(0);
				}
			}
		}
	}
	*/

	public static void error(String[] s, int count) {
		Error.e_null(s, count);// ���ʽΪ��
		Error.e_kkh(s, count);// ���ʽ���п�����
	//	Error.e_character(s, count);// ���ʽ���зǷ��ַ�
		Error.e_khbpp(s, count);// ���ʽ���Ų�ƥ��
		Error.e_first(s, count);// ���ŷǵ�һ���ַ���֮ǰ��������
		Error.e_yswx(s, count);// С���ź��������������ŷ����һ���ַ�
	//	Error.e_trnd(s, count);// �����ǰ��������

	}

}

public class Calcu {

	public static void main(String[] args) {
		FileOperate f = new FileOperate();

		int count;// ���ʽ����

		Stack<Character> stackoptr = new Stack<Character>(); // ��������
		Stack<Double> stackopnd = new Stack<Double>(); // ��Ų�����

		stackoptr.clear();
		stackopnd.clear();
		String[] s = new String[15]; // ��ű��ʽ
		String[] temp = new String[40];
		double value;
		double n1, n2;// �����
		char theta;
		double[] result = new double[10];// ��ű��ʽ���
		count = f.readFile(s);// ��ȡ�ļ��������ر��ʽ����

		Error.error(s, count);

		stackoptr.push('#');

		for (int i = 0; i < count; i++) {
			temp = s[i].split("");// ʹ���ַ�����֣��ѱ��ʽ���һ�������ַ���

			char ch = temp[0].charAt(0);// �����ַ���ת��Ϊ�ַ�
			char c = stackoptr.peek();// ��c��ΪΪ�����ջ��ջ��Ԫ��
			int j = 0;

			while (ch != '#' || c != '#') {// ��ջ��Ԫ�غ�����Ԫ�ز�ͬʱΪ#ʱ�����б��ʽ����
				if (ch >= 48 && ch <= 57) {// ������Ԫ��Ϊ�����ַ�ʱ��ת�������֣�Ȼ����������ջ
					value = Double.parseDouble(temp[j]);
					stackopnd.push(value);
					ch = temp[++j].charAt(0);// ch������һ�ַ�
				} else {// ��������ȼ��ж�
					switch (prior(c, ch)) {// �Ƚ������ջջ��Ԫ�غ�����Ԫ�ص�����Ȩ
					case '<':
						stackoptr.push(ch);
						ch = temp[++j].charAt(0);
						break;
					case '=':
						stackoptr.pop();
						ch = temp[++j].charAt(0);
						break;
					case '>':
						n2 = stackopnd.pop();
						n1 = stackopnd.pop();
						theta = stackoptr.pop();
						stackopnd.push(operate(n1, theta, n2));
						break;
					}
				}
				c = stackoptr.peek();
			}
			result[i] = stackopnd.pop();// ���ʽ���
		}
		f.writeFile(s, count, result);

	}

	public static char prior(char a, char b) {// ���ȼ�
		char[][] ch = { { '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '<', '<', '<', '>', '>' },
				{ '>', '>', '>', '>', '<', '>', '>' }, { '>', '>', '>', '>', '<', '>', '>' },
				{ '<', '<', '<', '<', '<', '=', ' ' }, { '>', '>', '>', '>', ' ', '>', '>' },
				{ '<', '<', '<', '<', '<', ' ', '=' } };
		return ch[index(a)][index(b)];
	}

	public static int index(char a) {
		int index = 0;
		if (a == '+')
			index = 0;
		if (a == '-')
			index = 1;
		if (a == '*')
			index = 2;
		if (a == '/')
			index = 3;
		if (a == '(')
			index = 4;
		if (a == ')')
			index = 5;
		if (a == '#')
			index = 6;
		return index;
	}

	public static double operate(double n1, char theta, double n2) {
		double result = 0;
		if (theta == '+')
			result = n1 + n2;
		if (theta == '-')
			result = n1 - n2;
		if (theta == '*')
			result = n1 * n2;
		if (theta == '/')
			result = n1 / n2;
		return result;
	}
}