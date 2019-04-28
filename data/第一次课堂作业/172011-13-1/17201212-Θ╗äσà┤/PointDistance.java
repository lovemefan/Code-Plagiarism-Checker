package work;

import java.util.Scanner;

public class PointDistance {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter x1 and y1: ");
		float x1 = input.nextFloat();
		float y1 = input.nextFloat();
		System.out.println("Enter x2 and y2: ");
		float x2 = input.nextFloat();
		float y2 = input.nextFloat();
		double distance = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
		System.out.println("The distance between the two points is "+distance);
	}

}
