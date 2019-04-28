package triangle;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args){
		double A,x1,y1,x2,y2,x3,y3,s,s1,s2,s3;
		
		System.out.println("Enter three points for a triangle:");
		Scanner input = new Scanner(System.in);
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		s1=Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
		s2=Math.pow(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2), 0.5);
		s3=Math.pow(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2), 0.5);
		s=(s1+s2+s3)/2;
		A=Math.pow(s*(s-s1)*(s-s2)*(s-s3), 0.5);
		System.out.printf("The area of the triangle is %4.1f",A);
	}

}
