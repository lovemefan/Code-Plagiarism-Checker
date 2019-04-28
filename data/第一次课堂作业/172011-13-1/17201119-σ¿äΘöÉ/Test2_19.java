package Test2_19_;

import java.util.Scanner;

public class Test2_19 {
	public static void main(String[] args){
		double x1 = 0, x2 = 0, x3 = 0;
		double y1 = 0, y2 = 0, y3 = 0;
		double s = 0,area = 0;
		System.out.println("Enter three points for a triangle:");
		Scanner a = new Scanner(System.in);
		x1 =a.nextDouble();
		y1 =a.nextDouble();
		x2 =a.nextDouble();
		y2 =a.nextDouble();
		x3 =a.nextDouble();
		y3 =a.nextDouble();
		double side1 = 0,side2 = 0,side3 = 0;
		side1 = Math.pow((Math.pow((x1-x2),2) + Math.pow((y1-y2), 2)),0.5);
		side2 = Math.pow((Math.pow((x1-x3),2) + Math.pow((y1-y3), 2)),0.5);
		side3 = Math.pow((Math.pow((x3-x2),2) + Math.pow((y3-y2), 2)),0.5);
		s =(side1 + side2 + side3 ) / 2;
		area = Math.pow((s * (s-side1) * (s - side2) * (s - side3)),0.5);
		area = ((int)(area*100)/100.0);
		System.out.println("The area of the triangle is:" + area);
	}

}
