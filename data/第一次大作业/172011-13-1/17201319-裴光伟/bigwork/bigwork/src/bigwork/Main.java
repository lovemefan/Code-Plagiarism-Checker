package bigwork;

import java.util.Scanner;

public class Main {

	// 调用其它类和方法实现简易计算器
	public static void main(String[] args) throws Exception {
		String[] exp = IO.scan();// 将文件的字符串数组传给exp
		String[] exp1 = atFirst(exp);// 将原始请求保存到新字符串数组
		int s = IO.shu(exp);// 计算数组的有效数
		trans(exp, s);// 将字符串转为无空格并判断
		String[] result = new String[s];
		for (int i = 0; i < s; i++) {
			String a = Transform.transformExp(exp[i]);// 将文件中输入的表达式转换为固定形式
			String b = Transform.transformExpLast(a);// 将固定形式转换为后缀表达式
			double c = airth(b, exp, i);
			if (RegularExpression.errorPan(b))// 如果有错误直接输出
				result[i] = b;
			else if (RegularExpression.errorPan(exp[i]))// 计算后发现除数为0输出
				result[i] = exp[i];
			else
				result[i] = Transform.transformNoBlank(exp1[i]) + "=" + c;
		}
		IO.prin(result, s);// 将结果输入到文件
	}

	// 将原始请求保存到新字符串数组
	public static String[] atFirst(String[] exp) {
		String[] exp1 = new String[1000];
		for (int i = 0; i < 1000; i++)
			exp1[i] = exp[i];
		return exp1;
	}

	// 将字符串转为无空格并判断
	public static void trans(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (!RegularExpression.errorPan(exp[i]))// 请求没错转换该请求
				exp[i] = Transform.transformNoBlank(exp[i]);//将字符串的空格去除
		}
		RegularExpression.RegularExp(exp, s);
	}

	// 将转换完成的后缀表达式进行计算
	public static double airth(String exp, String[] exp1, int i) {
		Stack stack1 = new Stack(new Node(), new Node());// 栈初始化
		Scanner input = new Scanner(exp);
		double result = 0;
		if (!RegularExpression.errorPan(exp1[i]))// 请求没错计算该请求
			result = airthmetic(input, stack1, exp1, i);
		input.close();
		return result;
	}

	// 后缀表达式的计算方法
	public static double airthmetic(Scanner input, Stack stack1, String[] exp1, int i) {
		double a = 0;
		double b = 0;
		double result = 0;
		while (input.hasNext()) {
			String ch = input.next();// 判断是否为数字
			boolean pan = ch.matches("\\d*");
			if (pan) {// 为数字将数字存入栈
				int intvalue = Integer.parseInt(ch);
				stack1.printStack(intvalue);
			} else {// 为符号从栈取出2个数字计算
				switch (ch) {
				case "+":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b + a;
					stack1.printStack(result);
					break;
				case "-":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b - a;
					stack1.printStack(result);
					break;
				case "*":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b * a;
					stack1.printStack(result);
					break;
				case "/":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					if (a == 0) {// 除数为0输出错误
						exp1[i] = RegularExpression.errorPrint(exp1[i], "#表达式内除数为0");
						break;
					} else {// 不为0则直接计算
						result = b / a;
						stack1.printStack(result);
					}
					break;
				}
			}
		}
		return result;
	}
}
