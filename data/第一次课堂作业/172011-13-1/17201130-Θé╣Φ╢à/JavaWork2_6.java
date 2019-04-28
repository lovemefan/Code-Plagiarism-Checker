package HomeWork;
import java.util.Scanner;
public class JavaWork2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 1000 :");
        int number = input.nextInt();
        int sum = number % 10 + number / 10 % 10 + number / 100 ;
        System.out.println("The sum of the digits is " + sum);
	}
}
