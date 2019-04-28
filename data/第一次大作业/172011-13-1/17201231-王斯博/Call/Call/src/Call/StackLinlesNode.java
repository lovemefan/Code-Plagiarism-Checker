package Call;

public class StackLinlesNode<O> {
	private String data;// 栈节点里面存放的数据
	private StackLinlesNode<String> next;// 栈后面的地址
	private StackLinlesNode<String> top;// 栈顶
	private int size;// 栈的大小

	// 当前栈的大小
	public int length() {
		return size;
	}

	// 判断栈是否为空
	public boolean empty() {
		return size == 0;
	}

	// 输出节点
	public String getData() {
		return this.data;
	}

	// 建立节点
	public void setData(String data) {
		this.data = data;
		size = 1;
	}

	// 构造方法
	public StackLinlesNode() {
		top = null;
	}

	// 构造方法
	public StackLinlesNode(String data, StackLinlesNode<String> next) {
		this.data = data;
		this.next = next;
	}

	// 进栈
	public boolean push(String e) {
		top = new StackLinlesNode<String>(e, top);
		size = size + 1;
		return true;
	}

	// 栈顶元素出栈
	public boolean pop() {
		if (top.next == null) {
			return false;
		}
		StackLinlesNode<String> p = new StackLinlesNode<String>();
		p = top;
		top = top.next;
		p.next = null;
		size = size - 1;
		return true;
	}

	// 取栈顶元素
	public String getTop() {
		if (top == null) {
			return null;
		}
		return top.getData();
	}
}