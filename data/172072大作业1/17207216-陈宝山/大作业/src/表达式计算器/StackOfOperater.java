package ���ʽ������;

import java.lang.System;
public class StackOfOperater {

		private char[] elements;
		private int size=0;//��¼ջ��Ԫ�صĸ���
		public static final int DEFAULT_CAPACITY=16;
		
		public StackOfOperater(int capacity) {
			elements=new char[capacity];
		}
		
		public StackOfOperater() {
			this(DEFAULT_CAPACITY);
		}
		
		public void push(char value) {/*ջ��������ջ��Ԫ�ظ�������ջ�����������鳤�ȣ�
		����һ������Ϊ��ǰ���������������飬����ǰ��������ݸ��Ƶ��������У���������������ø���ջ�е�ǰ����*/
			if(size>=elements.length) {
				char[] temp=new char[elements.length+5];
				System.arraycopy(elements, 0, temp, 0, elements.length);
				elements=temp;
			}
			elements[++size]=value;	
		}
		
		public char pop() {
			return elements[size--];
		}
		
		public char peek() {
			return elements[size];
		}
		
		public boolean empty(){
			return size==0;
		}
		
		public int getSize() {
			return size;
		}

}
