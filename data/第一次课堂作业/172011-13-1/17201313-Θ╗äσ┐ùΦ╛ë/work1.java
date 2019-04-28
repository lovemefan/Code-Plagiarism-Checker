package classwork;
import java.util.Scanner;

public class work1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an integer between 0 and 1000:");
		int number = input.nextInt();
		int one = number % 10;
		int number2 = number / 10;
		int ten = number2 % 10;
		int hundred = number2 / 10;
		int add = one + ten + hundred;
		System.out.println("The sum of figures is" + add);
	}

}
