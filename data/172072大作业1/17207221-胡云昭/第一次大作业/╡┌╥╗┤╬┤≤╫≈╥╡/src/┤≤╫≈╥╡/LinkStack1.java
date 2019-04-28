package 大作业;

import 大作业.LinkStack.Node;

public class LinkStack1 {
	public Node top;// 栈顶节点
	public int num = 0;// 栈内元素的个数
	public Node data;
	

	public class Node {
		public int data;
		public Node next;

		public Node() {
			
		}

		public Node(int data) {
			this.data = data;
			
		}
	}
	public LinkStack1() {
		
	}

	

	// 进栈
	public void push(int dat) {
		Node oldFirst = top;
		top = new Node(dat);
		top.next = oldFirst;
		num++;	
	}
	//得到栈顶元素
	public int getTop() {
		if(!isEmpty())
		return top.data;
		else
	   return 0;
	}

	// 出栈
	public int pop() {
		
		Node oldTop = top;
		top = top.next;

		num--;

		return oldTop.data;
	}

 
	// 判断是否为空栈
	public boolean isEmpty() {
		
			if(	top == null)
				return true;
			else
				return false;
	}

	
	
	
}
