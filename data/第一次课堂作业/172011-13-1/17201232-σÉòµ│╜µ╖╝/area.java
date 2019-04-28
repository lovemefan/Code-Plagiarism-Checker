import java.util.Scanner;

public class area {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");


		Double x1 = input.nextDouble();
		Double y1 = input.nextDouble();
		Double side1 = Math.pow((x1-x2), 2)+Math.pow((y1-y2),2);


		Double x2 = input.nextDouble();
		Double y2 = input.nextDouble();
		Double side2 = Math.pow((x2-x3), 2)+Math.pow((y2-y3),2);


		Double x3 = input.nextDouble();
		Double y3 = input.nextDouble();
		Double side3 = Math.pow((x1-x3), 2)+Math.pow((y1-y3),2);
		
		Double x = Math.pow(side1,0.5);
		Double y = Math.pow(side2,0.5);
		Double z = Math.pow(side3,0.5);

		Double s = (x+y+z)/2;
		Double area = Math.pow((s*(s-x)*(s-y)*(s-z)),0.5);
		System.out.println("The area of triangle is "+area);
	}
}
