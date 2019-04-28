import java.util.Scanner;

public class Sum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		int hundreds = num / 100;
		int ten = num % 100 / 10;
		int one = num % 10;
		System.out.println("The sum of digits is " + (hundreds + ten + one));
	}

}
