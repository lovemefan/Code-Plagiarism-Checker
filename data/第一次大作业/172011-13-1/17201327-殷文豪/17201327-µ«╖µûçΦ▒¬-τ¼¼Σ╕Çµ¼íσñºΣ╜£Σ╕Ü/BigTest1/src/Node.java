
//节点类
public class Node {
	private char ch;//变后缀表达式时存储单个字符
	private String str;//计算后缀表达式时存储字符串
	Node next;//指向下一个节点
	
	//构造方法
	public Node() {
		
	}
	
	//重载构造方法
	//char
	public Node(char ch) {
		this.ch = ch;
	}
	
	//重载构造方法
	//char,Note
	public Node(char ch,Node next) {
		this.ch = ch;
		this.next = next;
	}
	
	//重载构造方法
	//String,Note
	public Node(String str,Node next) {
		this.str = str;
		this.next = next;
	}
	
	//设置ch
	public void setChar(char ch) {
		this.ch = ch;
	}
	
	//获取ch
	public char getChar() {
		return ch;
	}
	
	//设置str
	public void setStr(String str) {
		this.str = str;
	}
	
	//获取str
	public String getStr() {
		return str;
	}
}
