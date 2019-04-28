import java.util.Scanner;

public class Exe2_19 {
	public static void main(String[] args) {
		//Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three points for a triangle: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		double a = Math.pow((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)), 0.5);
		double b = Math.pow((Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)), 0.5);
		double c = Math.pow((Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2)), 0.5);
		
		double s = (a + b + c) / 2;
		double area = Math.pow(s * (s - a) * (s - b) * (s - c), 0.5);

		System.out.println("The area of the triangle is " + (int)(area * 10) / 10.0);
	}
}
