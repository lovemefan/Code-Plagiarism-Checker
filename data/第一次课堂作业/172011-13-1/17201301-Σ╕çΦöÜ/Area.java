package homework1;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter three points for a triangle:");
	  double x1 = input.nextDouble();
	  double y1 = input.nextDouble();
	  double x2 = input.nextDouble();
	  double y2 = input.nextDouble();
	  double x3 = input.nextDouble();
	  double y3 = input.nextDouble();
	  double length1 = Math.pow(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0), 0.5);
	  double length2 = Math.pow(Math.pow(x2 - x3, 2.0) + Math.pow(y2 - y3, 2.0), 0.5);
	  double length3 = Math.pow(Math.pow(x3 - x1, 2.0) + Math.pow(y3 - y1, 2.0), 0.5);
	  double s = (length1 + length2 + length3)/2;
	  double area = Math.pow(s * (s - length1) * (s - length2) * (s - length3), 0.5);
	  System.out.printf("The area of the triangle is %3.1f" , area);
	  
	}

}
