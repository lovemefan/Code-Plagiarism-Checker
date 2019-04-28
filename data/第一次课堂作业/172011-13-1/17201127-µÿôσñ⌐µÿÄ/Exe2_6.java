import java.util.Scanner;

public class Exe2_6 {
	public static void main(String[] args) {
		//Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter a number
		System.out.print("Enter a number between 0 and 1000: ");
		int number = input.nextInt();
		
		int a = number / 100;
		int b = number / 10 % 10;
		int c = number % 10;
		
		int sum = a + b + c;
		
		System.out.println("The sum of the digits is " + sum);
		
	}
}
