
 class Stack {
	private String[] elements;
	private int  size=0;
	public static final int default_length=20;
	public Stack() {
		this(default_length);
	}
	Stack(int length) {//����ջ�Ĵ�С
		elements=new String[length];
	}
	public void push(String value) {//��ջ
		if (size>=elements.length) {
			String [] temp=new String[elements.length*2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	public String pop() {//��ջ	
		return elements[--size];
	}
	public String peek() {//����ջ��ֵ
		return elements[size-1];
	}
	public boolean empty() {//�ж�ջ�Ƿ�Ϊ��
		return size==0;
	}
	public int getSize() {//����ջ�Ĵ�С
		return size;
	}

 }
