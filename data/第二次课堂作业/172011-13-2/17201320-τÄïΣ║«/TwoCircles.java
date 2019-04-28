import java.util.Scanner;

public class TwoCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter circle1's x ,y and radious: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double radious1 = input.nextDouble();
			System.out.println("Enter circle2's x ,y and radious: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double radious2 = input.nextDouble();
			double distance = 0;
			distance = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
			double r1;
			double r2;
			r1 = Math.abs(radious1 - radious2);
			r2 = radious1 + radious2;
			if(distance <= r1) {
				System.out.println("circle2 is inside circle1");
			}
			else if(distance <= r2) {
				System.out.println("circle2 overlaps circle1");
			}
			else {
				System.out.println("circle2 does not overlaps circle1");
			}
		}
		finally {
			input.close();
		}
	}

}
