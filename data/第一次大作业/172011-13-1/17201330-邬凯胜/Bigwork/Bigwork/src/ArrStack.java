
import java.util.Arrays;

public class ArrStack {
	// �������鱣��Ԫ��
	private Object[] elementData;
	// ����ջ�ĵ�ǰ����
	private int size;
	// ����ջ�ĵ�ǰ����
	private int capacity;
	// ����ջ��
	public int top;

	public ArrStack() {
		elementData = new Object[100];
		capacity = 100;
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
			System.out.println("��ǰΪ��ջ");
			return null;
		} else {
			T data = (T) this.elementData[top - 1];
			top--;
			size--;
			return data;
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

	// �ж��ַ��Ƿ�Ϊ����
	public static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

}
