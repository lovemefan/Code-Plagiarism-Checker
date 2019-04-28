package firstQuestion;

import java.util.Scanner;
public class Firstquestion {
	public static void main(String[] args){
		int num=0; 
		int i=0;
		System.out.println("please enter whole number between 0 and 1000 :");
   	    Scanner input =new Scanner(System.in);
   	    num=input.nextInt();
   	    i=num%10+i;
   	    num=num/10;
   	    i=num%10+i;
   	    num=num/10;
   	    i=num+i;
   	    System.out.println("the sum of the digits is:"+i);
   	    input.close();

	}
}
	
