package ClassWork1;

import java.util.Scanner;

public class ClassWork2_19 {
	public static void main(String[] args){
		double x1,y1,x2,y2,x3,y3;
		System.out.println("Enter three points for a triangle:");
		Scanner input=new Scanner(System.in);
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		double distance1=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		double distance2=Math.pow((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3), 0.5);
		double distance3=Math.pow((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2), 0.5);
		double s=(distance1+distance2+distance3)/2;
		double area=Math.pow(s*(s-distance1)*(s-distance2)*(s-distance3),0.5);
		System.out.println("The area of triangle is:"+area);
	}


}
