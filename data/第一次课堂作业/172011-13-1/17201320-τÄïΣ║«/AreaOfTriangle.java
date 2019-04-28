import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter 3 points for a triangle: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double x3 = input.nextDouble();
			double y3 = input.nextDouble();
			double s1 = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
			double s2 = Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2);
			double s3 = Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2);
			double side1 = Math.pow(s1, 0.5);
			double side2 = Math.pow(s2, 0.5);
			double side3 = Math.pow(s3, 0.5);
			double s = (side1 + side2 + side3) / 2;
			double a = s - side1;
			double b = s - side2;
			double c = s - side3;
			if(a < 0) {
				a = a * -1;
			}
			if(b < 0) {
				b = b * -1;
			}
			if(c < 0) {
				c = c * -1;
			}
			double area = Math.pow((s * a * b * c), 0.5);
			System.out.println("The area of the triangle is: " + area);
		}
		finally {
			input.close();
		}
	}
}
