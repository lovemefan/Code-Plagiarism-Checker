package count;
import java.util.Scanner;
public class area {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points of a triangle:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double s1 = Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5);
		double s2 = Math.pow((Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)), 0.5);
		double s3 = Math.pow((Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2)), 0.5);
		double s = (s1 + s2 + s3) / 2;	
		System.out.println("The area of the triangle is " + (Math.pow((s * (s - s1) * (s - s2) * (s - s3)), 0.5)));
	}
}
