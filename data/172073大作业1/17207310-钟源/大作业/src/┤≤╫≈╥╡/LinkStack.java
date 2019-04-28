package 大作业;

public class LinkStack {

	public Node top;// 栈顶节点
	public int num = 0;// 栈内元素的个数
	public Node data;//元素内容

	public class Node {
		public String data;
		public Node next;

		public Node() {
			top.data = null;
		}

		public Node(String data) {
			this.data = data;

		}
	}
    
	//创建空栈
	public LinkStack() {
		top = null;
	}

	// 进栈
	public void push(String dat) {
		Node oldFirst = top;
		top = new Node(dat);
		top.next = oldFirst;
		num++;
	}

	// 得到栈顶元素
	public String getTop() {
		if (!isEmpty())
			return top.data;
		else
			return null;
	}

	// 出栈
	public String pop() {

		Node oldTop = top;
		top = top.next;

		num--;

		return oldTop.data;
	}

	// 判断是否为空栈
	public boolean isEmpty() {

		if (top == null)
			return true;
		else
			return false;
	}

}
