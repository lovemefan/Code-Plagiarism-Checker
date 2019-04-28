import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x-, y-coordinates, and radius:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.println("Enter circle2's centr x-, y-coordinates, and radius:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
	    if ((distance <= Math.abs(r1 - r2)))
	    	System.out.println("circle2 is inside circle1");
	    else if ((distance <= r1 + r2))
	    	System.out.println("circle2 overlaps circle1");
	    else 
	    	System.out.println("circle2 does not overlaps circle1");
	    input.close();
			
			
		

	}

}
