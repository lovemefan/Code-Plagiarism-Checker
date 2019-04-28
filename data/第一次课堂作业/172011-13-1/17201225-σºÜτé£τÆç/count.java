package count;

import java.util.Scanner;

public class count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		System.out.println("The sum of the digits is " + (num%10 + (num/10%10) + (num/100%10)));
	}

}
