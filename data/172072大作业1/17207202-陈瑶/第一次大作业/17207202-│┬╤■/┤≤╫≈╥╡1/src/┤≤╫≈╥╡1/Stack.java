package 大作业1;

import java.util.Vector;

public class Stack 
{
	private int top = -1; // 指向栈顶，用于栈的遍历
	private int stackSize = 0;// 栈的大小
	public char[] stackArray = null;// 用于创建栈的数组
	
	public int[] elements ;
	public int size = -1;
	public int intSize ;// 栈的大小
	
	//构建指定容量的栈
	public void stackofintergers(int capacity)
	{
//		System.out.println("capacity"+capacity);
		intSize =  capacity;
		elements = new int [capacity];	
	}
	
	//
	public void push(int value)
	{
		if (size < intSize)
		{ // 应在压入数据前判断栈是否为满栈
			elements[size + 1] =value;
			size++;
		} 
	}
	//
	public void intpop()
	{
		if (!empty())
		{// 在弹出时应判断栈是否为空栈，空栈则无数据可弹出
			//System.out.println("pop->" + stackArray[top]);	
			 size --;
		}
	}
	//
	public int intpeek()
	{
//		System.out.println("elements[] "+elements[size]);
		int peekElement = elements[size];
		return peekElement;
	}
	//
	public boolean empty()
	{
		if (size == -1)
		{
			return true;
		} else
		{
			return false;
		}
	}
	//
	public int getsize()
	{
		return intSize;
	}
	// create stack use array（创建一个指定大小的新栈）
	public void createStack(int size)//传入指定运算表达式的字符串长度
	{
		stackSize = size;
		stackArray = new char[size];
	}

	// push element（数据压入）
	public void push(char element)
	{
		if (top != stackSize - 1)
		{ // 应在压入数据前判断栈是否为满栈
			stackArray[top + 1] = element;
			top++;
		} 
	}

	// pop element（数据弹出）
	public void pop()
	{
		if (!isEmpty())
		{// 在弹出时应判断栈是否为空栈，空栈则无数据可弹出
			//System.out.println("pop->" + stackArray[top]);
			stackArray[stackSize - 1] = 0;	
			top--;
		}
	}

	// look element（查看栈顶数据）
	public char peek()
	{
		char peekElement = stackArray[top];
		return peekElement;
	}

	// is empty（判断栈是否为空）
	public boolean isEmpty()
	{
		if (top == -1)
		{
			return true;
		} else
		{
			return false;
		}
	}

	// is full（判断栈是否为满栈）
	public boolean isFull()
	{
		if (stackSize != -1)
		{
			if (top == stackSize - 1)
			{
				return true;
			} else
			{
				return false;
			}
		} else
		{
			return false;

		}
	}

}
