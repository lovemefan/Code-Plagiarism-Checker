import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			
			System.out.print("Enter x1 and y1: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			System.out.print("Enter x2 and y2: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double a = Math.pow(x2 - x1, 2);
			double b = Math.pow(y2 - y1, 2);
			double result = Math.pow(a + b, 0.5);
			System.out.println("The distance between the two point is: " + result);
		}
		finally {
			input.close();
		}
	}

}
