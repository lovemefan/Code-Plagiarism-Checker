package TrangleArea;//2.19

import java.util.Scanner;

public class TrangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a trangle");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double side1 = 0,side2 = 0,side3 = 0,s = 0,area = 0;
		side1 = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
		side2 = Math.sqrt((Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)));
		side3 = Math.sqrt((Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2)));
		s = (side1 + side2 + side3) / 2;
		area = Math.pow((s*(s-side1)*(s-side2)*(s-side3)),0.5);
		System.out.println("The area of the trangle is " + area);
		if(input != null) {
			input.close();
		}
	}

}
