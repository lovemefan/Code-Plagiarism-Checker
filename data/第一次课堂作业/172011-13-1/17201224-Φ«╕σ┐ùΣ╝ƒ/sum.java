package work;
import java.util.Scanner;
public class sum {
	public static void main(String[] arg){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int a = input.nextInt();
		int b1 = a % 10;
		int b2 = a / 100;
		int b3 = (a/10)%10;
		int b = b1+b2+b3;
		System.out.println("The sum of the digits is:"+ b);
	}
}
