package yangyufei;

import java.util.Scanner;

public class Work4 {
	public static void main( String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circlce1's center x-,y-coordinates, and radius :");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.println("Enter circlce2's center x-,y-coordinates, and radius :");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		double distance1= Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
		
		if (distance1<=Math.abs(r1-r2)){
			System.out.println("circle2 is inside circle1");
		}
		else if (distance1<=r1+r2){
			System.out.println("circle2 overlaps circle1");
		}
		else{
			System.out.println("circle2 does not overlaps circle1");
		}

}
}
