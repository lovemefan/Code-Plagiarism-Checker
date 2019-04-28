package SumoftheDigits;

import java.util.Scanner;

public class SumoftheDigits {
	public static void main(String[] args){
		int m,x,y,z,sum;
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		x = m/100;
		y = m%100/10;
		z = m%10;
		sum = x+y+z;
		System.out.println("The sum of the digits is " +sum);
	}

}
