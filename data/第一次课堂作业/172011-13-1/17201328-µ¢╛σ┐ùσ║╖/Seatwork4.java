import java.text.DecimalFormat;
import java.util.Scanner;

public class Seatwork4 {
	public static void main(String args[]) {
		System.out.println("Please enter three points for triangle :");
		double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
		Scanner input1 = new Scanner(System.in);
		x1 = input1.nextDouble();
		y1 = input1.nextDouble();
		x2 = input1.nextDouble();
		y2 = input1.nextDouble();
		x3 = input1.nextDouble();
		y3 = input1.nextDouble();
		double side1, side2, side3;
		side1 = cal(x1, y1, x2, y2);
		side2 = cal(x1, y1, x3, y3);
		side3 = cal(x2, y2, x3, y3);
		double s = 0;
		s = (side1 + side2 + side3) / 2;
		double area = 0;
		area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
		DecimalFormat df = new DecimalFormat( "0.0");
		System.out.println("The area of the triangle is :" + df.format(area));
	}
	public static double cal(double x1, double y1, double x2, double y2) {
		double dis = 0;
		dis = Math.pow( Math.pow((x1-x2),2) + Math.pow(y1-y2,2), 0.5);
		return dis;
	}
}
