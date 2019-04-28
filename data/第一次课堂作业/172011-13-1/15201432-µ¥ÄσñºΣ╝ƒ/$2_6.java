import java.util.Scanner;

public class $2_6 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number between 0 and 1000:");
		
		int number = input.nextInt();
		int one = number % 10;
		int ten = (number / 10) % 10;
		int hundred = (number / 100 ) % 10;
		int sum = one + ten + hundred;
		System.out.println("The sum of the digits is " + sum);
		
		if (input !=null){
			input.close();
		}
		
	}
}
