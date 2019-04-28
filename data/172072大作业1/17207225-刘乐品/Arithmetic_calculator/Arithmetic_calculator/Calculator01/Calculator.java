package Calculator01;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Calculator {
	
	private Stack<String> niboStack = new Stack<String>();//逆波兰的栈
	private Stack<Character> opStack = new Stack<Character>();//运算符的栈
	private Stack<String> daoStack=new Stack<String>();//数栈
	
	public String fuhao(String exp)//将表达式中的负号标记
	{
		char[] zo = exp.toCharArray();
		int i;
		char r;
		for(i=0;i<zo.length;i++)
		{
			if(zo[i]=='-')
			{
				if(i==0)
					zo[i]='^';//第一个位置是负号
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
            zo[0]='-';//第一个位置是负号，但后面是左括号
            return "0"+new String(zo);
        } 
		else
            return new String(zo);
		
	}
	public void cal(String exp)//转换为后缀式
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
	                // 如果当前字符是运算符
	                if (leng>0) 
	                {
	                	niboStack.push(new String(ba,ad,leng));// 取两个运算符之间的数字
	                }
	                p=opStack.peek();
	                if (pd3(c)) 
	                {
	                    while(pd()) // 遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
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
	            // 最后一个字符不是括号或者其他运算符的则加入后缀式栈中
	            niboStack.push(new String(ba,ad,leng));
	        }
	        while(pd4())
	        {
	            niboStack.push(String.valueOf(opStack.pop()));
	            // 将操作符栈中的剩余的元素添加到后缀式栈中
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
	
	public Boolean compare(char c, char p)//比较栈内符号与栈外符号的等级
	{
		Boolean result = false;
		Datezan judge=new Datezan();
		if(judge.priority(0,c)<=judge.priority(1,p))
		{
			result = true;
		}
		return result;
	}
	public void zhuan() // 将后缀式栈反转
	{

		while(!niboStack.empty())
		{
		//System.out.println(niboStack.peek());
		daoStack.push(niboStack.peek());
		niboStack.pop();
		}
		//System.out.println("--------");
	}
	public int js(){//计算
        Stack<String> resultStack = new Stack<String>();
        String result="";
        String first, second,current;
        // 参与计算的第一个值，第二个值和算术运算符
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

