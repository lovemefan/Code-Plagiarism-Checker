
//计算操作类
import java.util.*;

public class Orerate {
	private Stack<Double> numStack = new Stack<Double>();// 操作数栈
	private Stack<Character> priStack = new Stack<Character>();// 操作符栈

	public double caculate(String str) { // 计算表达式

		String temp;// 用来临时存放读取的字符
		StringBuffer tempNum = new StringBuffer();// 用来临时存放数字字符串 当数字为多位数时
		StringBuffer string = new StringBuffer().append(str + '=');// 用来保存字符串，设置=为结束符
		double num = 0;//操作数
		
		while (string.length() != 0) {
			temp = string.substring(0, 1); // 截取从x到y前的位置
			string.delete(0, 1);
			// 判断temp，当temp为操作符时
			if (!isNum(temp)) {
				if (!"".equals(tempNum.toString())) {
					num = Double.valueOf(tempNum.toString());//类型转换
					numStack.push(num); 
					tempNum.delete(0, tempNum.length());//清空tempNum
				}
				if (!compare(temp.charAt(0)) && (!priStack.isEmpty())) {//优先级高且操作符栈不为空时
					double a = numStack.pop();// 第二个运算数
					double b = numStack.pop();// 第一个运算数
					char ope = priStack.pop();//两个数之间的运算符
					double result = 0;// 运算结果

					switch (ope) {
					case '+':
						result = b + a;
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						numStack.push(result);
						break;
					case '/':
						if (a == 0) {// 分母为零 返回错误标记
							return 999999999;
						}
						result = b / a;
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
				// 当为非操作符时（数字）
				tempNum = tempNum.append(temp);// 将读到的这一位数接到已读出的数后(多位数情况)

		}
		return numStack.pop();

	}

	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}

	// 比较结果 true代表比栈顶元素优先级高，false代表比栈顶元素优先级低
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
			// '('优先级最高,返回true
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
		// '+-'为最低，返回false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}
}
