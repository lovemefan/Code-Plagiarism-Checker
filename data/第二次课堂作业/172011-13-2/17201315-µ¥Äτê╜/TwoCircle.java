package TwoCircle;//3.29

import java.util.Scanner;

public class TwoCircle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x1, y1coordinates, and radius:  ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.println("Enter circle2's center x2, y2coordinates, and radius: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		double distance = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
		if ( distance <= Math.abs(r1-r2)) {
			System.out.println("circle2 is inside circle2");
		}
		else if ( distance <= (r1 + r2)) {
			System.out.println("circle2 is overlaps circle2");
		}
		else if ( distance > (r1 + r2)) {
			System.out.println("circle2 is not overlaps circle2");
		}
		if(input != null) {
			input.close();
		}
	}
}
