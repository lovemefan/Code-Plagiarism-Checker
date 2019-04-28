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
		System.out.println("按任意键执行");
		in.nextLine();
		byte[] b = new byte[1000];
		FileInputStream re = new FileInputStream("E:/Workspace/First big assignment/src/First/du");
		re.read(b);
		StringBuffer str1 = new StringBuffer();

		for (int i = 0; i < b.length; i++) {

			if (b[i] != 0)
				
				str1 = str1.append((char) b[i]);
		}
		String str = str1.toString();// 接受一个字符串
		String str2[] = str.split("\n|\r");
		for (int i = 0; i < str2.length; i++) {

			try {
				if (JudgeForm(str2[i]) == 0) {
					String obj = str2[i];
					ArrayList<String> arrayList = strFormat(obj);// 将字符串格式化转化成ArrayList
					String stri = str2[i] + "=" + calculator(arrayList);// 结果字符串
					System.out.println(stri);// 输出结果
					FileOutputStream writes = new FileOutputStream("E:/Workspace/First big assignment/src/First/xie", true);// 建立输出字节流，而且设置文件的位置，并且能够不用覆盖文件的原来的内容
					stri = stri + "\n";
					writes.write(stri.getBytes());// 将结果输入到文件里
					writes.flush();
					//System.out.println("结果已经写到相应的文件里");
				}
			} catch (Exception e) {
				
				System.out.println("#表达式输入有误,请重新输入");
				
			}
			
		}
		System.out.println("结果已经写到相应的文件里");
	}

	/**
	 * 采用后续表达式计算结果 1、当前字符串为数字时，直接入栈 2、当前字符串为计算符时，取出栈中的前两个计算
	 * 3、将计算结果再放入到栈中，栈中最后剩余的一个元素就是要求的结果
	 */
	private static int calculator(ArrayList<String> obj) {// 运用栈的数据结果的知识计算出最终结果
		ArrayList<String> result = transform(obj);

		Stack<Integer> stack = new Stack<>();// 建立一个栈

		for (int i = 0; i < result.size(); i++) {
			String symbol = result.get(i);
			if (isDigital(symbol)) { // 数字直接入栈
				stack.push(Integer.parseInt(symbol));
			} else { // 处理操作符
				int num1, num2;
				num1 = stack.pop(); // 取出两个数
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

	private static ArrayList<String> transform(ArrayList<String> arrayList) {// 中序遍历改为后续遍历
		Stack<String> stack = new Stack<>();
		ArrayList<String> result = new ArrayList<>();
		for (int index = 0; index < arrayList.size(); index++) {
			String symbol = arrayList.get(index);
			if (isDigital(symbol)) { // 如果是数字直接输出
				result.add(symbol);
			} else if (symbol.equals(")")) {
				String tmp;
				while (!(tmp = stack.pop()).equals("(")) { // 匹配成功后停止
					result.add(tmp);
				}
			} else {
				if (stack.isEmpty()) {
					stack.push(symbol);
					continue;
				}
				String tmp = stack.peek();
				while (outPriority(symbol) <= inPriority(tmp)) { // 优先级小于栈内优先级，一直出栈
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
		// 将剩余的出栈
		while (!stack.isEmpty()) {// 判断栈是否为空
			result.add(stack.pop());
		}
		return result;
	}

	private static ArrayList<String> strFormat(String src) {// 首先对String 进行格式化 转化成ArrayList
		if (src == null || src.equals("")) {
			return null;
		}
		ArrayList<String> arrayList = new ArrayList<>();
		StringBuilder comChar = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			if (ch == ' ') {
				continue; // 去除空格
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

	private static boolean isDigital(String symbol) {// 判断是否为数字
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

	public static int JudgeForm(String s) {// 运用正则表达式判断式子是否正确
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
		Matcher m2 = p2.matcher(s);// 创建matcher类的对象 m2
		Matcher m3 = p3.matcher(s);// 创建matcher类的对象 m3
		Matcher m4 = p4.matcher(s);// 创建matcher类的对象 m4
		Matcher m5 = p5.matcher(s);// 创建matcher类的对象 m5
		Matcher m6 = p6.matcher(s);// 创建matcher类的对象 m6
		Matcher m7 = p7.matcher(s);// 创建matcher类的对象 m7
		Matcher m8 = p8.matcher(s);// 创建matcher类的对象 m7
		Matcher m9 = p9.matcher(s);// 创建matcher类的对象 m7
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