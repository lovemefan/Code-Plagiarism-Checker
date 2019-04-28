package test;

import java.util.Scanner;

public class one {
  public static void main(String[] args){
	  Scanner input=new Scanner(System.in);
	  System.out.print("Enter a number between 0 and 1000:");
	  int number=input.nextInt();
	  int number1=number/100;
	  int number2=(number/10)%10;
	  int number3=number%10;
	  int sum=number1+number2+number3;
	  System.out.println("The sum of the didits is "+sum);
	  
  }
}
