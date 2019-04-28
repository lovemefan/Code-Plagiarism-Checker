package AREA;

import java.util.Scanner;

public class AREA {
	public static void main(String[] args){
		System.out.println("Enter three points for triangle:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextInt();
		double y1 = input.nextInt();
		
		double x2 = input.nextInt();
		double y2 = input.nextInt();
		
		double x3 = input.nextInt();
		double y3 = input.nextInt();
		
		double a = Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		double b = Math.pow(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2), 0.5);
		double c = Math.pow(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2), 0.5);
		
		double s = (a+b+c)/2;
		double area = Math.pow(s*(s-a)*(s-b)*(s-c), 0.5);
		area = (double)Math.round(area*100)/100;
		
		System.out.println("The area of the triangle is "+area);
	}
}
