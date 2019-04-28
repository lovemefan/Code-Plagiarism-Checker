//��ʽջ
public class LinkedStack<T> {
	private Node<T> top;// ջ��

	public LinkedStack() {// ���캯��
		this.top = null;
	}

	public boolean isEmpty() {// �ж�ջ�Ƿ�Ϊ��
		return this.top == null;
	}

	public void push(T x) {// ��ջ����
		if (x != null)
			this.top = new Node<T>(x, this.top);

	}

	public T pop() {// ��ջ����
		if (this.top == null)
			return null;
		T temp = this.top.date;
		this.top = this.top.next;
		return temp;
	}

	public T get() {// �õ�ջ��Ԫ�ص��±�
		return this.top == null ? null : this.top.date;
	}

	
}
