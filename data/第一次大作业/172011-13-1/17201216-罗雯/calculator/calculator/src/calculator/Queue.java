package calculator;

public class Queue {
	private Node head;
	private Node tail;
	
	public Queue() {
		head = new Node();
		tail = head;
	}
	
	
	public void push(long data) {
		Node newNode = new Node(data);
		
		newNode.setIsNum(true);
		tail.setNext(newNode);
		tail = newNode;
	}
	
	public void push(char data) {
		Node newNode = new Node(data);
		
		newNode.setIsNum(false);
		tail.setNext(newNode);
		tail = newNode;
	}
	
	public long pop() {
		Node temp;
		
		temp = head.getNext();
		head.setNext(temp.getNext());
		
		return temp.getData();
	}
	
	//返回队列头部元素是否是整形数字
	public boolean isNum() {
		Node temp;
		
		temp = head.getNext();
		return temp.getIsNum();
	}
	
	
	public boolean isEmpty() {
		return head.getNext() == null;
	}
	
	
}
