import java.util.Scanner;

public class DistanceOfPoints {
	
	public static void main(String[] args) {
		System.out.print("Enter x1 and y1,e.g.1 2:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.print("Enter x2 and y2,e.g.1 2:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		System.out.println("The distance between the two points is " + distance);
	}
	
}
