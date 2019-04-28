package First;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		System.out.println("�������ִ��");
		in.nextLine();
		byte[] b = new byte[1000];
		FileInputStream re = new FileInputStream("E:/Workspace/First big assignment/src/First/du");
		re.read(b);
		StringBuffer str1 = new StringBuffer();

		for (int i = 0; i < b.length; i++) {

			if (b[i] != 0)
				
				str1 = str1.append((char) b[i]);
		}
		String str = str1.toString();// ����һ���ַ���
		String str2[] = str.split("\n|\r");
		for (int i = 0; i < str2.length; i++) {

			try {
				if (JudgeForm(str2[i]) == 0) {
					String obj = str2[i];
					ArrayList<String> arrayList = strFormat(obj);// ���ַ�����ʽ��ת����ArrayList
					String stri = str2[i] + "=" + calculator(arrayList);// ����ַ���
					System.out.println(stri);// ������
					FileOutputStream writes = new FileOutputStream("E:/Workspace/First big assignment/src/First/xie", true);// ��������ֽ��������������ļ���λ�ã������ܹ����ø����ļ���ԭ��������
					stri = stri + "\n";
					writes.write(stri.getBytes());// ��������뵽�ļ���
					writes.flush();
					//System.out.println("����Ѿ�д����Ӧ���ļ���");
				}
			} catch (Exception e) {
				
				System.out.println("#���ʽ��������,����������");
				
			}
			
		}
		System.out.println("����Ѿ�д����Ӧ���ļ���");
	}

	/**
	 * ���ú������ʽ������ 1����ǰ�ַ���Ϊ����ʱ��ֱ����ջ 2����ǰ�ַ���Ϊ�����ʱ��ȡ��ջ�е�ǰ��������
	 * 3�����������ٷ��뵽ջ�У�ջ�����ʣ���һ��Ԫ�ؾ���Ҫ��Ľ��
	 */
	private static int calculator(ArrayList<String> obj) {// ����ջ�����ݽ����֪ʶ��������ս��
		ArrayList<String> result = transform(obj);

		Stack<Integer> stack = new Stack<>();// ����һ��ջ

		for (int i = 0; i < result.size(); i++) {
			String symbol = result.get(i);
			if (isDigital(symbol)) { // ����ֱ����ջ
				stack.push(Integer.parseInt(symbol));
			} else { // ���������
				int num1, num2;
				num1 = stack.pop(); // ȡ��������
				num2 = stack.pop();
				switch (symbol) {
				case "+":
					stack.push(num2 + num1);
					break;
				case "-":
					stack.push(num2 - num1);
					break;
				case "*":
					stack.push(num2 * num1);
					break;
				case "/":
					stack.push(num2 / num1);
					break;
				default:
					break;
				}
			}
		}
		return stack.pop();
	}

	private static ArrayList<String> transform(ArrayList<String> arrayList) {// ���������Ϊ��������
		Stack<String> stack = new Stack<>();
		ArrayList<String> result = new ArrayList<>();
		for (int index = 0; index < arrayList.size(); index++) {
			String symbol = arrayList.get(index);
			if (isDigital(symbol)) { // ���������ֱ�����
				result.add(symbol);
			} else if (symbol.equals(")")) {
				String tmp;
				while (!(tmp = stack.pop()).equals("(")) { // ƥ��ɹ���ֹͣ
					result.add(tmp);
				}
			} else {
				if (stack.isEmpty()) {
					stack.push(symbol);
					continue;
				}
				String tmp = stack.peek();
				while (outPriority(symbol) <= inPriority(tmp)) { // ���ȼ�С��ջ�����ȼ���һֱ��ջ
					result.add(tmp);
					stack.pop();
					if (stack.isEmpty()) {
						break;
					}
					tmp = stack.peek();
				}
				stack.push(symbol);
			}
		}
		// ��ʣ��ĳ�ջ
		while (!stack.isEmpty()) {// �ж�ջ�Ƿ�Ϊ��
			result.add(stack.pop());
		}
		return result;
	}

	private static ArrayList<String> strFormat(String src) {// ���ȶ�String ���и�ʽ�� ת����ArrayList
		if (src == null || src.equals("")) {
			return null;
		}
		ArrayList<String> arrayList = new ArrayList<>();
		StringBuilder comChar = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			if (ch == ' ') {
				continue; // ȥ���ո�
			}
			if (!Character.isDigit(ch)) {
				if (!comChar.toString().trim().equals("")) {
					arrayList.add(comChar.toString().trim());
					comChar.delete(0, comChar.length());
				}
				arrayList.add(ch + "");
				continue;
			}
			comChar.append(ch);
		}
		if (!comChar.toString().trim().equals("")) {
			arrayList.add(comChar.toString().trim());
		}
		return arrayList;
	}

	private static boolean isDigital(String symbol) {// �ж��Ƿ�Ϊ����
		return !symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")
				&& !symbol.equals("(") && !symbol.equals(")");
	}

	private static int inPriority(String ch) {
		switch (ch) {
		case "+":
		case "-":
			return 2;
		case "*":
		case "/":
			return 4;
		case ")":
			return 7;
		case "(":
			return 1;
		default:
			return 0;
		}
	}

	public static int JudgeForm(String s) {// ����������ʽ�ж�ʽ���Ƿ���ȷ
		int flag = 1;

		String example2 = "[\\(][\\ ]{2}[\\*\\/\\+\\-]";
		String example3 = "[\\)][\\ ]{2}[\\d]";
		String example4 = "[\\d][\\ ]{2}[\\(]";
		String example5 = "[\\*\\/\\+\\-][\\ ]{2}[\\*\\/\\+\\-]";
		String example6 = "[\\(][\\ ]{2}[\\)]";//
		String example7 = "[\\+\\*\\/\\-][\\ ]{2}[\\)]";
		String example8 = "[^(\\+\\-\\*\\/)]";
		String example9 = "[$(\\+\\-\\*\\/)]";
		Pattern p2 = Pattern.compile(example2);
		Pattern p3 = Pattern.compile(example3);
		Pattern p4 = Pattern.compile(example4);
		Pattern p5 = Pattern.compile(example5);
		Pattern p6 = Pattern.compile(example6);
		Pattern p7 = Pattern.compile(example7);
		Pattern p8 = Pattern.compile(example8);
		Pattern p9 = Pattern.compile(example9);
		Matcher m2 = p2.matcher(s);// ����matcher��Ķ��� m2
		Matcher m3 = p3.matcher(s);// ����matcher��Ķ��� m3
		Matcher m4 = p4.matcher(s);// ����matcher��Ķ��� m4
		Matcher m5 = p5.matcher(s);// ����matcher��Ķ��� m5
		Matcher m6 = p6.matcher(s);// ����matcher��Ķ��� m6
		Matcher m7 = p7.matcher(s);// ����matcher��Ķ��� m7
		Matcher m8 = p8.matcher(s);// ����matcher��Ķ��� m7
		Matcher m9 = p9.matcher(s);// ����matcher��Ķ��� m7
		if (m2.find() || m3.find() || m4.find() || m5.find() || m6.find() || m9.find() || m7.find() || m8.find()) {
			flag = 0;
		} else {
			flag = 1;
		}

		return flag;
	}

	private static int outPriority(String ch) {
		switch (ch) {
		case "+":
		case "-":
			return 3;
		case "*":
		case "/":
			return 5;
		case ")":
			return 1;
		case "(":
			return 7;
		default:
			return 0;
		}
	}
}