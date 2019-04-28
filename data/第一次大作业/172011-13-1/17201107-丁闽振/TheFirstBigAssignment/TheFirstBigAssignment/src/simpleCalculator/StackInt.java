package simpleCalculator;

public class StackInt {
	private class Node {// 链栈的节点
		int data;
		Node next;

		public Node() {

		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top;// 栈顶元素
	private int size;// 当前栈的大小

	public StackInt() {
		top = null;
	}
//得到当前栈的大小
	public int length() {
		return size;
	}
//判断栈是否为空
	public boolean empty() {
		return size == 0;
	}
//入栈
	public boolean push(int data) {
		top = new Node(data, top);
		size++;
		return true;
	}
//查看栈顶元素但不删除
	public int peek() {
		if (empty()) {
			throw new RuntimeException("空栈异常！");
		} else {
			return top.data;
		}
	}
//出栈
	public int pop() {
		if (empty()) {
			throw new RuntimeException("空栈异常！");
		} else {
			Node value = top;
			top = top.next;
			value.next = null;
			size--;
			return value.data;
		}
	}

}
