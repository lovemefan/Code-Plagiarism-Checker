package calculator;

public class Stack {
	
	private Node stackTop = null;
	
	public Stack() {
		
	}
	
	public Stack(Node stackTop) {
		this.stackTop = stackTop;;
	}
	
	public void push(long data) {
		Node newNode = new Node(data);
		
		newNode.setNext(stackTop);
		stackTop = newNode;
	}
	
	public long pop() {
		if (isEmpty()) {
			return 0;
		}
		else {
			long temp = stackTop.getData();
			
			stackTop = stackTop.getNext();
			return temp;
		}
	}
	
	public boolean isEmpty() {
		return stackTop == null;
	}
	
	public long peek() {
		return stackTop.getData();
	}
}
