import java.util.Scanner;

public class HomeWorkOne {
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int i = 0;
		int sum = 0;
		System.out.println("Enter a number between 0 and 1000:");
		i = input.nextInt();
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		
		System.out.println("The sum of the digits is " + sum);
	}
}

