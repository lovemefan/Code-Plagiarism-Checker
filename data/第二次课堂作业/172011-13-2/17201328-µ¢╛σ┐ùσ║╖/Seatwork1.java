import java.util.Scanner;

public class Seatwork1 {
	public static void main(String[] args){
		System.out.println("Please enter a b c");
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0, c = 0;
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		double standard = 0;
		standard = Math.pow(b,2) - 4 * a * c;
		if (standard > 0){
			double r1 = 0, r2 = 0;
			r1 = (-b + Math.pow(standard, 0.5) ) / 2 * a;
			r2 = (-b - Math.pow(standard, 0.5) ) / 2 * a;
			System.out.println("The equation has two roots " + r1 + " and " + r2);
		}
		else if (standard == 0){
			double r = 0;
			r = (-b + Math.pow(standard, 0.5) ) / 2 * a;
			System.out.println("The equation has one roots " + r);
		}
		else if (standard < 0){
			System.out.println("The equation has no real roots");
		}
		
	}
}
