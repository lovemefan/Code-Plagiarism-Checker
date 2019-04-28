
public class LinkStack {// 链式栈类（实现队列的功能和栈的功能）
	private Node head;//创建头节点
	private Node tail;//创建尾节点
	
	public LinkStack() {//初始化链表的头节点
		head = new Node();
		tail = getHead();
	}

	//添加新节点至尾部
	public void addNode(Node node) {
		tail.setNext(node);
		tail = node;
	}

	//打印链表
	public void printList() {
		//创建一个标记指向第一个节点
		Node tmp = getHead().getNext();
		
		//当遍历完后结束
		while (tmp != null) {
			System.out.print(tmp.getData() + " ");
			tmp = tmp.getNext();//指向下一个节点
		}
		System.out.println("");
	}

	
	public void push(Node node) {//入栈
		Node tmp = getHead().getNext();//标记栈顶
		node.setNext(tmp);//新节点连接栈顶
		getHead().setNext(node);//头节点连接新节点
	}

	public Node pop() {//出栈
		Node tmp = getHead().getNext();//标记栈顶
		if (tmp != null)//如果栈顶不为空则出栈
			getHead().setNext(tmp.getNext());
		tmp.setNext(null);;// 节点下一地址为空
		
		return tmp;// 栈顶元素
	}
	
	public String top(){// 返回一个栈顶元素
		if(isEmpty()){
			return null;
		}
		
		return head.getNext().getData();
	}

	public boolean isEmpty() {//链表为空则true，否则false
		return head.getNext() == null;
	}

	public Node getHead() {// 返回头节点
		return head;
	}

}
