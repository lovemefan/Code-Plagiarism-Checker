package HomeWork;
import java.util.Scanner;

public class First2_6 {
	public static void main(String[] args) {
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input =new Scanner(System.in);
		int r=input.nextInt();
		int sum=r / 100 + r % 100 / 10 + r % 10;
		System.out.println("The sum of the digits is "+sum);
	}

}
