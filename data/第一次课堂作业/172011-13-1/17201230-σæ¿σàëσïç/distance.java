package distance;

import java.util.Scanner;

public class distance {
	public static void main(String[] args){
	Scanner input =new Scanner(System.in);
	System.out.print("Enter x1 and y2:");
	double x1=input.nextDouble();
	double y1=input.nextDouble();
	System.out.print("Enter x2 and y2:");
	double x2=input.nextDouble();
	double y2=input.nextDouble();
	double distance=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
	System.out.println("The distance between the two points is "+distance);
	}

}
