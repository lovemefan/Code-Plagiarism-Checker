package 数学表达式计算器;

import java.io.IOException;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileOutputStream;

public class transform {

	/*public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Stack();
		
	}*/
	public static void Stack(String str) throws IOException {
	
		
		Stack<Integer> postfixStack = new Stack<Integer>();// 后缀式栈
	    Stack<Character> opStack = new Stack<Character>();// 运算符栈
		
	    opStack.push('#');
		char[] arr = str.toCharArray();
		
		
		int currentIndex = 0;
		int count = 0;
		char currentop;
		
		for(int i=0;i<arr.length;i++)
		{
			currentop = arr[i];
				
			if(isOperator(currentop))
			{
				if(count>0)
				{
					postfixStack.push(Integer.valueOf(new String(arr,currentIndex,count)));
				}
				
			
				
				if(currentop == ')')
				{
					while(opStack.peek() != '(')
					{
							
						int result = compute(postfixStack.pop(),postfixStack.pop(),opStack.pop());
						postfixStack.push(result);
					}
					opStack.pop();
				}
				else
				{
					while(compare(currentop,opStack.peek()) && opStack.peek()!='#' && opStack.peek() != '(')//栈顶操作符优先级高
					{
						int result = compute(postfixStack.pop(),postfixStack.pop(),opStack.pop());
						postfixStack.push(result);
					}
					opStack.push(currentop);
				}
			
				currentIndex = i+1;
				count = 0;
			}
			else
			{
				count++;
			}
		}
			
		
		
		if(count>0 && !isOperator(arr[currentIndex]))
		{
			postfixStack.push(Integer.valueOf(new String(arr,currentIndex,count)));
		}
		
		
		while(opStack.peek()!='#')
		{
			int result = compute(postfixStack.pop(),postfixStack.pop(),opStack.peek());
			postfixStack.push(result);
			opStack.pop();
		}
		
		if(!postfixStack.empty())
		{
			int result = postfixStack.peek();
		
			printfile(str,result);
		}
		
		
		postfixStack.clear();
		opStack.clear();
	}
	
	public static boolean isOperator(char c)
	{
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')
		{
			return true;
		}
		return false;
	}
	
	 public static boolean compare(char cur, char peek) // 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
	 {
	        boolean result = false;
	        
	        
	        if(priority(cur) >= priority(peek))
	        {
	        	result = true;
	        }
	        return result;
	 }
	 
	 public static int priority(char object)
		{
			int tmp = 0;
			if(object == '+' || object == '-')
			{
				tmp = 5;
			}
			if(object == '*' || object == '/')
			{
				tmp = 4;
			}
			if(object == '(' || object == ')')
			{
				tmp = 1;
			}
			
			return tmp;
		}

	 public static int compute(int a,int b,char operate)
		{
			switch(operate)
			{
				case '+':
					return a+b;
				case '-':
					return b-a;
				case '*':
					return a*b;
				case '/':
					return b/a;
			}
			return 0;
		}
	 
	 public static void printfile(String str,int result) throws IOException
	 {
		 FileOutputStream file = new FileOutputStream("test2.txt", true);
		 
		 
		 file.write("\r\n".getBytes());
		 file.write(str.getBytes());
		 file.write(" = ".getBytes());
		 String arr = String.valueOf(result);
		 file.write(arr.getBytes());
		  
	 }

}


