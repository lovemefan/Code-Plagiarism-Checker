package nice;
import java.util.Scanner;
public class Cricle {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first coordinate and radius: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.print("Enter the second coordinate and radus: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		double distance = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1), 0.5);
		if (distance<=Math.abs(r1-r2))
			System.out.println("circle2 is inside circle1");
		else if (distance<=(r1+r2))
			System.out.println("circle2 overlaps circle1");
		     else
		    	 System.out.println("circle2 does not overlap circle1");
			
	}

}
