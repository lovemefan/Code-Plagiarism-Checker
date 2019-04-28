
//栈类
public class Stack {
	private Node first = null;//栈顶
	
	//构造方法
	public Stack() {
		
	}
	
	//重载构造方法
	//Node
	public Stack(Node first) {
		this.first = first;
	}
	
	//设置栈顶
	public void setFirst(Node first) {
		this.first = first;
	}
		
	//获取栈顶
	public Node getFirst() {
		return first;
	}
}
