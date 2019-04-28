import java.util.Scanner;

public class PointSpacing {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		double x1 = input.nextDouble() , y1 = input.nextDouble();
		System.out.print("Enter x2 and y2:");
		double x2 = input.nextDouble() , y2 = input.nextDouble();
		double d =Math.pow(Math.pow(x1 - x2, 2)+Math.pow(y1 - y2, 2),0.5);
		System.out.print("The distance between the two points is " + d);
		
	}

}
