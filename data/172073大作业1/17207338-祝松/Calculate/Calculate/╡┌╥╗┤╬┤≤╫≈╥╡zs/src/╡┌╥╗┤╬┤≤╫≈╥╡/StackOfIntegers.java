package 第一次大作业;

public class StackOfIntegers
{
	
	public int[] elements ;
	public int size = -1;
	public int intSize ;// 栈的大小
	
	public char[] array = null;
	public int top = -1;
	public int charSize;

	//构建指定容量的栈
	public void stackofint(int capacity)
	{
		intSize =  capacity;
		elements = new int [capacity];	
	}
	
	//出栈
	public void push(int value)
	{
		if (size < intSize)
		{ // 应在压入数据前判断栈是否为满栈
			elements[size + 1] =value;
			size++;
		} 
	}
	//
	public void pop()
	{
		if (!empty())
		{// 在弹出时应判断栈是否为空栈，空栈则无数据可弹出
			//System.out.println("pop->" + stackArray[top]);	
			 size --;
		}
	}
	//
	public int peek()
	{
		
		int peekElement = elements[size];
		return peekElement;
	}
	//判断是否有值
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
	//堆栈字符
	public void stackofchar(int capacity)
	{
//		System.out.println("capacity"+capacity);
		charSize =  capacity;
		array = new char [capacity];	
	}
	
	//
	public void charpush(char value)
	{
		if (top != charSize-1)
		{ // 应在压入数据前判断栈是否为满栈
			array[top + 1] =value;
			top++;
		} 
	}
	//
	public void charpop()
	{
		if (!EMPTY())
		{// 在弹出时应判断栈是否为空栈，空栈则无数据可弹出
			//System.out.println("pop->" + stackArray[top]);	
			array[charSize-1] = 0;
			 top --;
		}
	}
	//
	public char charpeek()
	{
//		System.out.println("elements[] "+elements[size]);
		char peekchar = array[top];
		return peekchar;
	}
	//
	public boolean EMPTY()
	{
		if (top == -1)
		{
			return true;
		} else
		{
			return false;
		}
	}
	//
	public int chargetsize()
	{
		return charSize;
	}

}
