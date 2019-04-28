import java.util.Scanner;

public class _2_19 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		String sx1 = input.next();
		String sy1 = input.next();
		String sx2 = input.next();
		String sy2 = input.next();
		String sx3 = input.next();
		String sy3 = input.next();
		double x1 = Double.parseDouble(sx1);
		double y1 = Double.parseDouble(sy1);
		double x2 = Double.parseDouble(sx2);
		double y2 = Double.parseDouble(sy2);
		double x3 = Double.parseDouble(sx3);
		double y3 = Double.parseDouble(sy3);
		double d1 = Math.pow(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2),0.5);
		double d2 = Math.pow(Math.pow(x1 - x3,2) + Math.pow(y1 - y3,2),0.5);
		double d3= Math.pow(Math.pow(x3 - x2,2) + Math.pow(y3 - y2,2),0.5);
		double s = (d1 + d2 + d3) / 2;
		double area = Math.pow(s * (s - d1) * (s - d2) * (s - d3), 0.5);
		System.out.printf("The area of the triangle is %4.1f",area);
	}

}
