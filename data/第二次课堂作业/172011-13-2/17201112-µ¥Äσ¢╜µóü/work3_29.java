package assignments1;

import java.util.Scanner;

public class work3_29 {
	public static void main(String[] args){
		
		
		System.out.println("Enter circle1's center x- , y-coordinates , and radius:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		
		System.out.println("Enter circle2's center x- , y-coordinates , and radius:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		
		double distance = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		if(r2+r1<distance)
			System.out.println("circle2 does not overlap circle1");
		else if(r1-r2>distance)
			System.out.println("circle2 is inside circle1");
		else
			System.out.println("circle2 overlaps circle1");
	}

}
