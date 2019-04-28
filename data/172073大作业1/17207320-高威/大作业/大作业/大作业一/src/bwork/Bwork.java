package bwork;

import java.io.FileNotFoundException;
import java.util.*;

public class Bwork
{

		    public static void main(String[] args) throws FileNotFoundException
		    {
		    	Scanner input = new Scanner(System.in);
		    	java.io.File file = new java.io.File("expression.txt");
		    	if(file.exists()) {
		    		System.out.println("File alredy exists");
		    		
		    	}
		    	java.io.PrintWriter output = new java.io.PrintWriter(file);
		        Bwork count = new Bwork();
				Scanner s = new Scanner(System.in);
				System.out.print("��������Ҫ������ʽ������ ");
				int num = input.nextInt();
				for(int i=0;i<num;i++) {
					
				
		        System.out.print("��������Ҫ�������ʽ: ");
		        String equation = s.nextLine();
		        
		        output.print(equation);
		        output.println("=" +count.result(equation));
		        wrongWarning(equation);
		        System.out.println("������Ϊ: " + equation +  "=" + count.result(equation));
				}

		        output.close();
		        s.close();
		        
		    }
		
		  
		    
		    
		    private String result(String expression)
		    {
		        List<String> results = middleToBehind(expression);
		        while (results.size() > 1) 
		        {
		            for (int i = 0; i < results.size(); i++) 
		            {
		                if (isOperator(results.get(i))) //�ж��Ƿ�Ϊ�����
		                {
		                    results.add(i - 2, twoOperators(results.get(i - 2), results.get(i - 1), 
		                    		results.get(i)));//List�µ�add����,��ָ������Ŀ��ӵ�������ָʾ��λ�õĹ����б��С�
		                    results.remove(i-1);//List�µ�remove����,���б���ɾ����Ŀ
		                    results.remove(i-1);//����˼���Ԫ�ؾ�ɾ������
		                    results.remove(i-1);
		                    break;
		                }
		            }
		        }
		        return results.get(0);
		    }

		    
		    
		    
		    
		    private String twoOperators(String operator1, String operator2, String op)//�������ļӼ��˳�
		    {
		        String result = "";
		        int op1 = Integer.parseInt(operator1);
		        int op2 = Integer.parseInt(operator2);
		        int count = 0;
		        if(op.equals("+"))
		        {
		            count=op1+op2;
		        }
		        else if(op.equals("-"))
		        {
		            count=op1-op2;
		        }
		        else if(op.equals("*"))
		        {
		            count=op1*op2;
		        }
		        else if(op.equals("/"))
		        {
		            count=op1/op2;
		        }
		        return result+count;
		    }

		     
		    
		    
		    private boolean isOperator(String s)
		    {
		        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
		        {
		        	return true;
		        }
		        else
		        {
		        	return false;
		        }
		    }

		   
		    
		    

            public List<String> middleToBehind(String expression) 
		    {
		        List<String> result = new ArrayList<String>();
		        if (expression.length() == 0)
		        {
		        	return result;
		        }
		        int begin = 0;
		        char[] operator = new char[100];
		        int oTop = -1;
		        while (begin < expression.length())
		        {
		            String now = "";
		            if (expression.charAt(begin) <= '9' && expression.charAt(begin) >= '0')
		            {
		                while (true) 
		                {
		                    if (begin < expression.length() && expression.charAt(begin) <= '9'
		                            && expression.charAt(begin) >= '0')
		                    {
		                        now = now + expression.charAt(begin++);
		                    } 
		                    else 
		                    {
		                        break;
		                    }
		                }
		                result.add(now);
		            } 
		            else
		            {
		                char o = expression.charAt(begin++);
		                if (oTop == -1) 
		                {
		                    operator[++oTop] = o;
		                } 
		                else if (o == ')') 
		                {
		                    while (true)
		                    {
		                        if (operator[oTop] == '(')
		                        {
		                            oTop--;
		                            break;
		                        } else {
		                            result.add("" + operator[oTop--]);
		                        }
		                    }
		                } 
		                else if (determinePriority(operator[oTop], o)) 
		                {
		                    result.add("" + operator[oTop--]);
		                    operator[++oTop] = o;
		                } 
		                else
		                {
		                    operator[++oTop] = o;
		                }
		            }
		        }
		        while (oTop > -1)
		        {
		            result.add("" + operator[oTop--]);
		        }
		        return result;
		    }

            
            
		    public boolean determinePriority(char first, char second) //�ж����ȼ�
		    {
		        if (first == '+') 
		        {
		            if (second == '+')
		                return true;
		            else if (second == '-')
		                return true;
		            else if (second == '*')
		                return false;
		            else if (second == '/')
		                return false;
		            else if (second == '(')
		                return false;
		            else if (second == ')')
		                return true;
		        }
		        else if (first == '-') 
		        {
		            if (second == '+')
		                return true;
		            else if (second == '-')
		                return true;
		            else if (second == '*')
		                return false;
		            else if (second == '/')
		                return false;
		            else if (second == '(')
		                return false;
		            else if (second == ')')
		                return true;
		        } 
		        else if (first == '*') 
		        {
		            if (second == '+')
		                return true;
		            else if (second == '-')
		                return true;
		            else if (second == '*')
		                return true;
		            else if (second == '/')
		                return true;
		            else if (second == '(')
		                return false;
		            else if (second == ')')
		                return true;
		        }
		        else if (first == '/') 
		        {
		            if (second == '+')
		                return true;
		            else if (second == '-')
		                return true;
		            else if (second == '*')
		                return true;
		            else if (second == '/')
		                return true;
		            else if (second == '(')
		                return false;
		            else if (second == ')')
		                return true;
		        } 
		        else if (first == '(') 
		        {
		            if (second == '+')
		                return false;
		            else if (second == '-')
		                return false;
		            else if (second == '*')
		                return false;
		            else if (second == '/')
		                return false;
		            else if (second == '(')
		                return false;
		            else if (second == ')')
		                return true;
		        }
		        else if (first == ')') 
		        {
		            return true;
		        }
		        return false;
		    }
		    public static void wrongWarning(String expression) {
		    	
		    	if(expression.matches(".*\\(\\).*"))
		    	 
		    	 System.out.println("ERROR #���ʽ���п�����");
		    	if( expression.matches(".*[^\\d+-/*\\(\\)].*"))	    	
		    	 System.out.println("ERROR #���ʽ�����Ƿ��ַ�");
		    	if( expression.matches(""))		    	
		    	 System.out.println("ERROR #���ʽ�����Ų�ƥ��");
		    	 if(expression.matches(".*[+-/*][+-/*].*"))
		    	 System.out.println("ERROR #���ʽ�����������");
		    	if( expression.matches("^[+-/*].*|.*\\([+-/*].*"))
		    	 System.out.println("ERROR #���ʽ�������ǰ��������");
		    	 if(expression.matches(".*[+-/*]$|.*[+-/*]\\).*"))
		    	 System.out.println("ERROR #���ʽ�����������������");
		    	if( expression.matches(".*\\d\\(.*"))
		    	 System.out.println("ERROR #���ʽ�����ŷǵ�һ���ַ���֮ǰ��������");
		    	if( expression.matches(".*\\)\\d.*"	))
		    	 System.out.println("ERROR #���ʽ��С���ź��������������ŷ����һ���ַ�");


		    }
}

