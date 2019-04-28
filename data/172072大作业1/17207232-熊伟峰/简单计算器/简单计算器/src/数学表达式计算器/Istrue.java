package 数学表达式计算器;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Istrue {

	public static boolean isTrue(String expression) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("test2.txt");
		FileOutputStream filewrite = new FileOutputStream("test2.txt", true);
		
		Scanner input = new Scanner(file);
		
		boolean b = false;
		
		if(expression.isEmpty())
		{
			return false;
		}
		
		/*if(first(expression) && second(expression) && third(expression) && four(expression) &&
			five(expression) && six(expression) && seven(expression) && eight(expression) && nine(expression))	
		{
			b = true;
		}*/
		
		if(!(first(expression) && second(expression) && third(expression)))
		{
			return false;
		}
		
		if(!(four(expression) && five(expression) && six(expression)))
		{
				return false;
		}
		
		if(!(seven(expression) && eight(expression) && nine(expression)))
		{
			return false;
		}
		
		return true;
		
	}
	
	  public static boolean first(String expression)
	  {
		  	String reg = "(\\(\\))";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(expression);
			boolean book = true;
			while(m.find())
			{
				book = false;
			}
			
			
			if(!book)
			{
				System.out.println(expression+"\n"+"ERROR"+"\n"+"#表达式中有空括号");	
			}
			
			return book;
	  }
	  
	  public static boolean second(String expression)
	  {
		 
		  boolean book = true ;
		  
		  book =expression.matches( "([0-9+\\-*/()\\s]+)");
		
		
		  if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#表达式包括非法字符");
			  
		  }
		  
		  return book;
			
	  }
	  
	  public static boolean third(String expression)
	  {
		  int leftcount = 0, rightcount = 0;
		  char[] str = expression.toCharArray();
		  for(int i=0;i<str.length;i++)
		  {
			  if(str[i] == '(')
				  leftcount++;
			  else
				  if(str[i] == ')')
				  {
					  rightcount++;
				  }
		  }
		  if(leftcount == rightcount)
			  return true;
		  else
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#括号不匹配");
			  return false;
		  }
	  }
	  
	  public static boolean four(String expression)
	  {
		  Pattern op = Pattern.compile("[\\+\\-\\*\\/]{2,}");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#运算符连续");
			  
		  }
		 return book;
	  }
	  
	  public static boolean five(String expression)
	  {
		  Pattern op = Pattern.compile("^[\\+\\-\\*\\/]");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#运算符前无运算数");
			  
		  }
		 return book;
	  }
	 
	public static boolean six(String expression)
	  {
		  Pattern op = Pattern.compile("[\\+\\-\\*\\/]$");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#运算符后无运算数");
			  
		  }
		 return book;
	  }
	  
	  public static boolean seven(String expression)
	  {
		  Pattern op = Pattern.compile("^[\\+\\-\\*\\/]$");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#运算符后无运算数");
			  
		  }
		 return book;
	  }
	  
	  public static boolean eight(String expression)
	  {
		  Pattern op = Pattern.compile("\\d\\(");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#括号非第一个字符且之前无运算数");
			  
		  }
		 return book;
	  }
	  
	  public static boolean nine(String expression)
	  {
		  Pattern op = Pattern.compile("\\)\\d");
		  Matcher m = op.matcher(expression);
		  
		  boolean book = true;
		  
		 while(m.find())
		 {
			book = false;
		 } 
		 
		 if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#小括号后无运算数，括号非最后一个字符");
			  
		  }
		 return book;
	  }
	  
}