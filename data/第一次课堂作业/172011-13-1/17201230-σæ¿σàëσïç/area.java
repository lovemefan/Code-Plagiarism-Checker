package area;

import java.util.Scanner;

public class area {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the first points:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.print("Enter the second points:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		System.out.print("Enter the third points:");
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double length1=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		double length2=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		double length3=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		double s=(length1+length2+length3)/2;
		double area=Math.pow(s*(s-length1)*(s-length2)*(s-length3), 0.5);
		System.out.println("The area of the triangle is "+area);
		}
}
