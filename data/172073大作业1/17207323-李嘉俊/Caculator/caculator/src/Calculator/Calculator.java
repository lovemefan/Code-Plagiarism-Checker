package Calculator;

import java.util.*;

public class Calculator{

    public static void main(String[] args) {
        Stack od=new Stack();//����ջ
        Stack op=new Stack();//����ջ
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int index=0;//��¼�Ѿ�ִ�еķ�����
        int length=str.length();
        //System.out.println(length);
        while(index<length)
        {
            //System.out.println("��"+index+"��++++++++++");
            char c=str.charAt(index);//ȡ����һ���ķ���
            if(c=='(')
            {
                //System.out.println(c+"-------��ջ");
                op.push(c);//���������žͽ�ջ
            }
            //����Ҫ���ж����ȼ�
            else if(c=='+' || c=='-' || c=='*'|| c=='/')
            {
                int currOplevel=getOplevel(c);//��ǰ���ŵ����ȼ�
                while(true)
                {
                    int stackOplevel=0;//ջ��Ԫ�ص����ȼ�
                    if(op.isEmpty()==false)
                    {
                        Object obj=op.peek();
                        stackOplevel=getOplevel((char)obj);
                    }
                    //����ǰԪ�����ȼ�����ջ��Ԫ�ص����ȼ�����ջ
                    if(currOplevel>stackOplevel)
                    {
                    //  System.out.println(c+"-------��ջ");
                        op.push(c);
                        break;//ֱ���ñ��Լ����ȼ��ߵķ��Ŷ���ջ�������ٰ��Լ���ջ
                    }
                    else//������ջ�ͽ��м���
                    {
                        try{
                            char optemp='0';
                            int odnum1=0;
                            int odnum2=0;
                            if(op.isEmpty()==false)
                            {
                                optemp=(char)op.pop();//ȡ�����ȼ�����Ǹ�����
                            }
                            if(od.isEmpty()==false)
                            {
                                 odnum1=(int)od.pop();
                                 odnum2=(int)od.pop();//ȡ������ջ�е�������
                            }
                        //  System.out.println(optemp+" "+odnum1+" "+odnum2);
                            //System.out.println(cacuResult(optemp,odnum2,odnum1)+"-------��ջ");
                            od.push(cacuResult(optemp,odnum2,odnum1));//��������Ľ�������ٴ�������ջ
                        }catch(Exception e){
                            //System.out.println("����ʽ����ȷ1"+str+" "+c);
                            e.printStackTrace();
                        }
                    }
                }
            }else if(c==')')//�����žͷ�����ջ��Ԫ�أ��������ǲ���ջ��
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
                            //System.out.println(cacuResult(theop,odnum2,odnum1)+"-------��ջ");
                            od.push(cacuResult(theop,odnum2,odnum1));//���������ڵ�����

                        }catch(Exception e)
                        {
                            //System.out.println("����ʽ����ȷ2"+str);
                            e.printStackTrace();
                        }
                    }
                }
            }else if(c>='0' && c<='9')
            {
                int tempindex=index+1;
                while(tempindex<length)
                {
                    char tempc=str.charAt(tempindex);//ȡ�ַ����д��ڵ�ǰ�ַ�����һλ
                    if(tempc>='0'  && tempc<='9')
                    {
                        tempindex++;//��Ϊ������������ȡ
                    }
                    else
                    {
                        break;//֤������ȡ��
                    }
                }
                String odstr=str.substring(index,tempindex);//��ȡ����ַ�����Ϊ��������֮�������
                //System.out.println("---------"+odstr+"------------");
                try{
                    int odnum=Integer.parseInt(odstr);//������ת�������ͱ�������
                    //System.out.println(odnum+"-------��ջ");
                    od.push(odnum);
                    index=tempindex-1;
                }catch(Exception e)
                {
                    //System.out.println("����ʽ����ȷ3"+str);
                    e.printStackTrace();
                }
            }
            index++;
        }
        //���opջ�Ƿ�Ϊ��
        while(true)
        {
            Object obj=null;
            if(op.isEmpty()==false)
            {
             obj=op.pop();
            }
            if(obj==null)
            {
                break;//Ϊ��֤�������ѽ���
            }
            else//��Ϊ�վͳ�ջ����
            {
                char optemp=(char)obj;
                int odnum1=(int)od.pop();
                int odnum2=(int)od.pop();
            //  System.out.println(cacuResult(optemp,odnum2,odnum1)+"-------��ջ");
                od.push(cacuResult(optemp,odnum2,odnum1));
            }
        }
        int result=0;
        try{
            result=(int)od.pop();
        }catch(Exception e)
        {
            //System.out.println("����ʽ����ȷ4"+str);
            e.printStackTrace();
        }
        System.out.println(result);
    }

        //����Ӽ��˳���
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

        //���ط������ȼ�
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