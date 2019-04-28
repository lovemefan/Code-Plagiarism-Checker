package test;
import java.util.Scanner;

public class exe2_19 {
	public static void main(String arge[]) {
		Scanner input = new Scanner(System.in);
		double x1,y1,x2,y2,x3,y3;
		System.out.print("Enter three points for the triangle: ");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		double d1,d2,d3,a,s,area;
		a=Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
		d1=Math.pow(a, 0.5);
		a=Math.pow((x3-x2),2)+Math.pow((y3-y2),2);
		d2=Math.pow(a, 0.5);
		a=Math.pow((x1-x3),2)+Math.pow((y1-y3),2);
		d3=Math.pow(a, 0.5);
		s=(d1+d2+d3)/2;
		area=Math.pow(s*(s-d1)*(s-d2)*(s-d3), 0.5);
		System.out.println("The area of the triangle is "+ area);
	}

}
