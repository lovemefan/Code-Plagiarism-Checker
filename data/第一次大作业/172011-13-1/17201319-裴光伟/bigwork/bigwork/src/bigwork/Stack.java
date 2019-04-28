package bigwork;

public class Stack {
	private Node stackTop;// ջ��
	private Node stackBottom;// ջ��

	public Stack(){
		
	}
	
	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.stackBottom = stackBottom;
		this.stackTop = this.stackBottom;
		stackBottom.setNext(null);
	}

	//���ջ��ָ��Ľڵ�
	public Node getStackTop() {
		return stackTop;
	}

	//���ջ��ָ��Ľڵ�
	public Node getStackBottom() {
		return stackBottom;
	}

	// ��ջ�д���char����
	public void printStack(char ch, int top) {
		Node newNode = new Node(ch, top);
		newNode.setNext(stackTop);
		stackTop = newNode;
	}

	// ��ջ�д���double����
	public void printStack(double data) {
		Node newNode = new Node(data);
		newNode.setNext(stackTop);
		stackTop = newNode;
	}

	// ���ջ���������
	public char outTopStack() {
		char c = stackTop.getCh();
		stackTop = stackTop.getNext();
		return c;
	}

	// ���ջ��������
	public double outDoubleStack() {
		double i = stackTop.getdata();
		stackTop = stackTop.getNext();
		return i;
	}
}
