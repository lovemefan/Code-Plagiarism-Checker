package exercise;
import java.util.Scanner;

public class Exercise2_15 {
	public static void main(String[] args) {
		double  x1,y1,x2,y2;
		double distance;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter x1 and y1:");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		System.out.println("The distance between tow points is " + distance);
	}
}
