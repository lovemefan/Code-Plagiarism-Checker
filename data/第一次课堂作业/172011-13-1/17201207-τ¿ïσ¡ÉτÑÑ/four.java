package test;

import java.util.Scanner;

public class four {
	public static void main(String[] args){
		  Scanner input=new Scanner(System.in);
		  System.out.print("Enter three points for a triangle:");
		  double X1=input.nextDouble();
		  double Y1=input.nextDouble();
		  double X2=input.nextDouble();
		  double Y2=input.nextDouble();
		  double X3=input.nextDouble();
		  double Y3=input.nextDouble();
		  double a=Math.pow((Math.pow((X1-X2),2)+Math.pow((Y1-Y2), 2)),0.5);
		  double b=Math.pow((Math.pow((X3-X2),2)+Math.pow((Y3-Y2), 2)),0.5);
		  double c=Math.pow((Math.pow((X1-X3),2)+Math.pow((Y1-Y3), 2)),0.5);
		  double s=(a+b+c)/2;
		  double area=Math.pow((s*(s-a)*(s-b)*(s-c)),0.5);
		  System.out.println("The area of the triangle is"+area);
	}

}
