import java.util.Scanner;
public class Java2_15 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter x1 and y1:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.println("Enter x2 and y2:");
		double x2  = input.nextDouble();
		double y2 = input.nextDouble();
        double a = Math.pow(x1-x2,2 );
        double b = Math.pow(y1-y2, 2);
         double distance = Math.pow(a+b,0.5 );
         System.out.println("The distance between the two points is " + distance);
	}

}
