import java.util.Scanner;

public class Equation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a, b, c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double judge = Math.pow(b, 2) - 4 * a * c;
		if (judge < 0){
			System.out.println("The equation has no real roots");
		}
		else if (judge == 0){
			double r = (-b + Math.pow(judge, 0.5)) / (2 * a);
			System.out.printf("The equation has one root %.0f", r);
		}
		else{
			double r1 = (-b + Math.pow(judge, 0.5)) / (2 * a);
			double r2 = (-b - Math.pow(judge, 0.5)) / (2 * a);
			System.out.printf("The equation has two roots %.6f", r1);
			System.out.printf(" and %.6f", r2);
		}
		input.close();
	}

}
