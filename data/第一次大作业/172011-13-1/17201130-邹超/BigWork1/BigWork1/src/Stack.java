
public class Stack {
	private int Size;
	private int high;
	private String[] stack;

	public Stack(int Size) {
		stack = new String[Size];
		high = -1;
	}

	public void push(String num) {
		stack[++high] = num;
	}

	public String pop() {
		return stack[high--];
	}

	public boolean isFull() {
		return high == Size - 1;
	}

	public boolean isEmpty() {
		return high == -1;
	}

}
