package calcultor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calcuate {
	private static String str = "";
	private static String str1 = "";
	List<String> list = new ArrayList<>();
	Stack<Character> opeStack = new Stack<>();// 符号栈
	
	public Calcuate() {

	}

	public Calcuate(String newStr) {
		str1 = newStr;
		str = "(" + newStr + ")";
	}

	public String getCal() {
		String numStr = "";// 记录数字
		
		int l = str.length();// 字符串长度 l
		
		for (int i = 0; i < l; i++) {
			char ch = str.charAt(i);
			if (isAllOpe(ch)) {
				if (numStr != "") {
					list.add(numStr);
					numStr = "";
				}
				if (ch == '(') {
					opeStack.push(ch);
				} else if (isOpe(ch)) {
					checkLever(ch);
				} else if (ch == ')') {
					char t = opeStack.pop();
					while (t != '(' && !opeStack.isEmpty()) {
						list.add(Character.toString(t));
						t = opeStack.pop();
					}
				}
			} else {// 处理数字
				numStr += ch;
			}
		}
		int i = changeFormula(list);
		String s = str1 + "=" + i;
		return s;
	}
	
	public void checkLever(char ch){
		char top = opeStack.peek();
		if (isGreater(ch, top)) {// ch优先级大于top 压栈
			opeStack.push(ch);
		} else {// 否则,将栈内元素出栈,直到遇见 '(' 然后将ch压栈
			while (true) {// 必须先判断一下 后出栈 否则会有空栈异常
				char t = opeStack.peek();
				if (t == '(')
					break;
				if (isGreater(ch, t))
					break;
				list.add(Character.toString(t));
				t = opeStack.pop();
			}
			opeStack.push(ch);
		}
	}
	public int changeFormula(List<String> list) {//中缀表达式改后缀并计算
		Stack<Integer> num = new Stack<>();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String t = list.get(i);
			if (isNumber(t)) {// 将t转换成int 方便计算
				num.push(Integer.parseInt(t));
			} else {// 如果t为运算符则 只有一位
				char c = t.charAt(0);
				int b = num.pop();
				// 如果有 算式是类似于 -8-8 这样的需要判断一下栈是否为空
				int a = num.pop();
				switch (c) {
				case '+':
					num.push(a + b);
					break;
				case '-':
					num.push(a - b);
					break;
				case '*':
					num.push(a * b);
					break;
				case '/':
					num.push(a / b);
					break;
				default:
					break;
				}
			}
		}
		Integer i = num.pop();
		return i;
	}

	public static boolean isOpe(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		else
			return false;
	}

	public static boolean isAllOpe(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		else if (c == '(' || c == ')')
			return true;
		else
			return false;
	}

	public static boolean isGreater(char a, char b) {
		int a1 = getLevel(a);
		int b1 = getLevel(b);
		if (a1 > b1)
			return true;
		else
			return false;
	}

	public static int getLevel(char a) {
		if (a == '+')
			return 0;
		else if (a == '-')
			return 1;
		else if (a == '*')
			return 3;
		else if (a == '/')
			return 4;
		else
			return -1;
	}

	// 判断是不是数字
	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

}
