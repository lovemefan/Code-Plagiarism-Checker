public class Shep {
	int top;		//ջ��
    int bottom;		//ջ��
    double array[];
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
    public Shep(){
    	//��ʼ��,����һ����ջ
    	array = new double[500];//��ջ����ռ�
        top = 0;
        bottom = 0;
    }
    //ջ�ĺ��ι��췽��
    public Shep(double[] array,int top,int bottom){
    	this.array = array;
    	this.top = top;
    	this.bottom =bottom;
    	 }
    public void push(Shep stack,double number){
    	if (stack.top == stack.array.length)//�Ƿ�ջ����
    	{
    		System.out.println("stack is full");
    		System.exit(0);
    	}
    	stack.top ++;
    	stack.array[stack.top] = number;
    }
    
    //��ջ
    public double pop(Shep stack){
    	double num;
    	if (stack.top == -1){
    		System.out.println("ջΪ��!");
    		System.exit(0);
    	}
    	num = stack.array[stack.top];
    	stack.top --;
    	return num;
    }
}