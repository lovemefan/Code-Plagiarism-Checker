package distance;

import java.util.Scanner;

public class Distance {
	public static void main(String[] args){
		double x1,x2,y1,y2,a,b,d;
		
		System.out.println("Enter x1 and y1:");
		Scanner input = new Scanner(System.in);
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2=input.nextDouble();
		y2=input.nextDouble();
		a=Math.pow((x1-x2),2);
		b=Math.pow((y1-y2),2);
		d=Math.pow((a+b), 0.5);
		System.out.println("The distance between the two points is "+d);
	}
}
