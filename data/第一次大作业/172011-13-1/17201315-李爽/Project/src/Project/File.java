package Project;

import java.io.*;
import java.util.Scanner;

public class File {
	// 构造方法
	public File() {

	}

	// 文件信息输出
	public String[] outputFile() throws FileNotFoundException {
		java.io.File file = new java.io.File("expression.txt");
		Scanner input = new Scanner(file);
		String[] expression = new String[10000];
		int i = 0;
		while (input.hasNext()) {
			//按行读取文件里的内容
			expression[i] = input.nextLine();
			i++;
		}
		input.close();
		return expression;
	}

	// 信息写入文件
	public void inputFile(String[] expression, int s, String[] dealBlankExc, String[] postExpression)
			throws FileNotFoundException {
		java.io.File file = new java.io.File("result.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int i = 0; i < s; i++) {
			if (!dealEqual(dealBlankExc[i], dealBlankExc, i)) {
				continue;
			} else if (dealBlankExc[i].equals("")) {
				output.println("ERROR");
				output.println("#空字符串");
			} else {
				input(postExpression[i], dealBlankExc[i], output);
			}
		}
		output.close();
	}

	// 下标计算
	public static int index(String[] expression) {
		int index = 0;
		while (expression[index] != null)
			index++;
		return index;
	}

	// 判断是否表达式相同
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
	
	
//信息输入 文件
	public void input(String post, String DBE, PrintWriter output) {
		JudgeValid judge = new JudgeValid();
		Calculate culresult = new Calculate();
		if (judge.judge(DBE) == 1) {
			output.println("ERROR");
			output.println("#表达式内含非法字符");
		} else if (judge.judge(DBE) == 2) {
			output.println("ERROR");
			output.println("#括号不配对");
		} else if (judge.judge(DBE) == 3) {
			output.println("ERROR");
			output.println("#存在空括号");
		} else if (judge.judge(DBE) == 4) {
			output.println("ERROR");
			output.println("#表达式存在括号接数字");
		} else if (judge.judge(DBE) == 5) {
			output.println("ERROR");
			output.println("#左右括号接数字");
		} else if (judge.judge(DBE) == 6) {
			output.println("ERROR");
			output.println("#左右括号接运算符或)(之间没有运算符");
		} else if (judge.judge(DBE) == 7) {
			output.println("ERROR");
			output.println("#运算符连续");
		} else if (judge.judge(DBE) == 8) {
			output.println("ERROR");
			output.println("#负数表达不规范");
		} else {
			double result = culresult.calResult(post);
			if (String.valueOf(result) == "Infinity") {
				output.println("ERROR");
				output.println("#存在分母为零的");
			} else {
				output.println(DBE + "=" + result);
			}
		}
	}
}
