// ջ��
public class Stack {
	// ˳��ջ
	private String[] data;
	// ջ��
	private int top;

	// ָ��ջ�Ĵ�СΪ10000
	public Stack() {
		data = new String[10000];
		top = 0;
	}

	// ��ջ
	public void push(String data) {
		this.data[top++] = data;
	}

	// ��ջ
	public String pop() {
		return data[--top];
	}

	// ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == 0;
	}

	// �鿴ջ��Ԫ��
	public String top() {
		return data[top - 1];
	}
}
