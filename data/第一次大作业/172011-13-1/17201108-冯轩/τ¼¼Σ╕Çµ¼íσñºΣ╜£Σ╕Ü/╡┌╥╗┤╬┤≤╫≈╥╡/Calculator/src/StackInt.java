
public class StackInt {
	
	private Node stackTop;
	private Node stackBottom;
	private int N = 0;
	public StackInt(){
		this.stackBottom = this.stackTop = new Node();
		this.stackTop.next = null;
	}
	
	
	private class Node {
		public int data;
		public Node next;
		
		public Node(){
			
		}
		
		public Node(int data){
			this.data = data;
		}
	}
	
	
	public void push(int value){
		Node newNode = new Node(value);
		//栈顶指针上移
		newNode.next = this.stackTop;
		this.stackTop = newNode;
		N++;
	}
	
	public int pop(){
		Node topNode = this.stackTop;
		if(this.stackTop!= this.stackBottom){
			this.stackTop = topNode.next;
			N--;
			return topNode.data;
		}
		else{
			System.out.println("栈为空!");
			return -1;
		}
	}
	public void traverser(){
		Node stackTop = this.stackTop;
		
		while (stackTop != this.stackBottom){
			System.out.println("出栈元素为: " + stackTop.data);
			stackTop = stackTop.next;
		}
	}
	
	public void clear(){
		this.stackTop = this.stackBottom;
	}
	
	public boolean isEmpty(){
		return this.stackTop == this.stackBottom;
	}
	
	public int size(){
		return this.N;
	}
}
