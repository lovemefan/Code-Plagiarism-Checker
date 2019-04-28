
public class StackOfArray {

	int top;		//栈顶
    int bottom;		//栈底
    double array[];	//栈的本质--数组
    //得到栈顶元素
    public int getTop() {
        return top;
    }
    //修改栈顶元素
    public void setTop(int top) {
        this.top = top;
    }
    //得到栈底元素
    public int getBottom() {
        return bottom;
    }
    //修改栈底元素
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
  //栈的无参构造方法
    public StackOfArray(){
    	//初始化,构建一个空栈
    	array = new double[200];//给栈申请空间
        top = 0;
        bottom = 0;
    }
    //栈的含参构造方法
    public StackOfArray(double[] array,int top,int bottom){
    	this.array = array;
    	this.top = top;
    	this.bottom =bottom;
    	 }
    public void push(StackOfArray stack,double number){
    	if (stack.top == stack.array.length)//栈的元素已经到栈的数组所有空间的最顶了，表示栈已满
    	{
    		System.out.println("stack is full");
    		System.exit(0);
    	}
    	stack.top ++;
    	stack.array[stack.top] = number;
    }
    
    //弹栈
    public double pop(StackOfArray stack){
    	double a;
    	if (stack.top == -1){
    		System.out.println("stack is empty");
    		System.exit(0);
    	}
    	a = stack.array[stack.top];
    	stack.top --;		
    	return a;
    }
}