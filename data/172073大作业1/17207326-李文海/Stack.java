
 class Stack {
	private String[] elements;
	private int  size=0;
	public static final int default_length=20;
	public Stack() {
		this(default_length);
	}
	Stack(int length) {//构建栈的大小
		elements=new String[length];
	}
	public void push(String value) {//入栈
		if (size>=elements.length) {
			String [] temp=new String[elements.length*2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	public String pop() {//出栈	
		return elements[--size];
	}
	public String peek() {//返回栈顶值
		return elements[size-1];
	}
	public boolean empty() {//判断栈是否为空
		return size==0;
	}
	public int getSize() {//返回栈的大小
		return size;
	}

 }
