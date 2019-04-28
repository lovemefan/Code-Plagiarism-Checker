package mypackage;

import java.util.Scanner;

public class TwoNinteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter three points for a triangle : ");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double a=Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		double b=Math.pow((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1),0.5);
		double c=Math.pow((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3),0.5);
		double s=(a+b+c)/2;
		double t=(s*(s-a)*(s-b)*(s-c));
		System.out.println("The area of the triangle is" + Math.pow(t, 0.5));
		
	}

}
