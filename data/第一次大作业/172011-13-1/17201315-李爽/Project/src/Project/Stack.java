package Project;

import java.util.EmptyStackException;

public class Stack {
	private String[] contents;  //操作符栈内元素
	private int top;  //top标记下一个入栈的位置，同时也表示栈的容量大小，跟链式实现的count比较
	private static int SIZE = 1000;  //初始长度

	//构造方法
	public Stack() {
		contents = new String[SIZE];
		top =  0;
	}

	//栈的大小
	public int size() {
		return top;
	}

	//判断栈是否为空
	public boolean isEmpty() {
		return (size() == 0);
	}

	//元素压入栈
	public void push(String element) {
		contents[top] = element;
		top++;
	}
 
	//栈顶元素的弹出
	public String pop() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			System.exit(1);
		}
		String result = contents[top - 1];
		top--;
		return result;
	}
}




