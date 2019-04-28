package Calculator;

public class Stack {
	//栈的底层实现是一个数组

    private int Max;
    public String[] stackarray;//定义一个栈
    private int top;//栈顶指标

   
   public  Stack(int Max) {
        stackarray=new String[Max];
        top=-1;
    }
 //插入一个，栈的插入是先将top自增后再插入，我们要保证top是对应的栈顶的
    public void push(String number){
    	stackarray[++top]=number;
    }
    public String peek(){
    	return stackarray[top];
    }
  //弹出，与插入的步骤相反，先把栈顶的数返回，再讲top自减

    public String pop(){
    	return stackarray[top--];
    }

	//检查栈是否为空

    public boolean isEmpty(){
    	return top==-1;
    }

	//检查栈是否已满

    public boolean ifFull(){
    	return top==Max-1;
    }
}

