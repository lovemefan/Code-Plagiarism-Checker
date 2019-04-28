package math;

import java.util.Scanner;

public class Math {
	public static void main(String[] args){
		int i , j;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000 :");
		i = input.nextInt();
		if(i / 100 >= 10)
			System.out.println("The number is big than 1000");
		else{
			j = i / 100 + i % 10 + i / 10 % 10;
			System.out.println("The sun of the digits is " + j);
		}
	}
}
