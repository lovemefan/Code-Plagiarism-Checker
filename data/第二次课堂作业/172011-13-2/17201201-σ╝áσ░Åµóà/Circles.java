import java.util.Scanner;

public class Circles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x-,y-coordinates and radius:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates and radius:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		if(Math.pow(Math.pow(x1-x2,2)+Math.pow(y1-y2,2),0.5)<=Math.abs(r1-r2))
			System.out.println("circle2 is inside circle1");
		else if(Math.pow(Math.pow(x1-x2,2)+Math.pow(y1-y2,2),0.5)<=r1+r2)
			System.out.println("circle2 overlaps circle1");	
	}

}
