import java.util.Scanner;

public class AreaOfTriangle {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double x1 = input.nextDouble() , y1 = input.nextDouble();
		double x2 = input.nextDouble() , y2 = input.nextDouble();
		double x3 = input.nextDouble() , y3 = input.nextDouble();
		double d1 =Math.pow(Math.pow(x1 - x2, 2)+Math.pow(y1 - y2, 2),0.5);
		double d2 =Math.pow(Math.pow(x1 - x3, 2)+Math.pow(y1 - y3, 2),0.5);
		double d3 =Math.pow(Math.pow(x3 - x2, 2)+Math.pow(y3 - y2, 2),0.5);
		double s = (d1 + d2 + d3) / 2;
		double Area = Math.pow(s * (s - d1) * (s - d2) * (s - d3), 0.5);
		System.out.print("The area of triangle is " + Area);
	}

}
