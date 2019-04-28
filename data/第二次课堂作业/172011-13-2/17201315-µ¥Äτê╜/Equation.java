package Equation;//3.1

import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a,b,c ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		if ((Math.pow(b,2)-4*a*c)>0) {
			double r1 = (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
			double r2 = (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
			System.out.println("The equation has two roots " + r1 + " and " +r2 );
		}
		else if (Math.pow(b,2)-4*a*c==0) {
			double r = -b/(2*a);
			System.out.println("The equation has one roots " + r);
		}
		else if (Math.pow(b,2)-4*a*c<0) {
			System.out.println("The equation has no  real roots ");
		}
		if (input != null) {
			input.close();
		}
	}
}
