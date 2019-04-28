//˳��ջ
public class SeqStack<T> {
	private Object element[];// ��������
	private int top;// ջ��ָ��

	public SeqStack(int size) {// ���캯��������Ϊ������С
		this.element = new Object[Math.abs(size)];
		this.top = -1;// ջ��ָ���ʼ��Ϊ-1
	}

	public SeqStack() {// ���캯��
		this(50);// ջ����Ĭ��Ϊ50
	}

	public boolean isEmpty() {// �ж�ջ�Ƿ�Ϊ��
		return this.top == -1;
	}

	public void push(T x) {// ��ջ����
		if (x == null)// Ϊ�ս���
			return;
		if (this.top == element.length - 1) {
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];// ��������
			for (int i = 0; i < temp.length; i++) {
				this.element[i] = temp[i];
			}
		}
		this.top++;
		this.element[this.top] = x;
	}

	@SuppressWarnings("unchecked")
	public T pop() {// ��ջ����
		return this.top == -1 ? null : (T) this.element[this.top--];// ���ж��Ƿ���Ԫ��
	}

	@SuppressWarnings("unchecked")
	public T get() {// �õ�ջ��Ԫ��
		return this.top == -1 ? null : (T) this.element[this.top];
	}
}
