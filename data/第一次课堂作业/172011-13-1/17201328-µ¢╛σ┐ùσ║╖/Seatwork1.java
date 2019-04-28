import java.util.Scanner;

public class Seatwork1 {
	public static void main(String[] args) {
		System.out.println("Please enter a number between 0 and 1000 :");
		Scanner input = new Scanner(System.in);
		int a = 0,b = 0,c = 0,d = 0,e = 0;
		a = input.nextInt();
		while (a > 1000 || a < 1) {
			System.out.println("Error!");
			a = input.nextInt();
		}
		b = a % 10;
		c = (a / 10) % 10;
		d = (a / 100) % 10;
		e = (a /1000) % 10;
		int sum = 0;
		sum = b + c + d + e;
		System.out.println("The sum of digits is :" + sum);
	}
}
