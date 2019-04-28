package calExpression;

import java.util.Arrays;

//����˳��ջ
class ArrStack {
	// �������鱣��Ԫ��
	private Object[] elementData;
	// ����ջ�ĵ�ǰ����
	private int size;
	// ����ջ�ĵ�ǰ����
	private int capacity;
	// ����ջ��
	public int top;

	// ��ʼ��,Ĭ�Ͻ���һ������Ϊ50������
	public ArrStack() {
		elementData = new Object[50];
		capacity = 50;
	}

	// ��ʼ��,�Զ�����������
	public ArrStack(int n) {
		elementData = new Object[n];
		capacity = n;
	}

	// ��ջ
	public <T> void stackPush(T data) {
		// �����������,���½�һ��������������
		if (size >= capacity) {
			int newLength = (capacity * 3 / 2) + 1;
			elementData = Arrays.copyOf(elementData, newLength);
			capacity = newLength;
		}
		elementData[top] = data;
		top++;
		size++;
	}

	// ��ջ
	public <T> T stackPop() {
		if (size == 0) {
			return null;
		} else {
			T data = (T) this.elementData[top - 1];
			top--;
			size--;
			return data;
		}

	}// ����ջ

	public void listStack() {
		if (size == 0) {
		} else if (size == 1) {
			System.out.println("="+elementData[top - 1]);
			// System.out.println("ջ�ĳ���" + size);
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(elementData[i] + " ");
			}
			System.out.println("ջ�ĳ���" + size);
		}
	}

	// ���ص�ǰ����
	public void capacity() {
		System.out.println("��ǰ�������" + capacity);

	}

	// ���ص�ǰջ����ֵ
	public <T> T getTop() {
		T data = (T) elementData[top - 1];
		return data;
	}

	// �п�
	public boolean isEmpty() {
		return size == 0;
	}
}