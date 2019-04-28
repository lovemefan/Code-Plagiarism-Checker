import java.util.Scanner;

public class ComputeDigits {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int a = input.nextInt();
		int b = a / 100;
		int c = a % 10;
		int d = a / 10 % 10;
		int e = b + c + d;
		System.out.println("The Sum of the digits is" + e);
	}

}
