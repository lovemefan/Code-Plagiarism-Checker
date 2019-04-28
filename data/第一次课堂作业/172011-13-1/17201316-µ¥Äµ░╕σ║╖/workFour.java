import java.util.Scanner;

public class workFour {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double a = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		double b = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
		double c = Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
		double s = (a+b+c)/2.0;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("The area of the triangle is "+area);
	}
}
