package exercise;
import java.util.Scanner;

public class Exercise_3_29 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double distance,x1,y1,r1,x2,y2,r2;
		System.out.println("Enter circle1's center x-,y-coordinates, and radius:");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		r1 = in.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates, and radius:");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		r2 = in.nextDouble();
		distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 -y1, 2), 0.5);
		if ( Math.abs(r1 - r2) >= distance) {
			if (r2 > r1) {
				System.out.println("circle'1 is inside circle2");
			}else
				System.out.println("circle'2 is inside circle1");
		}else if (Math.abs(r1 + r2) >= distance && distance > Math.abs(r1 - r2)) {
			System.out.println("circle'2 is overlaps circle1");
		}else
			System.out.println("circle'2 dose not overlaps circle1");
	}
}
