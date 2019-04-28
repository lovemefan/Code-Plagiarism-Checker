public class Shep {
	int top;		//栈顶
    int bottom;		//栈底
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
    public int getBottom() {
        return bottom;
    }
    //修改栈底元素
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    //栈的无参构造方法
    public Shep(){
    	//初始化,构建一个空栈
    	array = new double[500];//给栈申请空间
        top = 0;
        bottom = 0;
    }
    //栈的含参构造方法
    public Shep(double[] array,int top,int bottom){
    	this.array = array;
    	this.top = top;
    	this.bottom =bottom;
    	 }
    public void push(Shep stack,double number){
    	if (stack.top == stack.array.length)//是否栈已满
    	{
    		System.out.println("stack is full");
    		System.exit(0);
    	}
    	stack.top ++;
    	stack.array[stack.top] = number;
    }
    
    //弹栈
    public double pop(Shep stack){
    	double num;
    	if (stack.top == -1){
    		System.out.println("栈为空!");
    		System.exit(0);
    	}
    	num = stack.array[stack.top];
    	stack.top --;
    	return num;
    }
}