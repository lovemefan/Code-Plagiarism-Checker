
public class Stack {
	Node stackTop;// 栈顶
	Node stackBottom;// 栈底

	// 构造方法
	public Stack(Node stackTop, Node stackBottom) {
		this.stackBottom = stackBottom;
		this.stackTop = stackTop;
	}

	public Stack() {

	}

	// 入栈
	public void pushStack(Stack stack, String buf) {
		// 将数据封装为节点
		Node node = new Node(buf);
		// 入栈
		node.next = stack.stackTop;
		stack.stackTop = node;
	}

	// 出栈
	public String outStack(Stack stack) {
		// 接收顶端数据
		String temp = stack.stackTop.expression;
		// 栈顶下移
		stack.stackTop = stack.stackTop.next;
		return temp;
	}
}
