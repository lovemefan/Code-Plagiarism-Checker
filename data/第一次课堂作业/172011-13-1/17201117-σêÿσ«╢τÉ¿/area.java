package demo;

import java.util.Scanner;

public class area
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double x1,x2,x3,y1,y2,y3;
		System.out.println("enter three points for a triangle : ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		double s1 = Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		double s2 = Math.pow(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2), 0.5);
		double s3 = Math.pow(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2), 0.5);
		double s = (s1+s2+s3)/2;
		double area = Math.pow(s*(s-s1)*(s-s2)*(s-s3), 0.5);
		System.out.println("the area of the triangle is  :"+ area);
		
	}

}
