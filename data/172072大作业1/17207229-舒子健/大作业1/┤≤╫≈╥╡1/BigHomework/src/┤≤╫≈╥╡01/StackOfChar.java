package 大作业01;

/*运算符堆栈类*/
public class StackOfChar {
	private char[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//默认容量
	
	public StackOfChar() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfChar(int capacity) {
		elements = new char[capacity];
	}
	/*元素进栈*/
	public void push(char ch) {
		if(size >= elements.length) {//如果栈满
			char[] temp = new char[elements.length * 2];//创建一个容量更大的数组
			System.arraycopy(elements, 0, temp, 0, elements.length);//将当前数组的内容复制到新数组
			elements = temp;//将新数组的应用赋值给栈中当前数组
		}
		elements[size++] = ch;
	} 
	/*元素出栈*/
	public char pop() {
		return elements[--size];
	}
	/*获取栈顶元素，未出栈*/
	public char peek() {
		return elements[size - 1];
	}
	/*判断栈是否为空*/
	public boolean empty() {
		return size == 0;
	}
	/*栈中元素个数*/
	public int getSize() {
		return size;
	}
}
