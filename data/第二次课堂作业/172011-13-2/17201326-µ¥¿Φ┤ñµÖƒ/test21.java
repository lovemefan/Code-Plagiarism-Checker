package test2;
import java.util.Scanner;
public class test21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the 3 numbers about the equation: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double e = b * b - 4 * a * c;
		double D = Math.pow((b * b - 4 * a * c), 0.5);
		if (e > 0){
			System.out.println("The roots are: " + (-b + D) / 2 * a + "and" + (-b - D) / 2 * a);
		}	else if (e == 0){
			System.out.println("The root is: " + (-b + D) / 2 * a);
			}	else{
					System.out.println("The equation has no real roots");
				}
	}
}
