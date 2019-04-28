
public class StackOfArray {
	int top;		//ջ��
    int bottom;		//ջ��
    double array[];	//ջ�ı���--����
    //�õ�ջ��Ԫ��
    public int getTop() {
        return top;
    }
    //�޸�ջ��Ԫ��
    public void setTop(int top) {
        this.top = top;
    }
    //�õ�ջ��Ԫ��
    public int getBottom() {
        return bottom;
    }
    //�޸�ջ��Ԫ��
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    //ջ���޲ι��췽��
    public StackOfArray(){
    	//��ʼ��,����һ����ջ
    	array = new double[200];//��ջ����ռ�
        top = 0;
        bottom = 0;
    }
    //ջ�ĺ��ι��췽��
    public StackOfArray(double[] array,int top,int bottom){
    	this.array = array;
    	this.top = top;
    	this.bottom =bottom;
    	 }
    public void push(StackOfArray stack,double number){
    	if (stack.top == stack.array.length)//ջ��Ԫ���Ѿ���ջ���������пռ����ˣ���ʾջ����
    	{
    		System.out.println("stack is full");
    		System.exit(0);
    	}
    	stack.top ++;
    	stack.array[stack.top] = number;
    }
    
    //��ջ
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

