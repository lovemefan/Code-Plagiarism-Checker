package exercise;
import java.util.Scanner;
public class Exercise_2_19 {
	public static void main(String[] args) {
		double  x1,y1,x2,y2,x3,y3,a,b,c;
		double area,circumference;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter three points for a triangle!");
		//System.out.println("Enter x1 and y1:");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		//System.out.println("Enter x2 and y2:");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		//System.out.println("Enter x3 and y3:");
		x3 = in.nextDouble();
		y3 = in.nextDouble();
		a = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 -y1, 2), 0.5);
		b = Math.pow(Math.pow(x3 - x2, 2) + Math.pow(y3 -y2, 2), 0.5);
		c = Math.pow(Math.pow(x3 - x1, 2) + Math.pow(y3 -y1, 2), 0.5);
		circumference = (a + b + c) / 2;
		area = Math.pow(circumference * (circumference - a) * (circumference - b) * (circumference - c), 0.5);
		System.out.println("The area of the triangle is " + String.format("%.1f",area));
	}

}
