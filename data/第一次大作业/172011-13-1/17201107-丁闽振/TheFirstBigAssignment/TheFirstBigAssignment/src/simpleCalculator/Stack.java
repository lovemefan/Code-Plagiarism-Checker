package simpleCalculator;

public class Stack {
	private class Node {// ��ջ�Ľڵ�
		String data;
		Node next;

		public Node() {

		}

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top;// ջ��Ԫ��
	private int size;// ��ǰջ�Ĵ�С

	public Stack() {
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
	public boolean push(String data) {
		top = new Node(data, top);
		size++;
		return true;
	}
//�鿴ջ��Ԫ�ص���ɾ��
	public String peek() {
		if (empty()) {
			throw new RuntimeException("��ջ�쳣��");
		} else {
			return top.data;
		}
	}
//��ջ
	public String pop() {
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
