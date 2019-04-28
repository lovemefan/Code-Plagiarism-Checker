package workone;
import java.util.Scanner;
public class four {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ciriclel's center x-,y-coordinates, and radius:");
		System.out.println("Enter ciriclel's center x-,y-coordinates, and radius:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		double x2 = input.nextDouble();   
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		double a =(x1-x2)*(x1-x2);
		double b = (y1-y2)*(y1-y2);
		double dis =Math.pow(a+b, 0.5);
		if(dis<=Math.abs(r1-r2))
			System.out.println("Circle2 is inside circlel");
		else if(dis<=r1+r2)
			System.out.println("Circle2 overlaps circlel");
		else
			System.out.println("Circle2 dose not overlaps circlel");
	}

}
