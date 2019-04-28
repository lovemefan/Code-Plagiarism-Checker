package sum;

import java.util.Scanner;

public class Sum {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000: ");
		double num = input.nextDouble();
		int bai = (int) (num/100);
		int shi = (int) ((num/10)%10);
		int ge = (int) (num%10);
		int sum = bai + shi + ge;
		System.out.println("The sum of the digits is " + sum);
	}

}
