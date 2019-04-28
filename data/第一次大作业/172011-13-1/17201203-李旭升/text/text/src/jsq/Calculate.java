package jsq;
import java.util.*;
public class Calculate {
	private Stack<Character> priStack = new Stack<Character>();// 操作符栈
	private Stack<Integer> numStack = new Stack<Integer>();// 操作数栈

	public int caculate(String str) {
		String temp;// 用来临时存放读取的字符

		StringBuffer tempNum = new StringBuffer();// 用来临时存放数字字符串(当为多位数时)
		StringBuffer string = new StringBuffer().append(str);// 用来保存，提高效率

		while (string.length() != 0) {
			temp = string.substring(0, 1);
			string.delete(0, 1);

			if (!isNum(temp)) {

				if (!"".equals(tempNum.toString())) {
					// 当表达式的第一个符号为括号
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());
				}
				while (!compare(temp.charAt(0)) && (!priStack.empty())) {
					int a = (int) numStack.pop();
					int b = (int) numStack.pop();
					char ope = priStack.pop();
					int result = 0;// 运算结果
					switch (ope) {
					// 如果是加号或者减号，则
					case '+':
						result = b + a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					case '/':
						result = b / a;// 将操作结果放入操作数栈
						numStack.push(result);
						break;
					}

				}
				if (temp.charAt(0) != '=') {
					priStack.push(new Character(temp.charAt(0)));
					if (temp.charAt(0) == ')') {// 当栈顶为'('，而当前元素为')'时，则是括号内以算完，去掉括号
						priStack.pop();
						priStack.pop();
					}
				}
			} else
				tempNum = tempNum.append(temp);// 将读到的这一位数接到以读出的数后(当不是个位数的时候)
		}
		return numStack.pop();
	}

	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}

	private boolean compare(char str) {
		if (priStack.empty()) {
			// 当为空时，显然 当前优先级最低，返回高
			return true;
		}
		char last = (char) priStack.lastElement();
		// 如果栈顶为'('显然，优先级最低，')'不可能为栈顶。
		if (last == '(') {
			return true;
		}
		switch (str) {
		case '=':
			return false;// 结束符
		case '(':
			// '('优先级最高,显然返回true
			return true;
		case ')':
			// ')'优先级最低，
			return false;
		case '*': {
			// '*/'优先级只比'+-'高
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		case '/': {
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		// '+-'为最低，一直返回false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}
}
