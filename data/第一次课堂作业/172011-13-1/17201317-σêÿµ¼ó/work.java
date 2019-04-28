package work4;

import java.util.Scanner;

public class work {
	public static void main(String[] args){
		double x1,y1,x2,y2,x3,y3,s=0,m=0;
		System.out.println("Enter three points for a triangle :");
		Scanner input=new Scanner(System.in);
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		s=(Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2), 0.5)+Math.pow(Math.pow(x2-x3, 2)+Math.pow(y2-y3,2), 0.5)+Math.pow(Math.pow(x3-x1, 2)+Math.pow(y3-y1,2), 0.5))/2;
        m=Math.pow(s*(s-Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2), 0.5))*(s-Math.pow(Math.pow(x2-x3, 2)+Math.pow(y2-y3,2),0.5))*(s-Math.pow(Math.pow(x3-x1, 2)+Math.pow(y3-y1,2),0.5)), 0.5);
        System.out.println("The area of the triangle is :"+m);	
	}
	}
