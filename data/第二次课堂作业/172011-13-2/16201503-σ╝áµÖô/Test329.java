package test1013;

import java.util.Scanner;

public class Test329 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

	    
	    double x1 = input.nextDouble();
	    double y1 = input.nextDouble();
	    double r1 = input.nextDouble();
	    System.out.print("Enter circle1's center x-, y-coordinates, and radius:");

	    
	    double x2 = input.nextDouble();
	    double y2 = input.nextDouble();
	    double r2 = input.nextDouble();
	    System.out.print("Enter circle2's center x-, y-coordinates, and radius:");

	    double temp = Math.pow((x1 - x2), 2) + Math.pow((y2 - y1), 2);
	    double distance = Math.pow(temp, 0.5);

	    if (distance <= Math.abs(r1 - r2))
	        System.out.println("circle2 is inside circle1");
	    else if (distance <= (r1 + r2))
	        System.out.println("circle2 overlaps circle1");
	    else
	        System.out.println("circle2 does not overlap circle1");


	}

}
