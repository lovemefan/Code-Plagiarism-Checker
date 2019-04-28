import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000 :");
		int number = input.nextInt();
		int unit = number % 10;
		int decade = number % 100 / 10;
		int hundreds = number / 100;
		System.out.println("The sum of the digits is " + (unit + decade + hundreds));
	}

}
