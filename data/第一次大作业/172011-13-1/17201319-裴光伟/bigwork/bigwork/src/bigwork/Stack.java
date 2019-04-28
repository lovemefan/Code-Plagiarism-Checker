package bigwork;

public class Stack {
	private Node stackTop;// 栈顶
	private Node stackBottom;// 栈底

	public Stack(){
		
	}
	
	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.stackBottom = stackBottom;
		this.stackTop = this.stackBottom;
		stackBottom.setNext(null);
	}

	//获得栈顶指向的节点
	public Node getStackTop() {
		return stackTop;
	}

	//获得栈底指向的节点
	public Node getStackBottom() {
		return stackBottom;
	}

	// 向栈中存入char数据
	public void printStack(char ch, int top) {
		Node newNode = new Node(ch, top);
		newNode.setNext(stackTop);
		stackTop = newNode;
	}

	// 向栈中存入double数据
	public void printStack(double data) {
		Node newNode = new Node(data);
		newNode.setNext(stackTop);
		stackTop = newNode;
	}

	// 输出栈顶的运算符
	public char outTopStack() {
		char c = stackTop.getCh();
		stackTop = stackTop.getNext();
		return c;
	}

	// 输出栈顶的数字
	public double outDoubleStack() {
		double i = stackTop.getdata();
		stackTop = stackTop.getNext();
		return i;
	}
}
