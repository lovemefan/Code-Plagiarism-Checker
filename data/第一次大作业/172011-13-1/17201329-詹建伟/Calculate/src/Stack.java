
public class Stack {
	Node stackTop;// ջ��
	Node stackBottom;// ջ��

	// ���췽��
	public Stack(Node stackTop, Node stackBottom) {
		this.stackBottom = stackBottom;
		this.stackTop = stackTop;
	}

	public Stack() {

	}

	// ��ջ
	public void pushStack(Stack stack, String buf) {
		// �����ݷ�װΪ�ڵ�
		Node node = new Node(buf);
		// ��ջ
		node.next = stack.stackTop;
		stack.stackTop = node;
	}

	// ��ջ
	public String outStack(Stack stack) {
		// ���ն�������
		String temp = stack.stackTop.expression;
		// ջ������
		stack.stackTop = stack.stackTop.next;
		return temp;
	}
}
