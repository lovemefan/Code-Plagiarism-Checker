import java.util.Scanner;


public class SovleEquations {

	public static void main(String[] args) {
		System.out.print("Enter a,b,c:");
		Scanner input = new Scanner(System.in);
		double a,b,c;
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		double d = b * b - 4 * a *c;
		if (d < 0) {
			System.out.println("The equation has no real roots");
		}
		else if (d == 0) {
			double r = -b / (2 * a);
			System.out.println("The equation has two equal real roots " + r);
		} 
		else {
			double r1 = (-b + Math.sqrt(d)) / (2 * a);
			double r2 = (-b - Math.sqrt(d)) / (2 * a);
			System.out.println("The equation has two real roots " + r1 + " " + r2);
		}
	}
	
}
