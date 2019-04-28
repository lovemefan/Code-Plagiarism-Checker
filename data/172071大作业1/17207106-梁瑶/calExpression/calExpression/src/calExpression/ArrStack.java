package calExpression;

import java.util.Arrays;

//创建顺序栈
class ArrStack {
	// 定义数组保存元素
	private Object[] elementData;
	// 定义栈的当前长度
	private int size;
	// 定义栈的当前容量
	private int capacity;
	// 定义栈顶
	public int top;

	// 初始化,默认建立一个容量为50的数组
	public ArrStack() {
		elementData = new Object[50];
		capacity = 50;
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
			return null;
		} else {
			T data = (T) this.elementData[top - 1];
			top--;
			size--;
			return data;
		}

	}// 遍历栈

	public void listStack() {
		if (size == 0) {
		} else if (size == 1) {
			System.out.println("="+elementData[top - 1]);
			// System.out.println("栈的长度" + size);
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(elementData[i] + " ");
			}
			System.out.println("栈的长度" + size);
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
}