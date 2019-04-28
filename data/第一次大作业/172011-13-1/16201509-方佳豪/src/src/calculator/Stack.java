package calculator;
import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	List<T> stack;
	public Stack() {
		stack=new ArrayList<>();
	}
	
	public int size() {
		return stack.size();
	}
	
	public boolean push(T val) {
		return stack.add(val);
	}
	
	public T pop() {
		return stack.remove(stack.size()-1);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public T peek() {
		return stack.get(stack.size()-1);
	}
	
	public void clear() {
		stack.clear();
	}
}
