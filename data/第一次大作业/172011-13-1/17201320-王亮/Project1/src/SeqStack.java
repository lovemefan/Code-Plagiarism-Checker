//顺序栈
public class SeqStack<T> {
	private Object element[];// 容量数组
	private int top;// 栈顶指针

	public SeqStack(int size) {// 构造函数，参数为容量大小
		this.element = new Object[Math.abs(size)];
		this.top = -1;// 栈顶指针初始化为-1
	}

	public SeqStack() {// 构造函数
		this(50);// 栈容量默认为50
	}

	public boolean isEmpty() {// 判断栈是否为空
		return this.top == -1;
	}

	public void push(T x) {// 出栈操作
		if (x == null)// 为空结束
			return;
		if (this.top == element.length - 1) {
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];// 扩大容量
			for (int i = 0; i < temp.length; i++) {
				this.element[i] = temp[i];
			}
		}
		this.top++;
		this.element[this.top] = x;
	}

	@SuppressWarnings("unchecked")
	public T pop() {// 出栈操作
		return this.top == -1 ? null : (T) this.element[this.top--];// 先判断是否有元素
	}

	@SuppressWarnings("unchecked")
	public T get() {// 得到栈顶元素
		return this.top == -1 ? null : (T) this.element[this.top];
	}
}
