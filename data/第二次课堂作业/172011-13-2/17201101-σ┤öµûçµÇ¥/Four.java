package workTwo;

import java.util.Scanner;
public class Four {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("please enter x1 y2 r1: ");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double r1=input.nextDouble();
		
		System.out.println("please enter x2 y2 r2: ");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double r2=input.nextDouble();
		
		x1=x2-x1;
		x1=x1*x1;
		y1=y2-y1;
		y1=y1*y1;
		double num=x1+y1;
		num=Math.pow(num, 0.5);
		
		double r=Math.abs(r2-r1);
		if(num <=r)
			System.out.println("circle2 is inside circle1 ");
		else if(num<=(r1+r2))
			System.out.println("circle2 overlaps circle1 ");
		else
			System.out.println("circle2 does not overlaps circle1 ");
		input.close();
	}

}
