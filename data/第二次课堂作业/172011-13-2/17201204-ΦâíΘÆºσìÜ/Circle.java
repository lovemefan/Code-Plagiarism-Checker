import java.util.Scanner;

public class Circle {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter circle1's center x- ,y-coordinates , and radius:");
		double x1 = input.nextDouble() , y1 = input.nextDouble() , r1 = input.nextDouble();
		System.out.print("Enter circle2's center x- ,y-coordinates , and radius:");
		double x2 = input.nextDouble() , y2 = input.nextDouble() , r2 = input.nextDouble();
		double d = Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
		if(d <= Math.abs(r1 - r2))
			System.out.print("circle2 is inside circle1");
		else if(d <= (r1 + r2))
			System.out.print("circlr2 overlaps circle1");
		else
			System.out.print("circle2 does not overlap circle1");
	}

}
