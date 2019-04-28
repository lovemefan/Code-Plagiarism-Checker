package distancePoints;

import java.util.Scanner;
public class DistancePoints {
	public static void main(String[] args){
		double x1,y1,x2,y2;
		System.out.println("Enter x1 and y1:");
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		double d = Math.pow(Math.pow(x2 - x1, 2)+Math.pow(y2 - y1, 2), 0.5);
		System.out.println("The distance between the two point is "+d);
		
	}

}
