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
				System.out.print("请输入需要计算表达式的数量 ");
				int num = input.nextInt();
				for(int i=0;i<num;i++) {
					
				
		        System.out.print("请输入需要计算的算式: ");
		        String equation = s.nextLine();
		        
		        output.print(equation);
		        output.println("=" +count.result(equation));
		        wrongWarning(equation);
		        System.out.println("计算结果为: " + equation +  "=" + count.result(equation));
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
		                if (isOperator(results.get(i))) //判断是否为运算符
		                {
		                    results.add(i - 2, twoOperators(results.get(i - 2), results.get(i - 1), 
		                    		results.get(i)));//List下的add方法,将指定的项目添加到由索引指示的位置的滚动列表中。
		                    results.remove(i-1);//List下的remove方法,从列表中删除项目
		                    results.remove(i-1);//添加了几个元素就删除几个
		                    results.remove(i-1);
		                    break;
		                }
		            }
		        }
		        return results.get(0);
		    }

		    
		    
		    
		    
		    private String twoOperators(String operator1, String operator2, String op)//两个数的加减乘除
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

            
            
		    public boolean determinePriority(char first, char second) //判断优先级
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
		    	 
		    	 System.out.println("ERROR #表达式中有空括号");
		    	if( expression.matches(".*[^\\d+-/*\\(\\)].*"))	    	
		    	 System.out.println("ERROR #表达式包含非法字符");
		    	if( expression.matches(""))		    	
		    	 System.out.println("ERROR #表达式中括号不匹配");
		    	 if(expression.matches(".*[+-/*][+-/*].*"))
		    	 System.out.println("ERROR #表达式中运算符连续");
		    	if( expression.matches("^[+-/*].*|.*\\([+-/*].*"))
		    	 System.out.println("ERROR #表达式中运算符前无运算数");
		    	 if(expression.matches(".*[+-/*]$|.*[+-/*]\\).*"))
		    	 System.out.println("ERROR #表达式中运算符后无运算数");
		    	if( expression.matches(".*\\d\\(.*"))
		    	 System.out.println("ERROR #表达式中括号非第一个字符且之前无运算数");
		    	if( expression.matches(".*\\)\\d.*"	))
		    	 System.out.println("ERROR #表达式中小括号后无运算数，括号非最后一个字符");


		    }
}

