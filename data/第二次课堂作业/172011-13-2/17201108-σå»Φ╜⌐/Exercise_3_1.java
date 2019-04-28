package exercise;
import java.util.Scanner;

public class Exercise_3_1 {
	public static void main(String[] args) {
		double a,b,c,t,x1,x2;
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter a,b,c:");
		a = in.nextDouble();
		b = in.nextDouble();
		c = in.nextDouble();
		t = Math.pow(b,2) - 4 * a * c;
		if (t < 0) {
			System.out.println("The equation has no real roots!");
		} else if (t > 0) {
			x1 = (-b + Math.pow(t, 0.5)) / (2 * a);
			x2 = (-b - Math.pow(t, 0.5)) / (2 * a);
			System.out.println("The equation has tow roots " + String.format("%.6f", x1) + " and " + String.format("%.6f", x2));
		} else {
			x1 = -b /(2 * a);
			System.out.println("The equation has one root " + x1);
		}
		
	}
}
