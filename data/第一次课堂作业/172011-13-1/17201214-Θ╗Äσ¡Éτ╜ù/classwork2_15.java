package helloworld;
import java.util.*;

public class classwork2_15 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input x1 and y1:");
		Double x1 = input.nextDouble();
		Double y1 = input.nextDouble();
		System.out.println("Input x2 and y2:");
		Double x2 = input.nextDouble();
		Double y2 = input.nextDouble();
		
		Double number = Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2);
		Double distance = Math.pow(number, 0.5);
		
		System.out.println("The distance between the two points is "+distance);
	}
}
