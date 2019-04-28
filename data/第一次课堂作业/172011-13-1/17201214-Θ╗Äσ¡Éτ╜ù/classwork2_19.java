package helloworld;
import java.util.*;

public class classwork2_19 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");
		Double x1 = input.nextDouble();
		Double y1 = input.nextDouble();
		Double x2 = input.nextDouble();
		Double y2 = input.nextDouble();
		Double x3 = input.nextDouble();
		Double y3 = input.nextDouble();
		
		Double side1_f = Math.pow((x1-x2), 2)+Math.pow((y1-y2),2);
		Double side2_f = Math.pow((x2-x3), 2)+Math.pow((y2-y3),2);
		Double side3_f = Math.pow((x1-x3), 2)+Math.pow((y1-y3),2);
		
		Double side1 = Math.pow(side1_f,0.5);
		Double side2 = Math.pow(side2_f,0.5);
		Double side3 = Math.pow(side3_f,0.5);

		Double s = (side1+side2+side3)/2;
		Double area = Math.pow((s*(s-side1)*(s-side2)*(s-side3)),0.5);
		System.out.println("The area of triangle is "+area);
	}
}
