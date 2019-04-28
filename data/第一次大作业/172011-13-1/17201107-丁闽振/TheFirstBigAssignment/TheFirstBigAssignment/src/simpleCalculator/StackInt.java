package simpleCalculator;

public class StackInt {
	private class Node {// ��ջ�Ľڵ�
		int data;
		Node next;

		public Node() {

		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top;// ջ��Ԫ��
	private int size;// ��ǰջ�Ĵ�С

	public StackInt() {
		top = null;
	}
//�õ���ǰջ�Ĵ�С
	public int length() {
		return size;
	}
//�ж�ջ�Ƿ�Ϊ��
	public boolean empty() {
		return size == 0;
	}
//��ջ
	public boolean push(int data) {
		top = new Node(data, top);
		size++;
		return true;
	}
//�鿴ջ��Ԫ�ص���ɾ��
	public int peek() {
		if (empty()) {
			throw new RuntimeException("��ջ�쳣��");
		} else {
			return top.data;
		}
	}
//��ջ
	public int pop() {
		if (empty()) {
			throw new RuntimeException("��ջ�쳣��");
		} else {
			Node value = top;
			top = top.next;
			value.next = null;
			size--;
			return value.data;
		}
	}

}
