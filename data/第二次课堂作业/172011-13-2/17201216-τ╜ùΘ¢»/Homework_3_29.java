import java.util.Scanner;

public class Homework_3_29 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x1, y1, x2, y2, r1, r2,dist;
		
		System.out.print("Enter circle1's center x-, y- coordinates, and radius:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		r1 = input.nextDouble();
		System.out.print("Enter circle2's center x-, y- coordinates, and radius:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		r2 = input.nextDouble();
		
		dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		
		if (dist > r1 + r2) {
			System.out.println("circle2 does not overlap circle1");
		}
		else if (dist < r1 + r2) {
			System.out.println("circle2 is inside circle1");
		}
		else {
			System.out.println("circle2 overlaps circle1");
		}
	}
}