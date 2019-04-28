package Area;

import java.util.Scanner;

public class Area {
	public static void main(String[] args){
		double s,x1,y1,x2,y2,x3,y3,a,b,c,d,e,f,area;
		System.out.println("Enter three points for a triangle: ");
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		d = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
		e = Math.pow(x2-x3, 2) + Math.pow(y2-y3, 2);
		f = Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2);
		a = Math.pow(d, 0.5);
		b = Math.pow(e, 0.5);
		c = Math.pow(f, 0.5);
		s = (a+b+c)/2;
		area = Math.pow(s * (s-a) * (s-b) * (s-c), 0.5);
		System.out.println("The area of the triangle is "+area);
	}

}
