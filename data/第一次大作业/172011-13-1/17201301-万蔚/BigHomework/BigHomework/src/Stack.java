// 栈类
public class Stack {
	// 顺序栈
	private String[] data;
	// 栈顶
	private int top;

	// 指定栈的大小为10000
	public Stack() {
		data = new String[10000];
		top = 0;
	}

	// 入栈
	public void push(String data) {
		this.data[top++] = data;
	}

	// 出栈
	public String pop() {
		return data[--top];
	}

	// 栈是否为空
	public boolean isEmpty() {
		return top == 0;
	}

	// 查看栈顶元素
	public String top() {
		return data[top - 1];
	}
}
