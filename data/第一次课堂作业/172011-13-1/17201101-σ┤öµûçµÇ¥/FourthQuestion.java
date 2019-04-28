package fourthQuestion;

import java.util.Scanner;
public class FourthQuestion {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
	
		System.out.println("please enter three points for a triangle:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		
		double a1=x2-x1;
		double a2=y2-y1;
		double a3=a1*a1+a2*a2;
		double l1=Math.pow(a3, 0.5);
		 
		double b1=x3-x1;
		double b2=y3-y1;
		double b3=b1*b1+b2*b2;
		double l2=Math.pow(b3, 0.5);
		
		double c1=x3-x2;
		double c2=y3-y2;
		double c3=c1*c1+c2*c2;
		double l3=Math.pow(c3, 0.5);
		
		double l=(l1+l2+l3)/2;
		double s1=l*(l-l1)*(l-l2)*(l-l3);
		double s=Math.pow(s1, 0.5);
		System.out.println("The area of the triangle is:"+s);
		input.close();
	}

}
