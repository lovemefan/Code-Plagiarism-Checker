package Zuoye;

import java.util.Scanner;

public class Zuoye24 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter circle1,s center x ,y coordinates,and radius:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double r1=input.nextDouble();
		System.out.println("Enter circle2,s center x ,y coordinates,and radius:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double r2=input.nextDouble();
		double length=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		if(length<r1)
			System.out.println("circle2 is inside circle1");
		else if(r1<length||length<(r1+r2))
			System.out.println("circle2 is overlap circle1");
		else if(length>(r1+r2))
			System.out.println("circle2 is not overlap circle1");
	}
}
