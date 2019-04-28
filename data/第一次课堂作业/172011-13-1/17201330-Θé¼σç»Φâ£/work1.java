package lab1;

import java.util.Scanner;

public class work1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number between 0 and 1000:");
		int number = input.nextInt();
		int number1 = number % 10;
		int remainder = number / 10;
		int number2 = remainder / 10;
		int number3 = remainder % 10;
		int sum = number1 + number2 + number3;
		System.out.println("The sum of the digits is " + sum);
		
	}

}
