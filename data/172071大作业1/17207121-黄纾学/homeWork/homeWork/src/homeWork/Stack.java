package homeWork;

public class Stack {

	int top;

	String stack[];

	// 构造方法

	public Stack() {

	}

	// 构造方法

	public Stack(int num) {

		top = -1;

		stack = new String[num];

	}

	// 出栈 返回char类型

	public char pop() {

		char c = stack[top].charAt(0);

		top--;

		return c;

	}

	// 出栈 返回String类型

	public String pop2() {

		top--;

		return stack[top + 1];

	}

	// 入栈

	// 压入char类型数据

	public void push(char x) {

		top++;

		stack[top] = "" + x;

	}

	// 入栈

	// 压入String类型数据

	public void push(String x) {

		top++;

		stack[top] = x;

	}

	// 入栈

	// 压入float类型数据

	public void push(double x) {

		top++;

		stack[top] = "" + x;

	}

	// 判空

	public Boolean isempty() {

		if (top == -1)

			return true;

		else

			return false;

	}

	// 栈大小

	public int size() {

		return top + 1;

	}

}