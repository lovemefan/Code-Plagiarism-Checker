package Solve;

import java.util.Scanner;
public class Solve {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x1=0;
		double x2=0;
		System.out.print("Enter a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double judge = Math.pow(b, 2)-4*a*c;
		if(judge > 0) {
			x1 = (-b + Math.sqrt(judge))/2*a;
			x2 = (-b - Math.sqrt(judge))/2*a;
			System.out.println("The equation has two roots " + x1 + " and "+x2);
		}
		else if(judge == 0) {
			x1 = x2 = (-b + Math.sqrt(judge))/2*a;
			System.out.println("The equation has one roots " + x1 );
		}
		else {
			System.out.println("The equation has no real roots");
		}
	}

}
