package calculators;

public class LinkStack<T> {

	private class Node{
		private T data;
		private Node next;
		
		public Node(){
			
		}
		
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
		
		private Node top;
		private int size=0;
		
	} 
	
	private Node top;// ���ջ���ڵ�
	private int size = 0;// ���ջ�����е�Ԫ�ظ���
 
	// ��������ջ
	public LinkStack() {
		top = null;
	}
 
	// ��ָ������Ԫ�ش�����ջ��ֻ��һ��Ԫ��
	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}
 
	// ������ջ�ĳ���
	public int length() {
		return size;
	}
 
	// ��ջ
	public void push(T temp) {
		// ��topָ���½ڵ㣬�½ڵ��nextָ��ԭ����top
		top = new Node(temp, top);
		size++;
	}
 
	// ��ջ
	public T pop() {
		// ����ǰΪ��ջ���򷵻�null
		if (size == 0) {
			return null;
		}
 
		Node oldTop = top;
		// ��topָ��ԭջ������һ���ڵ�
		top = top.next;
 
		// �ͷ�ԭջ��Ԫ�ص�����
		oldTop.next = null;
		size--;
 
		return oldTop.data;
	}
	
	// ��ȡջ��Ԫ��
		public T getTop() {
			// ����ǰΪ��ջ���򷵻�null
			if (size == 0) {
				return null;
			}
	 
			return top.data;
		}
	 
		// �ж��Ƿ�Ϊ��
		public boolean isEmpty() {
			return size == 0;
		}
	 
		// ���ջ
		public void clear() {
			top = null;
			size = 0;
		}

	

}
