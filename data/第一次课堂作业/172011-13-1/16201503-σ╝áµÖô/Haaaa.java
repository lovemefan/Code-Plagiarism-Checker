package summation;

import java.util.Scanner;

public class Haaaa {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		System.out.print("Enter x1 and y1:");
		System.out.print("Enter x2 and y2:");
		System.out.print("Enter x3 and y3:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double s1 = Math.pow(Math.pow((x2 - x1), 2) + Math.pow((y2 -y1), 2), 0.5);
        double s2 = Math.pow(Math.pow((x3 - x2), 2) + Math.pow((y3 -y2), 2), 0.5);
        double s3 = Math.pow(Math.pow((x3 -x1), 2) + Math.pow((y3 -y1), 2), 0.5);
        double s4=(s1+s2+s3)/2;
        double area=Math.pow(s4*(s4-s1)*(s4-s2)*(s4-s3), 0.5);
        System.out.print("The area of the triangle is"+area);}


		
}
