package work;

import java.util.Scanner;

public class work3 {
	public static void main(String[] args){
			double x1,y1;
			
			System.out.println("Enter x1 and y1");
			
			Scanner input  = new Scanner(System.in);
			
			x1 = input.nextDouble();
			y1 = input.nextDouble();
			
			double x2,y2;
			
			System.out.println("Enter x2 and y2");
			
			x2 = input.nextDouble();
			y2 = input.nextDouble();
			
			double distance;
			
			distance=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
			
			distance=Math.pow(distance, 0.5);
			
			System.out.println("The distance between the points is " + distance);
			
	}
	
}
