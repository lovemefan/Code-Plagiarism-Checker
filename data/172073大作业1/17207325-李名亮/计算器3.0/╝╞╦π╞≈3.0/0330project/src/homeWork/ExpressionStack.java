package homeWork;
public class ExpressionStack {		//String类型的栈
	public String[] stack;
	public int size=-1;
	public static final int DEFAULT_CAPACITY=20;
	public ExpressionStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public ExpressionStack(int capacity) {
		stack=new String[capacity];
	}
	
	public String pop() {		//出栈
		if(!emty())
			return null;
		else
			return stack[size--];
	}
	
	public void push(String ch) {//入栈
		if(size>=stack.length-1) {
			String[] temp=new String[stack.length*2];
			System.arraycopy(stack, 0, temp, 0, stack.length);
			stack=temp;
		}
		stack[++size]=ch;
	}
	
	public boolean emty() {//栈空返回false
		if(size==-1)
			return false;
		else
			return true;
	}
	
	public String getTops() {//获取栈顶元素
		if(!emty())
			return null;
		else
			return stack[size];
	}
	
}