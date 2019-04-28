package calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {
	private Check check;
	private FileIO fileIO;
	
	public Process() {
		check = new Check();
		fileIO = new FileIO();
	}
	
	public void calculate() throws IOException {
		ArrayList<String> expressions = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		Queue suffix;
		long ans;
		
		try {
			expressions = fileIO.readFile();
		}
		catch (FileNotFoundException ex) {
			System.out.println("ERROR\n#输入文件\"Expressions.txt\"未找到");
			result.add("ERROR\r\n#输入文件\"Expressions.txt\"未找到");
		}
		
		for (int i = 0; i < expressions.size(); i++) {
			if (!check.checkExps(expressions.get(i), result)) {
				suffix = transform(expressions.get(i));
				try {
					ans = evaluation(suffix);
					System.out.println(expressions.get(i) + "=" + ans);
					result.add(expressions.get(i) + "=" + ans);
				}
				catch (ArithmeticException ex) {
					System.out.println("ERROR\n#表达式内除数为零");
					result.add("ERROR\r\n#表达式内除数为零");
				}
			
			}
		}
		
		fileIO.writeFile(result);
	}
	
	//处理过程，接受一个字符串表达式，返回后缀表达式的队列
	public Queue transform(String exps) {
		Stack symbol = new Stack();
		Queue suffix = new Queue();
		char temp;
		boolean isFirst = true;
			
		for (int i = 0; i < exps.length(); i++) {
			temp = exps.charAt(i);
			if (isFirst && symbolValue(temp) == 1) {
				i++;
				i = toNum(exps, i, suffix, temp);
				isFirst = false;
			}
			else if (symbolValue(temp) == 0) {
				i = toNum(exps, i, suffix, '+');
				isFirst = false;
			}
			else if (symbolValue(temp) > 0) {
				while (!symbol.isEmpty() && symbolValue((char)(symbol.peek())) >= symbolValue(temp)
						&& (char)(symbol.peek()) != '(') {
					suffix.push((char)(symbol.pop()));
				}
				if (temp == '(') {
					isFirst = true;
				}
				if (temp == ')') {
					while ((char)(symbol.peek()) != '(') {
						suffix.push((char)(symbol.pop()));
					}
					symbol.pop();
				}
				else {
					symbol.push(temp);
				}

			}
			
		}
		while (!symbol.isEmpty()) {
			suffix.push((char)(symbol.pop()));
		}
			
		return suffix;
	}
	
	public int toNum(String exps, int i, Queue suffix, char sign) {
		long num = 0;
		while (i < exps.length() && symbolValue(exps.charAt(i)) == 0) {
			num *= 10;
			num += exps.charAt(i) - '0';
			i++;
		}
		if (sign == '-') {
			num *= -1;
		}
		suffix.push(num);
		i--;
		
		return i;
	}
	
	// 接受一个后缀表达式的队列，计算相应结果
	public long evaluation(Queue suffix) {
		Stack nums = new Stack();
		long temp = 0;
		long first, second;

		while (!suffix.isEmpty()) {
			if (suffix.isNum()) {
				nums.push(suffix.pop());
				//System.out.print(nums.peek() + " ");
			} 
			else {
				char symbol = (char) (suffix.pop());
				//System.out.print(symbol + " ");
				switch (symbol) {
				case '+':
					temp = nums.pop() + nums.pop();
					break;
				case '-':
					first = nums.pop();
					second = nums.pop();
					temp = second - first;
					break;
				case '*':
					temp = nums.pop() * nums.pop();
					break;
				case '/':
					first = nums.pop();
					second = nums.pop();
					temp = second / first;
					break;
				}
				nums.push(temp);
			}

		}

		return nums.pop();
	}
	
	//判断是否是运算符并返回运算符优先级
	public int symbolValue(char arg) {
		if (Character.isDigit(arg)) {
			return 0;
		}
		if (arg == '+' || arg == '-') {
			return 1;
		}
		else if (arg == '/' || arg == '*') {
			return 2;
		}
		else if (arg == '(' || arg == ')') {
			return 3;
		}
		return -1;
	}
	
}
