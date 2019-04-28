package test1;
import java.util.Scanner;

public class test4 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double a1 = input.nextDouble();
		double a2 = input.nextDouble();
		double b1 = input.nextDouble();
		double b2 = input.nextDouble();
		double c1 = input.nextDouble();
		double c2 = input.nextDouble();
		double a = Math.pow(((a1-b1) * (a1-b1) + (a2-b2) * (a2-b2)), 0.5);
		double b = Math.pow(((b1-c1) * (b1-c1) + (b2-c2) * (b2-c2)), 0.5);
		double c = Math.pow(((c1-a1) * (c1-a1) + (c2-a2) * (c2-a2)), 0.5);
		double s = (a + b + c) / 2;
		double area = Math.pow(s * (s-a) * (s-b) * (s-c), 0.5);
		System.out.println("The area of the triangle is " + area);
	}
}