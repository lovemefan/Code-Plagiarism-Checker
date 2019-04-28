import java.util.Scanner;

public class homework3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a, b, c :");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double abc = Math.pow(b, 2) - 4 * a * c;
		if (abc > 0) {
			double r1 = ((-b) + Math.pow(abc, 0.5)) / (2 * a);
			double r2 = ((-b) - Math.pow(abc, 0.5)) / (2 * a);
			System.out.println("The equation has two roots " + r1 + " and " + r2);
		}
		else if (abc == 0) {
			double r3 = (-b) / (2 * a);
			System.out.println("The equation has one root " + r3);
		}
		else {
			System.out.println("The equation has no real roots");
		}
	}

}
