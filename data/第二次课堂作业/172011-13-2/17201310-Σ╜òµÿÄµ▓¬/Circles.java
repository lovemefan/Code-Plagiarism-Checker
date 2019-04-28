package test;

import java.util.Scanner;

public class Circles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter circle's center x-, y-coordinates, and radius: ");
		double circle1X = input.nextDouble();
		double circle1Y = input.nextDouble();
		double circle1Radius = input.nextDouble();

		System.out.print("Enter circle's center x-, y-coordinates, and radius: ");
		double circle2X = input.nextDouble();
		double circle2Y = input.nextDouble();
		double circle2Radius = input.nextDouble();

		double distance = Math.sqrt(Math.pow(circle2X - circle1X, 2) + Math.pow(circle2Y - circle1Y, 2));
		if (distance <= Math.abs(circle1Radius - circle2Radius)) {
			System.out.println("circle2 is inside circle1");
		}
		else if(distance <= circle1Radius + circle2Radius) {
			System.out.println("circle2 is overlaps circle1");
		}
		else
			System.out.println("circle2 does not overlap circle1");
			input.close();
	}
}
