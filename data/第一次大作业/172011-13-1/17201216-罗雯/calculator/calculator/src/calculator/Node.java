package calculator;

public class Node {
	private long data;
	private Node next;
	private boolean isNum;
	
	public Node() {
		
	}
	
	public Node(long data) {
		this.data = data;
	}
	
	
	public void setIsNum(boolean temp) {
		isNum = temp;
	}
	
	public boolean getIsNum() {
		return isNum;
	}
	
	public void setNext(Node next) {
		this.next = next; 
	}
	
	public long getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
}
