package mathCalculator;

public class stringStack {   //�Զ����ַ�������ջ
	private int maxSize;      
    private String[] stackArray;     //�ַ�������ʵ��
    private int top;
    
    public stringStack(int max) {   //���췽����������
       maxSize = max;
       stackArray = new String[maxSize];
       top = -1;
    }
    
    public void push(String j) {  //ѹջ����
       stackArray[++top] = j;
    }
    
    public String pop() {    //��ջ����
       return stackArray[top--];
    }
    
    public String peek() {   //��ȡջ��Ԫ��
       return stackArray[top];
    }
    
    public boolean isEmpty() {  //�ж��Ƿ�Ϊ��
       return (top == -1);
   }

}
