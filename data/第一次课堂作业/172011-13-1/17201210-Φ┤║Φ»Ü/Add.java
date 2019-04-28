package add;

import java.util.Scanner;

public class Add {
	public static void main(String[] args){
		int a,b,c,d;
		int sum;
		
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input = new Scanner(System.in);
		a=input.nextInt();
		b=a%10;
		c=a/10%10;
		d=a/100%10;
		sum=b+c+d;
		System.out.println("The sum of the digits is :"+sum);
	}

}
