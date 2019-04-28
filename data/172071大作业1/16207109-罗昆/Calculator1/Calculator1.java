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
	                continue;  //ȥ���ո�
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
				  String op = operate.pop();  //����һ��������
			        int op1 = num.pop();  //�Ӵ洢���ݵ�ջ�е������������������Ͳ�����op����
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
              operate.push(express.get(i));   //������֮�󽫵�ǰ���������ջ
          }
		  else if((express.get(i)).equals("*")||express.get(i).equals("/"))
		  {
			  while (!operate.isEmpty()&&(operate.peek() .equals( "*") ||operate.peek() .equals("/")))
			  {
				  String op = operate.pop();  //����һ��������
			        int op1 = num.pop();  //�Ӵ洢���ݵ�ջ�е������������������Ͳ�����op����
			        int op2 = num.pop();
			        if (op.equals("+"))  //���������Ϊ+��ִ�м�����
			        	num.push(op1 + op2);
			        else if (op.equals("-"))
			        	num.push(op2 - op1);   
			        else if (op.equals("*"))
			        	num.push(op1 * op2);
			        else if (op.equals("/"))
			        	num.push(op2 / op1);
              }
			  operate.push(express.get(i));   //����ǰ��������ջ
          }
		  else if ((express.get(i)).equals("(")) 
		  {
              operate.push("(");
          }
          //����������ŵĻ������ջ�е������ֱ��������
          else if ((express.get(i)).equals(")")) 
          {
              while (!(operate.peek()).equals("("))
              {
            	  String op = operate.pop();  //����һ��������
			        int op1 = num.pop();  //�Ӵ洢���ݵ�ջ�е������������������Ͳ�����op����
			        int op2 = num.pop();
			        if (op.equals("+"))  //���������Ϊ+��ִ�м�����
			        	num.push(op1 + op2);
			        else if (op.equals("-"))
			        	num.push(op2 - op1);   //��Ϊ�����ջ�Ľṹ����Ȼ������������Ǻ���ģ������op2-op1
			        else if (op.equals("*"))
			        	num.push(op1 * op2);
			        else if (op.equals("/"))
			        	num.push(op2 / op1);
              }
              operate.pop();   //�������������֮�����������
          }
        
         
         
      }
      //���ջ�в��ǿյ�ʱ��������㣬֪��ջ��Ϊ�ռ���
      while (!operate.isEmpty()) 
      {
    	  String op = operate.pop();  //����һ��������
	        int op1 = num.pop();  //�Ӵ洢���ݵ�ջ�е������������������Ͳ�����op����
	        int op2 = num.pop();
	        if (op.equals("+"))  //���������Ϊ+��ִ�м�����
	        	num.push(op1 + op2);
	        else if (op.equals("-"))
	        	num.push(op2 - op1);   //��Ϊ�����ջ�Ľṹ����Ȼ������������Ǻ���ģ������op2-op1
	        else if (op.equals("*"))
	        	num.push(op1 * op2);
	        else if (op.equals("/"))
	        	num.push(op2 / op1);
      }
     
		int result=num.pop();    //��ʱ����ջ�е����ݾ�������Ľ��
		System.out.println(result);
		
		
		
		java.io.File file=new java.io.File("arithmetic.txt");
		if(file.exists())
		{
			System.out.print("�ļ��ı������");
			
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
			
	
	
	
	


