package dame;

import java.util.Scanner;

public class Exe3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter circle1's center x1,y1 coordinate,and radius:");
		 double x1 = input.nextDouble();
		 double y1 = input.nextDouble();
		 double r1 = input.nextDouble();
		 System.out.println("Enter circle2's center x2,y2 coordinate,and radius:");
		 double x2 = input.nextDouble();
		 double y2 = input.nextDouble();
		 double r2 = input.nextDouble();
		 double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		 if(distance<=Math.abs(r1-r2)){
			 System.out.println("Circle2 is inside circle1.");
		 }
		 else if(distance<=(r1+r2)){
			 System.out.println("Circle2 overlops circle1.");
		 }
		 else System.out.println("Circle2 does not overlop circle2.");
	}

}
