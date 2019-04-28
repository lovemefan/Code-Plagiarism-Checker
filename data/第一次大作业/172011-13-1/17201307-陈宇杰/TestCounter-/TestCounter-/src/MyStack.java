
public class MyStack {
	private int size;// 栈的大小
	private String[] stackArray;// 存储数据的数组
	private int top;// 栈顶指针
	public MyStack() {
		size = 1000;// 初始化栈的大小
		stackArray = new String[size];
		top = -1;
	}

	public void push(String a) {// 入栈
		  if(top == size-1){
	            throw new RuntimeException("栈已满，无法将元素入栈！");
	        }else{
	        	stackArray[++top]=a;
	           
	        }    
		
	}


	public String pop() {// 出栈
		 if(top == -1){
	            throw new RuntimeException("栈为空！");
	        }else
	            return stackArray[top--];
	        
	        
		
	}
	

	public String peek() {// 查询栈顶元素
		
		 if(top == -1){
	            throw new RuntimeException("栈为空！");
	        }else
	            return stackArray[top];
		 }
	


	public boolean isEmpty() {// 判断栈是否为空
		return top==-1 ? true : false;

	}
	public int getTop(){
		return top;
		
	}

}
