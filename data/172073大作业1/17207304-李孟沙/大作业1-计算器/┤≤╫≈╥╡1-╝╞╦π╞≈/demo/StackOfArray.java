package demo;

public class StackOfArray {
	int top;		//栈顶
    int base;		//栈底
    double array[];	
    //得到栈顶元素
    public int getTop() {
        return top;
    }
    //修改栈顶元素
    public void setTop(int top) {
        this.top = top;
    }
    //得到栈底元素
    public int getBase() {
        return base;
    }
    //修改栈底元素
    public void setBottom(int base) {
        this.base = base;
    }
    //栈的无参构造方法
    public StackOfArray(){
    	array = new double[200];//初始化一个栈
        top = 0;
        base = 0;
    }
    //栈的含参构造方法
    public StackOfArray(double[] array,int top,int base){
    	this.array = array;
    	this.top = top;
    	this.base =base;
    	 }
    //进栈方法
    public void push(StackOfArray stack,double number){
    	if (stack.top == stack.array.length)//栈已满
    	{
    		System.out.println("stack is full");
    		System.exit(0);
    	}
    	stack.top ++;
    	stack.array[stack.top] = number;
    } 
    //弹栈方法
    public double pop(StackOfArray stack){
    	double a;
    	if (stack.top == -1){//栈已空
    		System.out.println("stack is empty");
    		System.exit(0);
    	}
    	a = stack.array[stack.top];
    	stack.top --;		
    	return a;
    }
}

