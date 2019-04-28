package helloworld;
import java.util.*;

public class classwork2_6{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int number = input.nextInt();
		
		int a = number%10;
		int b = (number/10)%10;
		int c = (number/100)%10;
		int sum = a+b+c;
		System.out.println("The sum of the digits is"+sum);
	}
}