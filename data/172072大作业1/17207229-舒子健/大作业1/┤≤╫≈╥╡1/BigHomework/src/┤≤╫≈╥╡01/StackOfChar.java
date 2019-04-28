package ����ҵ01;

/*�������ջ��*/
public class StackOfChar {
	private char[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;//Ĭ������
	
	public StackOfChar() {
		this(DEFAULT_CAPACITY);
	}

	public StackOfChar(int capacity) {
		elements = new char[capacity];
	}
	/*Ԫ�ؽ�ջ*/
	public void push(char ch) {
		if(size >= elements.length) {//���ջ��
			char[] temp = new char[elements.length * 2];//����һ���������������
			System.arraycopy(elements, 0, temp, 0, elements.length);//����ǰ��������ݸ��Ƶ�������
			elements = temp;//���������Ӧ�ø�ֵ��ջ�е�ǰ����
		}
		elements[size++] = ch;
	} 
	/*Ԫ�س�ջ*/
	public char pop() {
		return elements[--size];
	}
	/*��ȡջ��Ԫ�أ�δ��ջ*/
	public char peek() {
		return elements[size - 1];
	}
	/*�ж�ջ�Ƿ�Ϊ��*/
	public boolean empty() {
		return size == 0;
	}
	/*ջ��Ԫ�ظ���*/
	public int getSize() {
		return size;
	}
}
