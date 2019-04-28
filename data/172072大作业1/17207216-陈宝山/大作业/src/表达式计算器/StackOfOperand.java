package ���ʽ������;

import java.lang.System;
public class StackOfOperand {
	private double[] elements;
	private int size=0;//��¼ջ��Ԫ�صĸ���
	public static final int DEFAULT_CAPACITY=16;
	
	public StackOfOperand(int capacity) {
		elements=new double[capacity];
	}
	
	public StackOfOperand() {
		this(DEFAULT_CAPACITY);
	}
	
	public void push(double value) {/*ջ��������ջ��Ԫ�ظ�������ջ�����������鳤�ȣ�
	����һ������Ϊ��ǰ���������������飬����ǰ��������ݸ��Ƶ��������У���������������ø���ջ�е�ǰ����*/
		if(size>=elements.length) {
			double[] temp=new double[elements.length+5];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements=temp;
		}
		elements[++size]=value;	
	}
	
	public double pop() {
		return elements[size--];
		
	}
	
	public double peek() {
		return elements[size];
	}
	
	public boolean empty(){
		return size==0;
	}
	
	public int getSize() {
		return size;
	}
	
	
}

