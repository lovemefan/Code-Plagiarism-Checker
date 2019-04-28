
public class Stack {
	private Node stackTop;
	private Node stackBottom;
	private int N = 0;
	public Stack(){
		this.stackBottom = this.stackTop = new Node();
		this.stackTop.next = null;
	}
	
	
	private class Node {
		public String data;
		public Node next;
		
		public Node(){
			
		}
		
		//数据节点
		public Node(String data){
			this.data = data;
		}
	}
	
	//压栈
	public void push(String value){
		Node newNode = new Node(value);
		//栈顶指针上移
		newNode.next = this.stackTop;
		this.stackTop = newNode;
		N++;
	}
	
	//弹出栈顶元素
	public String pop(){
		Node topNode = this.stackTop;
		if(this.stackTop!= this.stackBottom){
			this.stackTop = topNode.next;
			N--;
			return topNode.data;
			
		}
		else{
			System.out.println("栈为空!");
			return "NULL";
		}
	}
	
	//遍历栈
	public void traverser(){
		Node stackTop = this.stackTop;
		
		while (stackTop != this.stackBottom){
			System.out.println("出栈元素为: " + stackTop.data);
			stackTop = stackTop.next;
		}
	}
	
	//清空栈
	public void clear(){
		this.stackTop = this.stackBottom;
	}
	
	//判断栈是否为空
	public boolean isEmpty(){
		return this.stackTop == this.stackBottom;
	}
	
	//获取当前栈的大小
	public int size(){
		return this.N;
	}
}
