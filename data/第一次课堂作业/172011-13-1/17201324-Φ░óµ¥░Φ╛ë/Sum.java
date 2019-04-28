package text;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a number between 0 and 1000:");
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		System.out.println("The sum of the digits is "+(a/100+a%10+a%100/10));

	}

}
