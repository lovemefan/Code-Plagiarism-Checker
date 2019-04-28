package project2;
import java.util.Scanner;
public class P3_29 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter circle1's center x-,y-coordinates.and radius: ");
		double x1,y1,x2,y2,radius1,radius2;
		x1=input.nextDouble();
		y1=input.nextDouble();
		radius1=input.nextDouble();
		System.out.print("Enter circle2's center x-,y-coordinates.and radius: ");
		x2=input.nextDouble();
		y2=input.nextDouble();
		radius2=input.nextDouble();
		double distance=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2),0.5);
		if(distance<=Math.abs(radius1-radius2)){
			System.out.println("circle2 is inside circle1");
		}
		else if(distance<=radius1+radius2) {
			System.out.println("circle2 overlaps circle1");
		}
		else {
			System.out.println("circle2 does not overlap circle1");
		}
		input.close();

	}

}
