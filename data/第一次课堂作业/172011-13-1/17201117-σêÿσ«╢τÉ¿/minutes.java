package demo;

import java.util.Scanner;

public class minutes 
{
	public static void main(String[] args)
	{
		int a = 0;
		System.out.println("Please enter the number of minutes:");
		Scanner input =new Scanner(System.in);
		a = input.nextInt();
		int b = a/60/24/365;
		int c = a/60/24%365;
		System.out.println(+ a +"minutes is approximately "+ b + "years and "+ c +" 100days");
	}
	
}
