package zy;

import java.util.Scanner;

public class _2_6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int a = input.nextInt();
		int g,s,b,q,z = a;
		q = z / 1000;
		z = z - q * 1000;
		b = z / 100;
		z = z - b * 100;
		s = z / 10;
		g = z - s * 10;
		int add = g + s + b + q;
		System.out.print("The sum of digits is "+ add);
	}

}
