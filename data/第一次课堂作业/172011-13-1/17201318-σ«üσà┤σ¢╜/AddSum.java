package work_one;

import java.util.Scanner;

public class AddSum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000: ");
		int number = input.nextInt();
		while(number<0||number>1000){
			System.out.print("Incorrect input.Please re-enter: ");
			number = input.nextInt();
		}
		int sum = 0;
		while(number != 0){
		    sum += number % 10;
			number = number / 10;
		}
		System.out.println("The sum of the digits is " + sum);
		if (input != null){
			input.close();
		}
	}
}
