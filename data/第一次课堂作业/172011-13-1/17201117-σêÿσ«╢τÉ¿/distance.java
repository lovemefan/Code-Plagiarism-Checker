package demo;

import java.util.Scanner;

public class distance 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		System.out.println("Please enter x1 and y1");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.println("Please enter x2 and y2");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		double distance = Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		System.out.println("the distance between the two points is :"+ distance);
	}
}
