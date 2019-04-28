package dmz;
import java.util.Scanner;
public class Problem2_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int digits = 0;
		boolean Input = false;
		while (!Input) {
		System.out.print("Enter the number between 0 and 1000 : ");
		int number = input.nextInt();
		if(0 < number && number <10) {
			digits = number;
			Input = Output(digits);
		}
		else if(10 <= number && number < 99) {
			digits = number%10 + (number/10)%10;
			Input = Output(digits);
		}
		else if(100 <= number && number < 1000) {
			digits = number%10 + (number/10)%10 + (number/100)%10;
			Input = Output(digits);
		}
		else {
			System.out.println("Input error!\nPlease resume load!");
		}
		}
	}
	public static boolean Output(int digits) {
		System.out.println("The sum of the digits is " + digits);
		return true;
	}
}
