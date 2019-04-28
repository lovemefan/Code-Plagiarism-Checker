import java.util.Scanner;

public class Homework_3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a,b,c,d,x1,x2;
		
		System.out.println("Please input a,b and c:");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		d = b * b - 4 * a * c;
		if (d > 0) {
			x1 = (-1 * b + Math.sqrt(d)) / (2 * a);
			x2 = (-1 * b - Math.sqrt(d)) / (2 * a);
			System.out.printf("x1 = %f,x2 = %f\n", x1, x2);
		}
		else if (d < 0) {
			System.out.println("The equation has no real roots");
		}
		else {
			x1 = (-1 * b + Math.sqrt(d)) / (2 * a);
			System.out.println("x = " + x1);
		}
	}
}