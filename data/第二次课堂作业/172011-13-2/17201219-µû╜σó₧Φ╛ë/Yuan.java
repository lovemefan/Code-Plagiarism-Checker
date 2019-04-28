package aaa;
import java.util.Scanner;
public class Yuan {
	public static void main(String[] args) {
		Scanner input =new Scanner (System.in);
		System.out.print("Enter circle1's center x-,y-coordinates,and radius: ");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double r1=input.nextDouble();
		System.out.print("Enter circle2's center x-,y-coordinates,and radius: ");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double r2=input.nextDouble();
		double a=Math.pow(x1-x2,2);
		double b=Math.pow(y1-y2,2);
		double c=Math.pow(a+b,0.5);
		if(c<=Math.abs(r1+r2))
			System.out.print("circle2 is inside circle1");
		else if(c<=(r1+r2))
			System.out.print("circle2 overlaps circle1");
		else
			System.out.print("circle2 does not overlap circle1");
	}

}
