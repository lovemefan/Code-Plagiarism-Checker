/*
 * File:Question2_19.java
 * Description:calculate the area of triangle
 * Programmer:ChenChao
 * Date:10/11/18
 */

import java.util.Scanner;

public class Question2_19 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x1,y1,x2,y2,x3,y3;
		System.out.print("Enter three points for a triangle:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		double s,area;
		double distance1 = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		double distance2 = Math.pow(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2), 0.5);
		double distance3 = Math.pow(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2), 0.5);
		s = (distance1 + distance2 + distance3) / 2;
		area = Math.pow(s * (s - distance1) * (s - distance2) * (s - distance3), 0.5);
		System.out.print("The area of the triangle is " + area);
		if (input != null){
			input.close();
		}
	}
}
