import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class operation {

	public char[] op = { '+', '-', '*', '/', '(', ')' };
	public String[] strOp = { "+", "-", "*", "/", "(", ")" };
	//判断是否为数字
	public boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
	//判断是否为运算符
	public boolean isOp(char c) {
		for (int i = 0; i < op.length; i++) {
			if (op[i] == c) {
				return true;
			}
		}
		return false;
	}
	//方法重载，判断是否为运算符
	public boolean isOp(String s) {
		for (int i = 0; i < strOp.length; i++) {
			if (strOp[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	//处理输入的计算式
	public List<String> work(String str) {//若数字不止为一个数字 ，合并为一串数字，例如10，原本为1和0两个字符串合并为10一个字符串
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (isDigit(c)) {
				sb.append(c);

			}
			if (isOp(c)) {
				if (sb.toString().length() > 0) {
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c + "");
			}
		}
		if (sb.toString().length() > 0) {
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
	}
	//将中缀表达式转换为后缀表达式
	public List<String> InfixToPostfix(List<String> list1) {    //遇到高优先级的全部出栈  最后全部出栈
		List<String> list = new ArrayList<String>();// 存放后缀表达式
		Stack<String> stack = new Stack<String>();// 暂存操作符
		for (int i = 0; i < list1.size(); i++) {
			String s = list1.get(i);//依次读取每个字符
			if (s.equals("(")) {  
				stack.push(s);
			} else if (s.equals("*") || s.equals("/")) {
				stack.push(s);
			} else if (s.equals("+") || s.equals("-")) {
				if (!stack.empty()) {
					while (!(stack.peek().equals("("))) {//将左右括号消除并将里面的运算符按顺序存入后缀表达式的栈中
						list.add(stack.pop());
						if (stack.empty()) {
							break;
						}
					}
					stack.push(s);
				} else {
					stack.push(s);
				}
			} else if (s.equals(")")) {
				while (!(stack.peek().equals("("))) {
					list.add(stack.pop());
				}
				stack.pop();
			} else {
				list.add(s);
			}
			if (i == list1.size() - 1) {
				while (!stack.empty()) {
					list.add(stack.pop());
				}
			}
		}
		return list;
	}

	// 后缀表达式计算
	public Double doCal(List<String> list) {
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			double t = 0;
			if (!isOp(s)) {
				t = Double.parseDouble(s);//遇到数字直接将数字字符转换为整形数字，直接进栈
				stack.push(t);
			} else {
				if (s.equals("+")) {//每一次运算后的数字与后面的运算符以及下个数字再次运算
					double a1 = stack.pop();
					double a2 = stack.pop();
				    double v = a2 + a1;
					stack.push(v);
				} else if (s.equals("-")) {
					double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 - a1;
					stack.push(v);
				} else if (s.equals("*")) {
					double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 * a1;
					stack.push(v);
				} else if (s.equals("/")) {
				    double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 / a1;
					stack.push(v);
				}
			}
		}
		return stack.pop();
	}
}


