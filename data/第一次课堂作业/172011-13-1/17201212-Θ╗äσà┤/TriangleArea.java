package work;

import java.util.Scanner;

public class TriangleArea {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");
		float x1 = input.nextFloat();
		float y1 = input.nextFloat();
		float x2 = input.nextFloat();
		float y2 = input.nextFloat();
		float x3 = input.nextFloat();
		float y3 = input.nextFloat();
		double b1 = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
		double b2 = Math.pow(Math.pow(x3-x1,2)+Math.pow(y3-y1,2),0.5);
		double b3 = Math.pow(Math.pow(x3-x2,2)+Math.pow(y3-y2,2),0.5);
		double s = (b1+b2+b3)/2;
		double area = Math.pow(s*(s-b1)*(s-b2)*(s-b3), 0.5);
		System.out.println("The area of the triangle is "+area);
	}

}
