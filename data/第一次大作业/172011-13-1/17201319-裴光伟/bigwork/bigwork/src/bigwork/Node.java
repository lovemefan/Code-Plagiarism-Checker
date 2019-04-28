package bigwork;

public class Node {
	private double data = 0;// 计算后缀表达式存入的数字
	private int topData = 0;// 四则运算符的优先顺序
	private Node next;// 指向下一个节点
	private char ch;// 转换后缀表达式存入的四则运算符

	public Node() {
		
	}

	// 计算后缀表达式存入的数据
	public Node(double data) {
		this.data = data;
	}

	// 转换后缀表达式存入的四则运算符和优先顺序
	public Node(char ch, int topdata) {
		this.ch = ch;
		this.topData = topdata;
	}

	//获取data
	public double getdata() {
		return data;
	}

	//获取topdata
	public double gettopData() {
		return topData;
	}

	//获取节点
	public Node getNext() {
		return next;
	}

	//获取字符
	public char getCh() {
		return ch;
	}

	//设置节点
	public void setNext(Node next) {
		this.next = next;
	}
}
