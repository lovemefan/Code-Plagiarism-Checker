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
	
	private Node top;// 存放栈顶节点
	private int size = 0;// 存放栈中已有的元素个数
 
	// 创建空链栈
	public LinkStack() {
		top = null;
	}
 
	// 已指定数据元素创建链栈，只有一个元素
	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}
 
	// 返回链栈的长度
	public int length() {
		return size;
	}
 
	// 进栈
	public void push(T temp) {
		// 让top指向新节点，新节点的next指向原来的top
		top = new Node(temp, top);
		size++;
	}
 
	// 出栈
	public T pop() {
		// 若当前为空栈，则返回null
		if (size == 0) {
			return null;
		}
 
		Node oldTop = top;
		// 让top指向原栈顶的下一个节点
		top = top.next;
 
		// 释放原栈顶元素的引用
		oldTop.next = null;
		size--;
 
		return oldTop.data;
	}
	
	// 获取栈顶元素
		public T getTop() {
			// 若当前为空栈，则返回null
			if (size == 0) {
				return null;
			}
	 
			return top.data;
		}
	 
		// 判断是否为空
		public boolean isEmpty() {
			return size == 0;
		}
	 
		// 清空栈
		public void clear() {
			top = null;
			size = 0;
		}

	

}
