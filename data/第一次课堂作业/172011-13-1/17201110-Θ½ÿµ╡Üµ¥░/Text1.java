package Text1;

import java.util.Scanner;

public class Text1 {
     public static void main(String args[]) {
    	 Scanner input = new Scanner(System.in);
    	   System.out.println("Enter a integer number between 0 and 1000");
    	   int number = input.nextInt();
    	    while (number < 0 || number >1000 ) {
    	      System.out.println("The number is illegal");
    	    	number = input.nextInt();
    	    }
    	            int a = number % 10;
    	            int b = ( number / 10 ) % 10;
    	            int c = ( number / 100 ) % 10;
    	            int d = ( number / 1000 ) % 10;
    	            int total = a + b + c + d;  
    	           System.out.println("The sum of the digits is :"+ total);     	    	 
    	    } 
  }