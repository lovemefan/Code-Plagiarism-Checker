package mathCalculator;

public class intStack {           //自定义整形栈
	private int maxSize;
    private int[] stackArray;    //整形数组实现
    private int top;
    
    public intStack (int max) {  //构造方法声明栈长度
       maxSize = max;
       stackArray = new int[maxSize];
       top = -1;
    }
    
    public void push(int i) {   //压栈方法
       stackArray[++top] = i;
    }
    
    public int pop() {     //出栈方法
       return stackArray[top--];
    }
    
    public int peek() {   //获取栈顶元素
       return stackArray[top];
    }
    
    public boolean isEmpty() { //判断是否为空
       return (top == -1);
   }
}
