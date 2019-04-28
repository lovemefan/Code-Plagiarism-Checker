package BigClasswork;

public class Stack {
	private int maxSize;// 数组的最大下标
	private String[] s;
	private static int top;//栈顶

	// 初始化栈
	public Stack(int maxSize) {
		s = new String[maxSize];
		top = -1;
	}

	// 进栈
	public int PushStack(String str) {
		s[++top] = str;
		return top;
	}

	// 出栈
	public String PopStack() {
		return s[top--];

	}

	// 取栈顶元素
	public String peek() {
		return s[top];
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return top == -1;
	}

	// 判断栈是否已满
	public boolean isFull() {
		return top == maxSize - 1;
	}

}
