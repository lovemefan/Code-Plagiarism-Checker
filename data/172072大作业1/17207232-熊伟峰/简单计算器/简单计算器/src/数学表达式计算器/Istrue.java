package ��ѧ���ʽ������;

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
				System.out.println(expression+"\n"+"ERROR"+"\n"+"#���ʽ���п�����");	
			}
			
			return book;
	  }
	  
	  public static boolean second(String expression)
	  {
		 
		  boolean book = true ;
		  
		  book =expression.matches( "([0-9+\\-*/()\\s]+)");
		
		
		  if(!book)
		  {
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���ʽ�����Ƿ��ַ�");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���Ų�ƥ��");
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���������");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#�����ǰ��������");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���������������");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���������������");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#���ŷǵ�һ���ַ���֮ǰ��������");
			  
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
			  System.out.println(expression+"\n"+"ERROR"+"\n"+"#С���ź��������������ŷ����һ���ַ�");
			  
		  }
		 return book;
	  }
	  
}