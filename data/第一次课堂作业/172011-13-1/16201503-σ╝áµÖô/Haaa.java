package summation;

import java.util.Scanner;

public class Haaa {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		System.out.print("Enter x2 and y2:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double a=x2-x1;
		double b=y2-y1;
		double c=Math.pow(a, 2)+Math.pow(b, 2);
		double distance=Math.pow(c, 0.5); 
		System.out.print("The distance between the two points is"+distance);
	}

}
