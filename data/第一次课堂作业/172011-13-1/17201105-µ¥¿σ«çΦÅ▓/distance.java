package yangyufei;
import java.util.Scanner;
public class distance {
	
		public static void main( String [] args) {
			System.out.print("Enter x1 and y1: ");
			Scanner input = new Scanner(System.in);
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			System.out.print("Enter x2 and y2: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double thedistance = Math.pow((Math.pow((x2-x1), 2)+Math.pow((y2-y1),2)),0.5);
			System.out.print("The distance between the two points is " + thedistance);
			}

	}

