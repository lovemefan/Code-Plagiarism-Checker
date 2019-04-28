package bighomework;

//节点类
public class Node {

	public String data;// 数据域
	public Node next;// 指针域，指向下一个节点

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
