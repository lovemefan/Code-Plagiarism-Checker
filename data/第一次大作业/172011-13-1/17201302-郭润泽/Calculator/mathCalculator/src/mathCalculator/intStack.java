package mathCalculator;

public class intStack {           //�Զ�������ջ
	private int maxSize;
    private int[] stackArray;    //��������ʵ��
    private int top;
    
    public intStack (int max) {  //���췽������ջ����
       maxSize = max;
       stackArray = new int[maxSize];
       top = -1;
    }
    
    public void push(int i) {   //ѹջ����
       stackArray[++top] = i;
    }
    
    public int pop() {     //��ջ����
       return stackArray[top--];
    }
    
    public int peek() {   //��ȡջ��Ԫ��
       return stackArray[top];
    }
    
    public boolean isEmpty() { //�ж��Ƿ�Ϊ��
       return (top == -1);
   }
}
