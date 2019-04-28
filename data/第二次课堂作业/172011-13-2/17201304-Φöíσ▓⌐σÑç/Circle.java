package circle;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter x1");
		double x1 = input.nextDouble();
		System.out.println("Please enter y1");
		double y1 = input.nextDouble();
		System.out.println("Please enter radius1");
		double r1 = input.nextDouble();
		System.out.println("Please enter x2");
		double x2 = input.nextDouble();
		System.out.println("Please enter y2");
		double y2 = input.nextDouble();
		System.out.println("Please enter radius2");
		double r2 = input.nextDouble();
		
		double l = Math.pow(Math.pow(x1 - x2,2) + Math.pow(y1 - y2, 2), 0.5);
		if (l <= Math.abs(r1-r2))
			System.out.println("circle2 is inside circle1");
		else if (l <= r1+r2)
			System.out.println("circle2 overlaps circle1");
		else 
			System.out.println("circle2 dose not overlap circle1");
	}
}
