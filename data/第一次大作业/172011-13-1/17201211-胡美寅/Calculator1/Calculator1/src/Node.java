
public class Node {
	// 数据域
	public String data;

	// 指针域，指向下一个节点
	public Node next;  //Node 相当于节点

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
