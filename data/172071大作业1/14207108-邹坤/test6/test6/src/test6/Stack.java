package test6;

//栈类
public class Stack{
	int top ;
	String[] array ;
	
	//构造方法
	public Stack(){
		this.array = new String[1000];
		this.top = 0;
	}
	
	//进栈
	public void inputStack( String ch ){
		array[top++] = ch;
		//判断这个栈满了没；
		if(top == array.length){
			System.out.println("这个栈已经满了");
		}	
	}
	
	// 出栈
	public String outputStack() {
		String ch = array[--top];
		return ch;
	}
	
	//判断栈是不是为空
	public boolean isEmpty(){
		return top == 0;
	}
}

