package ����ҵ;

import ����ҵ.LinkStack.Node;

public class LinkStack1 {
	public Node top;// ջ���ڵ�
	public int num = 0;// ջ��Ԫ�صĸ���
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

	

	// ��ջ
	public void push(int dat) {
		Node oldFirst = top;
		top = new Node(dat);
		top.next = oldFirst;
		num++;	
	}
	//�õ�ջ��Ԫ��
	public int getTop() {
		if(!isEmpty())
		return top.data;
		else
	   return 0;
	}

	// ��ջ
	public int pop() {
		
		Node oldTop = top;
		top = top.next;

		num--;

		return oldTop.data;
	}

 
	// �ж��Ƿ�Ϊ��ջ
	public boolean isEmpty() {
		
			if(	top == null)
				return true;
			else
				return false;
	}

	
	
	
}
