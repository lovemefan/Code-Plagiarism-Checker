package summation;

import java.util.Scanner;

public class Ha {
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int a,v1,v2,v3,sum;
	      a = input.nextInt();
	      v1=a%1000/100;
	      v2=a%100/10;
	      v3=a%10;
	      sum=v1+v2+v3;
        System.out.print(" The sum of the digits is"+sum);
		
	}

}
