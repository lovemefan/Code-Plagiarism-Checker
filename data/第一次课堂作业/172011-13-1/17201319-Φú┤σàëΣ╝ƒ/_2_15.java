import java.util.Scanner;

public class _2_15 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		String sx1 = input.next();
		String sy1 = input.next();
		System.out.print("Enter x2 and y2:");
		String sx2 = input.next();
		String sy2 = input.next();
		double x1 = Double.parseDouble(sx1);
		double y1 = Double.parseDouble(sy1);
		double x2 = Double.parseDouble(sx2);
		double y2 = Double.parseDouble(sy2);
		double d = Math.pow(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2),0.5);
		System.out.println("The distance between the two points is " + d);
	}

}
