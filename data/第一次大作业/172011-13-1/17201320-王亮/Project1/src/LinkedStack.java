//链式栈
public class LinkedStack<T> {
	private Node<T> top;// 栈顶

	public LinkedStack() {// 构造函数
		this.top = null;
	}

	public boolean isEmpty() {// 判断栈是否为空
		return this.top == null;
	}

	public void push(T x) {// 入栈函数
		if (x != null)
			this.top = new Node<T>(x, this.top);

	}

	public T pop() {// 出栈函数
		if (this.top == null)
			return null;
		T temp = this.top.date;
		this.top = this.top.next;
		return temp;
	}

	public T get() {// 得到栈顶元素的下标
		return this.top == null ? null : this.top.date;
	}

	
}
