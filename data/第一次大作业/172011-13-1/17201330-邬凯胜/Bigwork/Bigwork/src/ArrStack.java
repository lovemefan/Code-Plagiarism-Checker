
import java.util.Arrays;

public class ArrStack {
	// 定义数组保存元素
	private Object[] elementData;
	// 定义栈的当前长度
	private int size;
	// 定义栈的当前容量
	private int capacity;
	// 定义栈顶
	public int top;

	public ArrStack() {
		elementData = new Object[100];
		capacity = 100;
	}

	// 初始化,自定义容量数组
	public ArrStack(int n) {
		elementData = new Object[n];
		capacity = n;
	}

	// 入栈
	public <T> void stackPush(T data) {
		// 如果容量满了,则新建一个数组扩充容量
		if (size >= capacity) {
			int newLength = (capacity * 3 / 2) + 1;
			elementData = Arrays.copyOf(elementData, newLength);
			capacity = newLength;
		}
		elementData[top] = data;
		top++;
		size++;
	}

	// 出栈
	public <T> T stackPop() {
		if (size == 0) {
			System.out.println("当前为空栈");
			return null;
		} else {
			T data = (T) this.elementData[top - 1];
			top--;
			size--;
			return data;
		}

	}

	// 返回当前容量
	public void capacity() {
		System.out.println("当前最大容量" + capacity);

	}

	// 返回当前栈顶的值
	public <T> T getTop() { 
	T data = (T) elementData[top - 1];
		return data;
	}

	// 判空
	public boolean isEmpty() {
		return size == 0;
	}

	// 判断字符是否为数字
	public static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

}
