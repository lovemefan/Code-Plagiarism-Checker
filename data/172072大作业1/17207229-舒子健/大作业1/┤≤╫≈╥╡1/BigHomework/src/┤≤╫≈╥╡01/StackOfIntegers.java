package ����ҵ01;

/*��������ջ��*/
public class StackOfIntegers {
		private int[] elements;
		private int size;
		public static final int DEFAULT_CAPACITY = 16;//Ĭ������
		
		public StackOfIntegers() {
			this(DEFAULT_CAPACITY);
		}

		public StackOfIntegers(int capacity) {
			elements = new int[capacity];
		}
		/*Ԫ�ؽ�ջ*/
		public void push(int value) {
			if(size >= elements.length) {//���ջ��
				int[] temp = new int[elements.length * 2];//����һ���������������
				System.arraycopy(elements, 0, temp, 0, elements.length);//����ǰ��������ݸ��Ƶ�������
				elements = temp;//���������Ӧ�ø�ֵ��ջ�е�ǰ����
			}
			elements[size++] = value;
		} 
		/*Ԫ�س�ջ*/
		public int pop() {
			return elements[--size];
		}
		/*��ȡջ��Ԫ�أ�δ��ջ*/
		public int peek() {
			return elements[size-1];
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


