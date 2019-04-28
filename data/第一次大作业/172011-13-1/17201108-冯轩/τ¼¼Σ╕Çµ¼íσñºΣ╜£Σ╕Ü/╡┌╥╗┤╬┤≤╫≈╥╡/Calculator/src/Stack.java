
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
		
		//���ݽڵ�
		public Node(String data){
			this.data = data;
		}
	}
	
	//ѹջ
	public void push(String value){
		Node newNode = new Node(value);
		//ջ��ָ������
		newNode.next = this.stackTop;
		this.stackTop = newNode;
		N++;
	}
	
	//����ջ��Ԫ��
	public String pop(){
		Node topNode = this.stackTop;
		if(this.stackTop!= this.stackBottom){
			this.stackTop = topNode.next;
			N--;
			return topNode.data;
			
		}
		else{
			System.out.println("ջΪ��!");
			return "NULL";
		}
	}
	
	//����ջ
	public void traverser(){
		Node stackTop = this.stackTop;
		
		while (stackTop != this.stackBottom){
			System.out.println("��ջԪ��Ϊ: " + stackTop.data);
			stackTop = stackTop.next;
		}
	}
	
	//���ջ
	public void clear(){
		this.stackTop = this.stackBottom;
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.stackTop == this.stackBottom;
	}
	
	//��ȡ��ǰջ�Ĵ�С
	public int size(){
		return this.N;
	}
}
