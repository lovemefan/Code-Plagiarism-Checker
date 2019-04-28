package lab2;

import java.util.Scanner;

public class Woek3_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double discriminant = Math.pow(b * b-4 * a * c , 0.5);
		if (discriminant > 0) {
			double root1 = (- b + discriminant) / 2 * a;
			double root2 = (- b - discriminant) / 2 * a;
			System.out.println("The equation has two roots " +
			root1 + " and " + root2);
		}
		else if (discriminant == 0) {
			double root = - b / 2 * a * c;
			System.out.println("The equation has one root " + root);
		}
		else {
			System.out.println("The equation has no real roots");
		}

	}

}
