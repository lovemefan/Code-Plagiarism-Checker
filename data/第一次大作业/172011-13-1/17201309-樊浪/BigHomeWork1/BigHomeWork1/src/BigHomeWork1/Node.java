package BigHomeWork1;
// 用于栈的节点类
public class Node {
	private String data;//记录数据
	private Node next;	//记录下一节点的地址
	//无参构造，属性为空
	public Node(){
		data = "";
		next = null;
	}
	//传入新节点的信息 ，构造方法
	public Node(String newData) {
		data = newData;
		next = null;
	}
	// 获得 节点的数据
	public String getData() {
		return data;
	}
    // 获得 下一节点的地址
	public Node getNext() {
		return next;
	}
    // 设置节点的数据 
	public void setData(String newData) {
		data = newData;
	}
    // 设置 下一节点的地址
	public void setNext(Node newNext) {
		next = newNext;
	}

}
