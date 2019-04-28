package bigWork;

public class Stack {
	private String[] elements;
	int size;
	int pp;
	public static final int DEFAULT_CAPACITY = 20;
	public Stack() {
		this(DEFAULT_CAPACITY);
	}
	public Stack(int capacity) {
		elements = new String[capacity];
	}
	public void push(String value) {
		if(size >= elements.length) {
			String[] temp = new String[elements.length *2];
			System.arraycopy(elements,0,temp,0,elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}
	public String pop() {
		return elements[--size];
	}
	public String peek() {
		return elements[size-1];
	}
	public boolean empty() {
		return size ==0;
	}
	public int getSize() {
		return size;
	}
}

