
public class Stack {
	Node top;// 栈顶
	Node down;// 栈底
	// Stack的构造方法

	Stack() {
		top = new Node();
		down = new Node();
		top = down;
	}

	// 进栈
	public void push(String news) {
		Node newNode = new Node(news);
		newNode.next = top;
		top = newNode;
	}

	// 出栈
	public String pop() {
		String news = top.news;
		top = top.next;
		return news;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		if (top.news.equals("")) {
			return true;
		} else
			return false;
	}
}
