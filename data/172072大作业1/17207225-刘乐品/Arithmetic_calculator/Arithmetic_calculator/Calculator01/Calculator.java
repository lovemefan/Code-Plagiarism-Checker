package Calculator01;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Calculator {
	
	private Stack<String> niboStack = new Stack<String>();//�沨����ջ
	private Stack<Character> opStack = new Stack<Character>();//�������ջ
	private Stack<String> daoStack=new Stack<String>();//��ջ
	
	public String fuhao(String exp)//�����ʽ�еĸ��ű��
	{
		char[] zo = exp.toCharArray();
		int i;
		char r;
		for(i=0;i<zo.length;i++)
		{
			if(zo[i]=='-')
			{
				if(i==0)
					zo[i]='^';//��һ��λ���Ǹ���
				else
				{
				r=zo[i-1];
				if (isfuhao(r)==true)
				zo[i]='^';
				}	
			}
		}
		
		if(zo[0]=='^'&&zo[1]=='(')
		{
            zo[0]='-';//��һ��λ���Ǹ��ţ���������������
            return "0"+new String(zo);
        } 
		else
            return new String(zo);
		
	}
	public void cal(String exp)//ת��Ϊ��׺ʽ
	{
		char []ba=exp.toCharArray();
		int i=0;
		int ad=0;
		int leng=0;
		char c,p;
		opStack.push('#');
		 for (i=0;i<ba.length;i++) {
	            c=ba[i];
	            if(isfuhao(c)==true) {
	                // �����ǰ�ַ��������
	                if (leng>0) 
	                {
	                	niboStack.push(new String(ba,ad,leng));// ȡ���������֮�������
	                }
	                p=opStack.peek();
	                if (pd3(c)) 
	                {
	                    while(pd()) // �����������������ջ�е�Ԫ���Ƴ�����׺ʽջ��ֱ������������
	                    {
	                    	niboStack.push(String.valueOf(opStack.pop()));
	                    }
	                    opStack.pop();
	                } 
	                else 
	                {
	                    while (pd2(c,p)) 
	                    {
	                    	niboStack.push(String.valueOf(opStack.pop()));
	                        p=opStack.peek();
	                    }
	                    opStack.push(c);
	                }
	                leng=0;
	                ad=i+1;
	            } 
	            else
	            	leng++;
		 }
		 if(pd5(leng,ba[ad])){
	            // ���һ���ַ��������Ż��������������������׺ʽջ��
	            niboStack.push(new String(ba,ad,leng));
	        }
	        while(pd4())
	        {
	            niboStack.push(String.valueOf(opStack.pop()));
	            // ��������ջ�е�ʣ���Ԫ����ӵ���׺ʽջ��
	        }
}   
	public Boolean pd()
	{
		if(opStack.peek()!='(')
			return true;
		else
			return false;
	}
	public Boolean pd2(char c,char p)
	{
		if(c!='('&&p!='#'&&compare(c, p))
			return true;
		else
			return false;
	}
	public Boolean pd3(char c)
	{
		if(c==')')
			return true;
		else
			return false;
	}
	public Boolean pd4()
	{
		if(opStack.peek()!='#')
			return true;
		else
			return false;
	}
	public Boolean pd5(int le,char f)
	{
		if(le> 1||(le==1&&isfuhao(f)==false))
			return true;
		else
			return false;
	}
	
	public Boolean isfuhao(char r)
	{
		if(r=='+'||r=='-'||r=='*'||r=='/'||r=='('||r==')')
			return true;
		else
			return false;
	}
	
	public Boolean compare(char c, char p)//�Ƚ�ջ�ڷ�����ջ����ŵĵȼ�
	{
		Boolean result = false;
		Datezan judge=new Datezan();
		if(judge.priority(0,c)<=judge.priority(1,p))
		{
			result = true;
		}
		return result;
	}
	public void zhuan() // ����׺ʽջ��ת
	{

		while(!niboStack.empty())
		{
		//System.out.println(niboStack.peek());
		daoStack.push(niboStack.peek());
		niboStack.pop();
		}
		//System.out.println("--------");
	}
	public int js(){//����
        Stack<String> resultStack = new Stack<String>();
        String result="";
        String first, second,current;
        // �������ĵ�һ��ֵ���ڶ���ֵ�����������
        int f,s,end;
        while(!daoStack.empty())
        {
        	current=daoStack.pop();
        	if(!(current.charAt(0)=='+'||current.charAt(0)=='-'||current.charAt(0)=='*'||current.charAt(0)=='/'))
        	{
        		 current=current.replace("^","-");
                 resultStack.push(current);
        	}
        	else
        	{
        		second= resultStack.pop();
                first= resultStack.pop();
                switch (current.charAt(0)){
                case '+':
                	f=Integer.valueOf(first);
                	s=Integer.valueOf(second);
                	end=f+s;
                	result=String.valueOf(end);
                    break;
                    
                case '-':
                	f=Integer.valueOf(first);
                	s=Integer.valueOf(second);
                	end=f-s;
                	result=String.valueOf(end);
                    break;
             
                case '*':
                	f=Integer.valueOf(first);
                	s=Integer.valueOf(second);
                	end=f*s;
                	result=String.valueOf(end);
                    break;
              
                case '/':
                	f=Integer.valueOf(first);
                	s=Integer.valueOf(second);
                	end=f/s;
                	result=String.valueOf(end);
                    break;
            }
                resultStack.push(result);	
        }
        	
        	
        }
        	return Integer.valueOf(resultStack.pop());
    }

	
	public static void main(String[] args) throws IOException {
		Fileoperation fo = new Fileoperation();
		File f = new File("Cal\\yun");	
		fo.readLineAndOpen(f);
		
		/*Calculator e=new Calculator();
		String s="-3+(3+4)*5+4/2";
		String r;
		int result=0;
		r=e.fuhao(s);
		e.cal(r);
		e.zhuan();
		result=e.js();
		System.out.println(result);	*/	
		// TODO Auto-generated method stub

	}
}

