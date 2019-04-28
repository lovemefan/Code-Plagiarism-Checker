package simpleCalculator;

public class Transform {
	private String post = "";//用来存储表达式和计算结果
	private Stack stack;
	private String infix;
//构造函数
	public Transform(Stack stack, String infix) {
		this.stack = stack;
		this.infix = infix;
	}
//向表达式里的每个字符后添加一个空格
	private String addspace(String infix) {
		String result = "";
		for (int i = 0; i < infix.length() - 1; i++) {
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += infix.charAt(infix.length() - 1);
		return result;
	}
//判断字符是不是数字
	private boolean isDigital(char ch) {
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}
//将中缀表达式转换成后缀表达式
	public void process() {
		String[] str1 = addspace(infix).split(" ");
		for (int i = 0; i < str1.length; i++) {
			String str2 = str1[i];
			switch (str2) {
			case "+":
			case "-":
				Operation1(str2, 1);
				break;
			case "*":
			case "/":
				Operation1(str2, 2);
				break;
			case "(":
				stack.push(str2);
				break;
			case ")":
				Operation2();
				break;
			default:
				post += " " + str2;
				break;
			}
		}
		while (!stack.empty()) {
			post += " " + stack.pop();
		}
	}
//用来存储+-*/
	private void Operation1(String str, int operation) {
		while (!stack.empty()) {
			String top1 = stack.pop();
			if (top1.equals("(")) {
				stack.push(top1);
				break;
			} else {
				int top2 = getPriority(top1);
				if (top2 < operation) {
					stack.push(top1);
					break;
				} else {
					post += " " + top1;
				}
			}
		}
		stack.push(str);
	}
//用来存储()
	private void Operation2() {
		while (!stack.empty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}
//用来区分+-与*/运算
	private int getPriority(String str) {
		int temp = 0;
		if (str.equals("+") || str.equals("-")) {
			temp = 1;
		} else {
			temp = 2;
		}
		return temp;
	}
//返回后缀表达式
	public String getPost() {
		return post.trim();
	}
}
