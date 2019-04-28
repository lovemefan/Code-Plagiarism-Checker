import java.util.Scanner;

public class TwoCircles {
	public static void main(String[] args){
		double distance = 0, x = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x-,y-coordinates,and radius: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double radius1 = input.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates,and radius: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double radius2 = input.nextDouble();
		distance = Math.pow((Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)), 0.5);
		x = Math.abs(radius1 - radius2);
		if (distance <= x)
			System.out.println("circle2 is inside circle1");
	    else if (distance <= (radius1+radius2) )
	    	System.out.println("circle2 is overlaps circle1");
	    else
	    	System.out.println("circle2 does not overlaps circle1");
	}

}
