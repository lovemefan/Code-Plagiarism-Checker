import java.util.Scanner;

public class HomeWorkFour {
	
	public static void main(String args[]) {
		double x1,y1,x2,y2,x3,y3;
		double a,b,c,s,area;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three points for a triangle:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		
		a = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2));
		b = Math.sqrt(Math.pow(x2 - x3, 2.0) + Math.pow(y2 - y3, 2));
		c = Math.sqrt(Math.pow(x1 - x3, 2.0) + Math.pow(y1 - y3, 2));
		s = (a + b + c) / 2;
		area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		System.out.printf("The area of the triangle is %.1f", area);
	}
}