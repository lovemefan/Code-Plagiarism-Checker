
public class Node {
	// ������
	public String data;

	// ָ����ָ����һ���ڵ�
	public Node next;  //Node �൱�ڽڵ�

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
