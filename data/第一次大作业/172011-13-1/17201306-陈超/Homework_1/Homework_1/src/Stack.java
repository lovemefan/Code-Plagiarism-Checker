
public class Stack {

	private int top; // 栈顶
	private int bottom; // 栈底
	private double array[]; // 栈的载体--数组
	private String RPN; // RPN后缀表达式

	// 后缀表达式访问器
	public String getRPN() {
		return this.RPN;
	}

	// 栈顶元素访问器
	public int getTop() {
		return this.top;
	}

	// 栈顶元素修改器
	public void setTop(int top) {
		this.top = top;
	}

	// 栈底元素访问器
	public int getBottom() {
		return this.bottom;
	}

	// 栈底元素修改器
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	// 栈的构造方法
	public Stack() {
		// 初始化,构建一个空栈,给栈申请空间
		this.array = new double[9999];
		this.top = this.bottom = 0;
		this.RPN = "";
	}
	// 后缀表达式
	public String RPN(String expression) {
		Stack stack = new Stack();
		for (int i = 0; i < expression.length(); i++) {
			// 左括号直接进栈
			if (expression.charAt(i) == '(') {
				push(stack, expression.charAt(i));
			}
			// 数字直接赋值给后缀表达式
			else if (isNumber(expression.charAt(i))) {
				RPN += expression.charAt(i);
			}
			// 加减进栈前，栈顶运算符弹栈
			else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				RPN = popSymbol(stack, RPN);
				push(stack, expression.charAt(i));
			}
			// 乘除进栈前，栈顶乘除弹栈
			else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				RPN = popMulDev(stack, RPN);
				RPN += ' ';
				push(stack, expression.charAt(i));
			}
			// 碰到右括号弹栈至碰到最近的左括号
			else if (expression.charAt(i) == ')') {
				RPN = popSymbol(stack, RPN);
				// 弹掉左括号
				pop(stack);
			}
		}
		// 输出栈中所余的符号
		RPN = popAll(stack, RPN);
		return RPN;
	}// 说明:数字用空格分开以便calculateResult计算

	// 弹出乘除符号
	public String popMulDev(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/') {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// 弹出运算符
	public String popSymbol(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.array[stack.top] != '(' && stack.top != 0) {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// 弹出所有剩下符号
	public String popAll(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.top != -1) {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// 计算后缀表达式
	public double calculateResult(String RPN) {
		// result:计算的结果
		double result = 0;
		// str1:记住数字
		String str1 = "";
		Stack stack = new Stack();
		// 遍历后缀表达式，找出数字
		for (int i = 0; i < RPN.length(); i++) {
			if (isNumber(RPN.charAt(i))) {
				str1 += RPN.charAt(i);
			}
			// 数字进栈
			else if (RPN.charAt(i) == ' ' && str1 != "") {
				double number = Double.parseDouble(str1);
				str1 = "";
				push(stack, number);
			}
			// 遇到'+'做加法,结果入栈
			else if (RPN.charAt(i) == '+') {
				result = pop(stack) + pop(stack);
				push(stack, result);
			}
			// 遇到'-'做减法,结果入栈
			else if (RPN.charAt(i) == '-') {
				double num1 = pop(stack);
				double num2 = pop(stack);
				result = num2 - num1;
				push(stack, result);
			}
			// 遇到'*'做乘法,结果入栈
			else if (RPN.charAt(i) == '*') {
				result = pop(stack) * pop(stack);
				push(stack, result);
			}
			// 遇到'/'做除法,结果入栈
			else if (RPN.charAt(i) == '/') {
				double num1 = pop(stack);
				double num2 = pop(stack);
				result = num2 / num1;
				push(stack, result);
			}
		}
		// 返回计算结果
		return result;
	}

	// 进栈 中缀转后缀
	public void push(Stack stack, char ch) {
		if (stack.top == stack.array.length) {
			System.out.println("stack is full");
			System.exit(0);
		}
		stack.top++;
		stack.array[stack.top] = ch;
	}

	// 重载一个存double型的栈 后缀算结果
	public void push(Stack stack, double number) {
		if (stack.top == stack.array.length) {
			System.out.println("stack is full");
			System.exit(0);
		}
		stack.top++;
		stack.array[stack.top] = number;
	}

	// 弹栈
	public double pop(Stack stack) {
		// e:记住栈顶元素
		double e;
		if (stack.top == -1) {
			System.out.println("stack is empty");
			System.exit(0);
		}
		e = stack.array[stack.top];
		stack.top--; // 栈顶减一
		return e;
	}

	// 检查字符是否属于数字范围
	public boolean isNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
}
