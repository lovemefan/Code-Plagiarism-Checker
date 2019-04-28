package demo;

import java.util.Scanner;

public class Digital 
{
	public static void main(String[] args)
	{
		int a = 0;
		System.out.println("Please enter a number between 0 and 1000:");
		Scanner input =new Scanner(System.in);
		a = input.nextInt();
		int b = a/100+a/10%10+a%10;
		System.out.println("the sum of the digits is :"+ b);
	}
}
