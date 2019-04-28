package assignments1;

import java.util.Scanner;

public class work3_1 {
	public static void main(String[] args){
		System.out.println("Enter a, b, c:");
		Scanner input = new Scanner(System.in);
		double a,b,c,r1,r2;
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		r1 = (-b+Math.pow((b*b-4*a*c),0.5))/(2*a);
		r2 = (-b-Math.pow((b*b-4*a*c),0.5))/(2*a);
		System.out.println("The equation has two roots "+r1+" and "+r2);
	}
}
