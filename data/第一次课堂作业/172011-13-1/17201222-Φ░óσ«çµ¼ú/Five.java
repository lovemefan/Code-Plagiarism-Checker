import java.util.Scanner;
public class Five {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
			System.out.print("Enter the first coordinate:");
				double x1 = input.nextDouble();
					double y1 = input.nextDouble();
					  System.out.print("Enter the second point:");
					 double x2 = input.nextDouble();
					  double y2 = input.nextDouble();
					   double square = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
					    double distance = Math.pow(square,0.5);
		System.out.println("The distance of the two points is " + distance);
	}

}
