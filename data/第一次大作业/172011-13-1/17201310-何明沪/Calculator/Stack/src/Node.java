public class Node {
	private String data;//记录数据
	private Node next;	//记录下一节点的地址

	public Node(){//此构造将信息初始化为空
		setData("");
		next = null;
	}
	
	public Node(String data) {//此构造传入新节点的信息
		setData(data);
		next = null;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
