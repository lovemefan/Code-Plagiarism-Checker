
public class Stack {
	Node top;// ջ��
	Node down;// ջ��
	// Stack�Ĺ��췽��

	Stack() {
		top = new Node();
		down = new Node();
		top = down;
	}

	// ��ջ
	public void push(String news) {
		Node newNode = new Node(news);
		newNode.next = top;
		top = newNode;
	}

	// ��ջ
	public String pop() {
		String news = top.news;
		top = top.next;
		return news;
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		if (top.news.equals("")) {
			return true;
		} else
			return false;
	}
}
