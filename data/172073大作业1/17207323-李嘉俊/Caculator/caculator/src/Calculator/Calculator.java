package Calculator;

import java.util.*;

public class Calculator{

    public static void main(String[] args) {
        Stack od=new Stack();//数字栈
        Stack op=new Stack();//符号栈
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int index=0;//记录已经执行的符号数
        int length=str.length();
        //System.out.println(length);
        while(index<length)
        {
            //System.out.println("第"+index+"步++++++++++");
            char c=str.charAt(index);//取出这一步的符号
            if(c=='(')
            {
                //System.out.println(c+"-------进栈");
                op.push(c);//若是左括号就进栈
            }
            //否则要先判断优先级
            else if(c=='+' || c=='-' || c=='*'|| c=='/')
            {
                int currOplevel=getOplevel(c);//当前符号的优先级
                while(true)
                {
                    int stackOplevel=0;//栈顶元素的优先级
                    if(op.isEmpty()==false)
                    {
                        Object obj=op.peek();
                        stackOplevel=getOplevel((char)obj);
                    }
                    //若当前元素优先级大于栈顶元素的优先级则入栈
                    if(currOplevel>stackOplevel)
                    {
                    //  System.out.println(c+"-------进栈");
                        op.push(c);
                        break;//直到让比自己优先级高的符号都出栈运算了再把自己进栈
                    }
                    else//不能入栈就进行计算
                    {
                        try{
                            char optemp='0';
                            int odnum1=0;
                            int odnum2=0;
                            if(op.isEmpty()==false)
                            {
                                optemp=(char)op.pop();//取出优先级大的那个符号
                            }
                            if(od.isEmpty()==false)
                            {
                                 odnum1=(int)od.pop();
                                 odnum2=(int)od.pop();//取出数据栈中的两个数
                            }
                        //  System.out.println(optemp+" "+odnum1+" "+odnum2);
                            //System.out.println(cacuResult(optemp,odnum2,odnum1)+"-------进栈");
                            od.push(cacuResult(optemp,odnum2,odnum1));//将算出来的结果数据再次入数据栈
                        }catch(Exception e){
                            //System.out.println("多项式不正确1"+str+" "+c);
                            e.printStackTrace();
                        }
                    }
                }
            }else if(c==')')//右括号就返回找栈顶元素，右括号是不进栈的
            {
                while(true)
                {
                    char theop=(char)op.pop();
                    if(theop=='(')
                    {
                        break;
                    }
                    else
                    {
                        try{
                            int odnum1=(int)od.pop();
                            int odnum2=(int)od.pop();
                            //System.out.println(" "+odnum1+" "+odnum2);
                            //System.out.println(cacuResult(theop,odnum2,odnum1)+"-------进栈");
                            od.push(cacuResult(theop,odnum2,odnum1));//运算括号内的内容

                        }catch(Exception e)
                        {
                            //System.out.println("多项式不正确2"+str);
                            e.printStackTrace();
                        }
                    }
                }
            }else if(c>='0' && c<='9')
            {
                int tempindex=index+1;
                while(tempindex<length)
                {
                    char tempc=str.charAt(tempindex);//取字符串中处于当前字符的下一位
                    if(tempc>='0'  && tempc<='9')
                    {
                        tempindex++;//若为数字则继续向后取
                    }
                    else
                    {
                        break;//证明数字取完
                    }
                }
                String odstr=str.substring(index,tempindex);//截取这个字符串则为两个符号之间的数字
                //System.out.println("---------"+odstr+"------------");
                try{
                    int odnum=Integer.parseInt(odstr);//将数字转化成整型便于运算
                    //System.out.println(odnum+"-------进栈");
                    od.push(odnum);
                    index=tempindex-1;
                }catch(Exception e)
                {
                    //System.out.println("多项式不正确3"+str);
                    e.printStackTrace();
                }
            }
            index++;
        }
        //检查op栈是否为空
        while(true)
        {
            Object obj=null;
            if(op.isEmpty()==false)
            {
             obj=op.pop();
            }
            if(obj==null)
            {
                break;//为空证明运算已结束
            }
            else//不为空就出栈运算
            {
                char optemp=(char)obj;
                int odnum1=(int)od.pop();
                int odnum2=(int)od.pop();
            //  System.out.println(cacuResult(optemp,odnum2,odnum1)+"-------进栈");
                od.push(cacuResult(optemp,odnum2,odnum1));
            }
        }
        int result=0;
        try{
            result=(int)od.pop();
        }catch(Exception e)
        {
            //System.out.println("多项式不正确4"+str);
            e.printStackTrace();
        }
        System.out.println(result);
    }

        //计算加减乘除余
        public static int cacuResult(char op,int od1,int od2)
        {
            switch(op)
            {
            case '+':return od1+od2;
            case '-':return od1-od2;
            case '*':return od1*od2;
            case '/':return od1/od2;
            }
            return 0;
        }

        //返回符号优先级
        public static int getOplevel(char op)
        {
            switch(op)
            {
            case '(':return 0;
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            default:return 0;
            }
        }
}