import java.util.Scanner;
public class Task4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
		double a1 = input.nextDouble();
		double a2 = input.nextDouble();
		double b1 = input.nextDouble();
		double b2 = input.nextDouble();
		double c1 = input.nextDouble();
		double c2 = input.nextDouble();
		double x = Math.pow((a1-b1)*(a1-b1)+(a2-b2)*(a2-b2),0.5);
		double y = Math.pow((a1-c1)*(a1-c1)+(a2-c2)*(a2-c2),0.5);
		double z = Math.pow((c1-b1)*(c1-b1)+(c2-b2)*(c2-b2),0.5);
		double s =(x+y+z)/2;
		double S = Math.pow(s*(s-x)*(s-y)*(s-z), 0.5);
		System.out.println("The area of the triangle is " + S);
	}
}
