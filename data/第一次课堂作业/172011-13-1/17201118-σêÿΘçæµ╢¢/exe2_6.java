package test;
import java.util.Scanner;

public class exe2_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number between 0 and 1000: ");
		int i=input.nextInt();
		if (i<0||i>1000) {
			System.out.println("input error");
			return;
		}
		int k=0;
		while (i>0) {
			k+=i%10;
			i/=10;
		}
		System.out.println("The sum of the digits is "+k);
	}

}
