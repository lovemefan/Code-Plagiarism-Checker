package BigClasswork;

public class Stack {
	private int maxSize;// ���������±�
	private String[] s;
	private static int top;//ջ��

	// ��ʼ��ջ
	public Stack(int maxSize) {
		s = new String[maxSize];
		top = -1;
	}

	// ��ջ
	public int PushStack(String str) {
		s[++top] = str;
		return top;
	}

	// ��ջ
	public String PopStack() {
		return s[top--];

	}

	// ȡջ��Ԫ��
	public String peek() {
		return s[top];
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == -1;
	}

	// �ж�ջ�Ƿ�����
	public boolean isFull() {
		return top == maxSize - 1;
	}

}
