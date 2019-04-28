package sum;

import java.util.Scanner;

public class Area {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double l1 = Math.pow((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1), 0.5);
		double l2 = Math.pow((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1), 0.5);
		double l3 = Math.pow((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2), 0.5);
		double s = (l1+l2+l3)/2;
		double area = Math.pow(s*(s-l1)*(s-l2)*(s-l3),0.5);
		System.out.println("The area of the triangle is " + area);
	}
	
}
