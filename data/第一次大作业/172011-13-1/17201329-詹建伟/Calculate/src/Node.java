
public class Node {
	String expression = "status";// ���ʽ

	Node next;// ��һ���ڵ�

	// ���췽��
	public Node() {

	}

	public Node(String expression) {
		this.expression = expression;
	}

	public Node(String expression, Node next) {
		this.expression = expression;
		this.next = next;
	}
}
