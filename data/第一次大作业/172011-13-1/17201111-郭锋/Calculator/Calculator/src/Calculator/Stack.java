package Calculator;

public class Stack {
	//ջ�ĵײ�ʵ����һ������

    private int Max;
    public String[] stackarray;//����һ��ջ
    private int top;//ջ��ָ��

   
   public  Stack(int Max) {
        stackarray=new String[Max];
        top=-1;
    }
 //����һ����ջ�Ĳ������Ƚ�top�������ٲ��룬����Ҫ��֤top�Ƕ�Ӧ��ջ����
    public void push(String number){
    	stackarray[++top]=number;
    }
    public String peek(){
    	return stackarray[top];
    }
  //�����������Ĳ����෴���Ȱ�ջ���������أ��ٽ�top�Լ�

    public String pop(){
    	return stackarray[top--];
    }

	//���ջ�Ƿ�Ϊ��

    public boolean isEmpty(){
    	return top==-1;
    }

	//���ջ�Ƿ�����

    public boolean ifFull(){
    	return top==Max-1;
    }
}

