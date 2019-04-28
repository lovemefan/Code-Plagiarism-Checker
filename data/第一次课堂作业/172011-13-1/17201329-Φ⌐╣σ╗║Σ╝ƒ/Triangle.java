
import java.util.Scanner;

public class Triangle {
	public static void main(String[] agrs){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a triangle(x1,y1),(x2,y2),(x3,y3):");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		
		double side1=Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2),0.5);
		double side2=Math.pow(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2),0.5);
		double side3=Math.pow(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2),0.5);
		
		double averageSide=(side1+side2+side3)/2;
		
		double area=Math.pow(averageSide*(averageSide-side1)*(averageSide-side2)*(averageSide-side3),0.5);
		System.out.println("The area is " + area);
	}
}
