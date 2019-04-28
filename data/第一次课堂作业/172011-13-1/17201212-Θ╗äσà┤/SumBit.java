package work;

import java.util.Scanner;

public class SumBit {
	public static void main(String[] args){
		System.out.println("Enter a number between 0 and 1000: ");
		Scanner input = new Scanner(System.in);	
		int number = input.nextInt();
		int sumdigits = number%10+(number/10)%10+(number/100)%10+(number/1000)%10;
		System.out.println("The sum of the digits is "+sumdigits);
				
	}

}
