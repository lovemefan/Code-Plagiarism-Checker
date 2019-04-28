package 表达式计算器;

import java.lang.System;
public class StackOfOperater {

		private char[] elements;
		private int size=0;//记录栈中元素的个数
		public static final int DEFAULT_CAPACITY=16;
		
		public StackOfOperater(int capacity) {
			elements=new char[capacity];
		}
		
		public StackOfOperater() {
			this(DEFAULT_CAPACITY);
		}
		
		public void push(char value) {/*栈已满，即栈中元素个数大于栈的容量（数组长度）
		创建一个容量为当前数组两倍的新数组，将当前数组的内容复制到新数组中，并将新数组的引用赋给栈中当前数组*/
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
