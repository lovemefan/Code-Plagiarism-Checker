package Project;

import java.util.EmptyStackException;

public class Stack {
	private String[] contents;  //������ջ��Ԫ��
	private int top;  //top�����һ����ջ��λ�ã�ͬʱҲ��ʾջ��������С������ʽʵ�ֵ�count�Ƚ�
	private static int SIZE = 1000;  //��ʼ����

	//���췽��
	public Stack() {
		contents = new String[SIZE];
		top =  0;
	}

	//ջ�Ĵ�С
	public int size() {
		return top;
	}

	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (size() == 0);
	}

	//Ԫ��ѹ��ջ
	public void push(String element) {
		contents[top] = element;
		top++;
	}
 
	//ջ��Ԫ�صĵ���
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




