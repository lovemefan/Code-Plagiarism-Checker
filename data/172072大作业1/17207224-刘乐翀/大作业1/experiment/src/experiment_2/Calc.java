package experiment_2;

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
		File file = new File("src//re");
		try (PrintWriter output = new PrintWriter(file)) {
			for (int i = 0; i < count; i++)
				output.println(s[i].substring(0, s[i].indexOf('#')) + "=" + result[i]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Seek {
	public void seek_ERROR(String[] s, int count) {
		seek_null(count);
		seek_bracket(s, count);
//		seek_character(s, count);
//		seek_continuous(s, count);
		seek_first(s, count);
		seek_notmatch(s, count);
//		seek_trnd(s, count);
	}

	public void seek_null(int count) {
		if (count == 0) {
			System.out.println("ERROR" + "\n" + "#表达式为空");
			System.exit(0);
		}
	}

	public void seek_bracket(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			int j = 0;
			temp = s[i].split("");
			char ch1 = temp[j].charAt(0);
			char ch2 = temp[j + 1].charAt(0);
			if (ch1 == '(' && ch2 == ')') {
				System.out.println("ERROR" + "\n" + "#表达式中有空括号");
				System.exit(0);
			}
			j++;
		}
	}
/*
	public void seek_character(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			for (int j = 0; j < temp.length; j++) {
				char ch = temp[j].charAt(0);
				if ((ch < 48 || ch > 57)
						&& (ch != '#' && ch != '(' && ch != ')' && ch != '+' && ch != '-' && ch != '*' && ch != '/')) {
					System.out.println("ERROR" + "\n" + "#表达式中有非法字符");
					System.exit(0);
				}
			}
		}
	}
*/
	public void seek_notmatch(String[] s, int count) {
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
				System.out.println("ERROR" + "\n" + "#表达式括号不匹配");
				System.exit(0);
			}
		}
	}
/*
	public void seek_continuous(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			int j = 0;
			temp = s[i].split("");
			char ch1 = temp[j].charAt(0);
			char ch2 = temp[j + 1].charAt(0);
			if ((ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/')
					&& (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')) {
				System.out.println("ERROR" + "\n" + "#运算符连续");
				System.exit(0);
			}
			if ((ch1 == '(') && (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')) {
				System.out.println("ERROR" + "\n" + "#小括号后无运算数，括号非最后一个字符");
				System.exit(0);
			}
			
			 else if(ch1=='('&&ch2=='#') {
			 System.out.println("ERROR"+"\n"+"#小括号后无运算数，括号非最后一个字符"); System.exit(0); }
			 
			j++;
		}
	}
*/
	public void seek_first(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			char ch = temp[0].charAt(0);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				System.out.println("ERROR" + "\n" + "#括号非第一个字符且之前无运算数 ");
				System.exit(0);
			}
		}
	}
/*
	public void seek_trnd(String[] s, int count) {
		for (int i = 0; i < count; i++) {
			String[] temp = new String[40];
			temp = s[i].split("");
			for (int j = 0; j < temp.length - 2; j++) {
				char ch1 = temp[j].charAt(0);
				char ch2 = temp[j + 1].charAt(0);
				char ch3 = temp[j + 2].charAt(0);
				if ((ch1 >= 48 && ch1 <= 57) && (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')
						&& (ch3 == '+' || ch3 == '-' || ch3 == '*' || ch3 == '/')) {
					System.out.println("ERROR" + "\n" + "#运算符后无运算数");
					System.exit(0);
				} else if ((ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/')
						&& (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/') && (ch3 >= 48 && ch3 <= 57)) {
					System.out.println("ERROR" + "\n" + "#运算符前无运算数");
					System.exit(0);
				}
			}
		}
	}
	*/
}



public class Calc {
	public static void main(String[] args) {
		FileOperate f = new FileOperate();
		Seek seek = new Seek();
//		stack stack = new stack();

		Stack<Character> stackoptr = new Stack<Character>(); // 设栈optr存放运算符
		Stack<Double> stackopnd = new Stack<Double>(); // 设栈opnd存放操作数

		String[] s = new String[15]; // 存放表达式
		String[] temp = new String[40];
		double[] result = new double[10];// 存放表达式结果
		int count = f.readFile(s);// 读取文件，并返回表达式个数
		seek.seek_ERROR(s, count);// 错误检测

		stackoptr.push('#');
		double value;
		double nd1, nd2;// 运算符
		char theta;
		for (int i = 0; i < count; i++) {
			temp = s[i].split("");// 使用字符串拆分，把表达式拆成一个个子字符串
			char ch = temp[0].charAt(0);// 把子字符串转换为字符
			char c = stackoptr.peek();// 让c成为为运算符栈的栈顶元素
			int j = 0;
			while (ch != '#' || c != '#') {// 当栈顶元素和输入元素不同时为#时，进行表达式计算
				if (ch >= 48 && ch <= 57) {// 当输入元素为数字字符时，转换成数字，然后进入操作数栈
					value = Double.parseDouble(temp[j]);
					stackopnd.push(value);
					ch = temp[++j].charAt(0);// ch接收下一字符
				} else {// 运算符优先级判断
					switch (prior(c, ch)) {// 比较运算符栈栈顶元素和输入元素的优先权
					case '<':
						stackoptr.push(ch);
						ch = temp[++j].charAt(0);
						break;
					case '=':
						stackoptr.pop();
						ch = temp[++j].charAt(0);
						break;
					case '>':
						nd2 = stackopnd.pop();
						nd1 = stackopnd.pop();
						theta = stackoptr.pop();
						stackopnd.push(operate(nd1, theta, nd2));
						break;
					}
				}
				c = stackoptr.peek();
			}

		}
		
		for (int i = 0; i < count; i++) {
			result[i] = stackopnd.pop();// 表达式结果
		}
		f.writeFile(s, count, result);
	}
	public static char prior(char a, char b) {// 优先级
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