package exercise;
import java.util.Scanner;

public class Exercise_2_6 {
	public static void main(String[] args) {
		int  num,sum = 0,k;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number(0-1000):");
		k = num = in.nextInt();
		while ( num < 0 || num > 1000) {
			System.out.println("Invalid number!");
			System.out.println("Please enter a number (0-1000) again:");
			k = num = in.nextInt();
		}
		while(k / 10 > 0) {
			sum = sum + (k % 10);
			k = k / 10;
		}
		sum = sum + k;
		System.out.println("The result is :" + sum);
		
	}
}
