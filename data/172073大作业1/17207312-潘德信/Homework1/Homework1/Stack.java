
public class Stack<E> {
	
	private Object[] data = null;			//栈数据
    private int maxSize=0;				 	//栈容量
    private int top =-1;  					//栈顶指针
    
    Stack() {
    	this(20);
    }
    
    Stack(int initialSize) {
    	if (initialSize >= 0) {
    		maxSize = initialSize;
    		data = new Object[initialSize];
    		top = -1;
    	} else
    		throw new RuntimeException("初始化大小不能小于0：" + initialSize);
    }
    
    public boolean empty(){
        return top==-1 ? true : false;
    }
    
    public void push(E e) {
    	if(top == maxSize - 1)
    		throw new RuntimeException("栈已满，无法将元素入栈！");
    	else
    		data[++top] = e;
    }
    
    public E pop(){
        if(top == -1)
            throw new RuntimeException("栈为空！");
        else
            return (E)data[top--];
    }
    
    public E peek(){
        if(top == -1)
            throw new RuntimeException("栈为空！");
        else
            return (E)data[top];
    }
    
}
