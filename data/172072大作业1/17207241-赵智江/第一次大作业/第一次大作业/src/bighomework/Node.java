package bighomework;

//�ڵ���
public class Node {

	public String data;// ������
	public Node next;// ָ����ָ����һ���ڵ�

	public Node() {

	}

	public Node(String data) {
		this.data = data;

	}

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
}
