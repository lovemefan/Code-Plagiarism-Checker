import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Calculator1 {
	
	  private static int symbol(String symbol)
	  {
	       if(!symbol.equals("+") && !symbol.equals("-")&& !symbol.equals("*") && !symbol.equals("/")&& !symbol.equals("(") && !symbol.equals(")"))
	       {
	    	   return 1;
	       }
	       else
	       {
	       return 0;
	       }
	    }
	 private static ArrayList<String> strFormat(String src) 
	 {
	      
	        ArrayList<String> arrayList = new ArrayList<>();
	        StringBuilder comChar = new StringBuilder();
	        for (int i = 0; i <src.length(); i++) 
	        {
	            char ch = src.charAt(i);
	            if (ch == ' ') 
	            {
	                continue;  //去除空格
	            }
	            if (!Character.isDigit(ch))
	            {
	                if (!comChar.toString().trim().equals(" ")) 
	                {
	                    arrayList.add(comChar.toString().trim());
	                    comChar.delete(0, comChar.length());
	                }
	                arrayList.add(ch + "");
	                continue;
	            }
	            comChar.append(ch);
	        }
	        if (!comChar.toString().trim().equals("")) 
	        {
	            arrayList.add(comChar.toString().trim());
	        }
	        return arrayList;
	    }
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		String arithmetic =input.nextLine();
	   
		Stack<Integer>num=new Stack<Integer>();
		Stack<String>operate=new Stack<String>();
		
		 ArrayList<String> express =strFormat(arithmetic);
		  for(int i=0;i<express.size();i++)
			{
				System.out.print(express.get(i));
			}
		  
		  System.out.print("=");
		  
		
		for(int i=0;i<express.size();i++)
		{
			
		 if(symbol(express.get(i))==1)
		  {
		
			
			  num.push(Integer.parseInt(express.get(i).equals("")?"0":express.get(i)));
			  if(num.peek()==0)
			  {
				  int a=  num.pop();
			  }
		  }
		  else if((express.get(i)).equals("+")||express.get(i).equals("-"))
		  {
			  while (!operate.isEmpty()&&(operate.peek() .equals("-") || operate.peek() .equals( "+" ) ||operate.peek() .equals( "*") ||operate.peek() .equals("/"))) 
			  {
				  String op = operate.pop();  //弹出一个操作符
			        int op1 = num.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
			        int op2 = num.pop();
			        if (op.equals("+"))  
			        	num.push(op1 + op2);
			        else if (op.equals("-"))
			        	num.push(op2 - op1);  
			        else if (op.equals("*"))
			        	num.push(op1 * op2);
			        else if (op.equals("/"))
			        	num.push(op2 / op1);
              }
              operate.push(express.get(i));   //运算完之后将当前的运算符入栈
          }
		  else if((express.get(i)).equals("*")||express.get(i).equals("/"))
		  {
			  while (!operate.isEmpty()&&(operate.peek() .equals( "*") ||operate.peek() .equals("/")))
			  {
				  String op = operate.pop();  //弹出一个操作符
			        int op1 = num.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
			        int op2 = num.pop();
			        if (op.equals("+"))  //如果操作符为+就执行加运算
			        	num.push(op1 + op2);
			        else if (op.equals("-"))
			        	num.push(op2 - op1);   
			        else if (op.equals("*"))
			        	num.push(op1 * op2);
			        else if (op.equals("/"))
			        	num.push(op2 / op1);
              }
			  operate.push(express.get(i));   //将当前操作符入栈
          }
		  else if ((express.get(i)).equals("(")) 
		  {
              operate.push("(");
          }
          //如果是右括号的话，清除栈中的运算符直至左括号
          else if ((express.get(i)).equals(")")) 
          {
              while (!(operate.peek()).equals("("))
              {
            	  String op = operate.pop();  //弹出一个操作符
			        int op1 = num.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
			        int op2 = num.pop();
			        if (op.equals("+"))  //如果操作符为+就执行加运算
			        	num.push(op1 + op2);
			        else if (op.equals("-"))
			        	num.push(op2 - op1);   //因为这个是栈的结构，自然是上面的数字是后面的，因此用op2-op1
			        else if (op.equals("*"))
			        	num.push(op1 * op2);
			        else if (op.equals("/"))
			        	num.push(op2 / op1);
              }
              operate.pop();   //这里的是运算完之后清除左括号
          }
        
         
         
      }
      //最后当栈中不是空的时候继续运算，知道栈中为空即可
      while (!operate.isEmpty()) 
      {
    	  String op = operate.pop();  //弹出一个操作符
	        int op1 = num.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
	        int op2 = num.pop();
	        if (op.equals("+"))  //如果操作符为+就执行加运算
	        	num.push(op1 + op2);
	        else if (op.equals("-"))
	        	num.push(op2 - op1);   //因为这个是栈的结构，自然是上面的数字是后面的，因此用op2-op1
	        else if (op.equals("*"))
	        	num.push(op1 * op2);
	        else if (op.equals("/"))
	        	num.push(op2 / op1);
      }
     
		int result=num.pop();    //此时数据栈中的数据就是运算的结果
		System.out.println(result);
		
		
		
		java.io.File file=new java.io.File("arithmetic.txt");
		if(file.exists())
		{
			System.out.print("文件文本输出：");
			
		}		
		java.io.PrintWriter output=new java.io.PrintWriter(file);
		 for(int i=0;i<express.size();i++)
			{
				output.print(express.get(i));
			}
		 output.println("="); 
		output.println(result);
		output.close();
		
		java.io.File fileReader=new java.io.File ("arithmetic.txt");
		Scanner input1=new Scanner(fileReader);
		while(input1.hasNextLine())
		{
			String a=input1.nextLine();
		    System.out.print(a);
		    
		}input1.close();
   }
	
} 
			
	
	
	
	


