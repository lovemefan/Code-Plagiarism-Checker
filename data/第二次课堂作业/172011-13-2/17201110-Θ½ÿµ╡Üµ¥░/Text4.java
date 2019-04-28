package Text;

import java.util.Scanner;

public class Text4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		 System.out.println("Enter circle1's center x-,y-coordinates,and radius :");
		 double x1 = input.nextDouble();
		 double y1 = input.nextDouble();
		 double r1 = input.nextDouble();
		 System.out.println("Enter circle2's center x-,y-coordinates,and radius :");
		 double x2 = input.nextDouble();
		 double y2 = input.nextDouble();
		 double r2 = input.nextDouble();
		 double d = Math.pow(Math.pow(x1- x2, 2) + Math.pow(y1 -y2, 2), 0.5);
		   if (d <= Math.abs(r1-r2) ) {
			 if(r1 < r2)
			 System.out.println("Circle1 is inside Circle2");
			  else
				  System.out.println("Circle2 is inside Circle1");  
		 }
		   else if(d <= r1 + r2){
			  System.out.println("Circle2 overlaps Circle1");
		 }
		    else {
		    	 System.out.println("Circle2 does not overlaps Circle1");
		    }
		 
	}
}
