package BigHomeWork1;
// 栈 类
public class StackLine {
	private Node top;// 栈顶
	private Node bottom;// 栈底
	
	public StackLine(){//无参构造
		top = new Node();
		top.setNext(bottom);
		bottom = new Node();
	}
	// 获得 栈顶
	public Node getTop(){
		return top;
	}
	// 获得  头节点的数据
	public String getData(){
		if (top.getNext() != null ){
		    return top.getNext().getData();
		}
		else{
			return null;
		}
	}
	// 入栈操作
	public void push(Node newNode){
		Node n = top.getNext();
		newNode.setNext(n);
		top.setNext(newNode);
	}
	// 出栈操作
	public void pop(){
		if (top.getNext() != null){
			top.setNext(top.getNext().getNext());
		}
	}
}
