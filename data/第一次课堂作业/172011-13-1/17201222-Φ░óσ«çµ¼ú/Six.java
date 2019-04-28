import java.util.Scanner;
public class Six {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
			System.out.print("Enter three points for a triangle:");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double x3 = input.nextDouble();
			double y3 = input.nextDouble();
			double b1s = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
			double b1 = Math.pow(b1s,0.5);
			double b2s = (x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);
			double b2 = Math.pow(b2s,0.5);
			double b3s = (x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
			double b3 = Math.pow(b3s,0.5);
			double s = (b1 + b2 + b3)/2;
			double areasquare = s*(s - b1)*(s - b2)*(s - b3);
			double area = Math.pow(areasquare,0.5);
			System.out.println("The area of the triangle is " + area);
	}
}
