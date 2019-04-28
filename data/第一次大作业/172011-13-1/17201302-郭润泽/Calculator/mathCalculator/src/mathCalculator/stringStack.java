package mathCalculator;

public class stringStack {   //自定义字符串类型栈
	private int maxSize;      
    private String[] stackArray;     //字符串数组实现
    private int top;
    
    public stringStack(int max) {   //构造方法声明长度
       maxSize = max;
       stackArray = new String[maxSize];
       top = -1;
    }
    
    public void push(String j) {  //压栈方法
       stackArray[++top] = j;
    }
    
    public String pop() {    //出栈方法
       return stackArray[top--];
    }
    
    public String peek() {   //获取栈顶元素
       return stackArray[top];
    }
    
    public boolean isEmpty() {  //判断是否为空
       return (top == -1);
   }

}
