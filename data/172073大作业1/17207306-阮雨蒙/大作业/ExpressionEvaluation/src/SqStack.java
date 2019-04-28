public class SqStack{
 
    private Object[] stackElem;  //�洢���ݵ�����
    private int top;			//��¼ջ��λ�ã������±꣩
 
    //���췽��
    public SqStack(int maxSize)
    {
        stackElem=new Object[maxSize];//��maxSizeΪ���������������������ϵͳ����Խ��ȱ��
        top=0;
    }
 
    //���
    public void clear()
    {
        top=0;
    }
    //�Ƿ�Ϊ��
    public boolean isEmpty()
    {
        return top==0;
    }
    //Ԫ�ظ���
    public int length()
    {
        return top;
    }
    //ȡջ��Ԫ��
    public Object peek()
    {
        if(!isEmpty())
            return stackElem[top-1];
        else
            return null;
    }
 
    //��ջ
    public void push(Object x) throws Exception
    {
        if(top==stackElem.length)
        {
            throw new Exception("ջ������");
        }
        else
        {
            stackElem[top++]=x;
        }
    }
    //��ջ
    public Object pop() throws Exception
    {
        if(top==0)
        {
            throw new Exception("ջΪ�գ�");
        }
        else
            return stackElem[--top];  //ɾ��Ȼ�󷵻����ڵ�ջ��
    }
 
    //��ӡ����ջ����ջ�ף���������δ��
    public void display()
    {
        for(int i=length()-1; i>=0; i--)
        {
            System.out.print(stackElem[i]+" ");
        }
        System.out.println();
    }
}
