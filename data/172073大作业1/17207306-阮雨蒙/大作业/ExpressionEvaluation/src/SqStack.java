public class SqStack{
 
    private Object[] stackElem;  //存储数据的数组
    private int top;			//记录栈顶位置（数组下标）
 
    //构造方法
    public SqStack(int maxSize)
    {
        stackElem=new Object[maxSize];//此maxSize为创建数组的最大容量，因此系统存在越界缺陷
        top=0;
    }
 
    //清空
    public void clear()
    {
        top=0;
    }
    //是否为空
    public boolean isEmpty()
    {
        return top==0;
    }
    //元素个数
    public int length()
    {
        return top;
    }
    //取栈顶元素
    public Object peek()
    {
        if(!isEmpty())
            return stackElem[top-1];
        else
            return null;
    }
 
    //入栈
    public void push(Object x) throws Exception
    {
        if(top==stackElem.length)
        {
            throw new Exception("栈已满！");
        }
        else
        {
            stackElem[top++]=x;
        }
    }
    //出栈
    public Object pop() throws Exception
    {
        if(top==0)
        {
            throw new Exception("栈为空！");
        }
        else
            return stackElem[--top];  //删除然后返回现在的栈顶
    }
 
    //打印（从栈顶到栈底），本工程未用
    public void display()
    {
        for(int i=length()-1; i>=0; i--)
        {
            System.out.print(stackElem[i]+" ");
        }
        System.out.println();
    }
}
