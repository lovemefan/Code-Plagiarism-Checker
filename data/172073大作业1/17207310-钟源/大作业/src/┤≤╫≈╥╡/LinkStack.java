package ����ҵ;

public class LinkStack {

	public Node top;// ջ���ڵ�
	public int num = 0;// ջ��Ԫ�صĸ���
	public Node data;//Ԫ������

	public class Node {
		public String data;
		public Node next;

		public Node() {
			top.data = null;
		}

		public Node(String data) {
			this.data = data;

		}
	}
    
	//������ջ
	public LinkStack() {
		top = null;
	}

	// ��ջ
	public void push(String dat) {
		Node oldFirst = top;
		top = new Node(dat);
		top.next = oldFirst;
		num++;
	}

	// �õ�ջ��Ԫ��
	public String getTop() {
		if (!isEmpty())
			return top.data;
		else
			return null;
	}

	// ��ջ
	public String pop() {

		Node oldTop = top;
		top = top.next;

		num--;

		return oldTop.data;
	}

	// �ж��Ƿ�Ϊ��ջ
	public boolean isEmpty() {

		if (top == null)
			return true;
		else
			return false;
	}

}
