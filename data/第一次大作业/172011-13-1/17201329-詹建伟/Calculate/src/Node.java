
public class Node {
	String expression = "status";// 表达式

	Node next;// 下一个节点

	// 构造方法
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
