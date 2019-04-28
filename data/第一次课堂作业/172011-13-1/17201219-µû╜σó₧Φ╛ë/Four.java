package aaa;
import java.util.Scanner;
public class Four {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		System.out.print("Enter three points for a triangle: ");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double a1=Math.pow(x2-x1, 2);
		double a2=Math.pow(y2-y1, 2);
		double a=Math.pow(a1+a2, 0.5);
		double b1=Math.pow(x3-x1, 2);
		double b2=Math.pow(y3-y1, 2);
		double b=Math.pow(b1+b2, 0.5);
		double c1=Math.pow(x3-x2, 2);
		double c2=Math.pow(y3-y2, 2);
		double c=Math.pow(c1+c2, 0.5);
		double s=(a+b+c)/2;
		double m=Math.pow(s*(s-a)*(s-b)*(s-c), 0.5);
		System.out.print("The area of the triangle is "+ m);
	}

}
