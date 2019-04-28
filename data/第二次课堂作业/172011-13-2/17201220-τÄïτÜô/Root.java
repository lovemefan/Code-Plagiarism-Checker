package testtwo;

import java.util.Scanner;

public class Root {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double pan = b*b - 4*a*c;
		if (pan>0){
			double r1 = (-b + Math.pow(pan, 0.5))/(2*a);
			double r2 = (-b - Math.pow(pan, 0.5))/(2*a);
			System.out.println("The equation has two roots " + r1 +" and " + r2);
		}
		else if (pan==0){
			double r = (-b + Math.pow(pan, 0.5))/(2*a);
			System.out.println("The equation has one root " + r);
		}
		else 
			System.out.println("The equation has no real roots ");
	}

}
