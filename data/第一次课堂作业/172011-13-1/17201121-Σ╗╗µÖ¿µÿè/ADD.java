package ADD;

import java.util.Scanner;

public class ADD {
	public static void main(String[] args){
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input = new Scanner(System.in);
		
		int i = input.nextInt();
		int a = i%10;
		int b = i/10%10;
		int c = i/100;
		int j = a+b+c;
		
		System.out.println("The sum of the digits is:"+j);
	}

}
