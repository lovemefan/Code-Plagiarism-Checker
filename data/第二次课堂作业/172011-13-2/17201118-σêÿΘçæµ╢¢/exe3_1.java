package test;
import java.util.Scanner;

public class exe3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a,b,c,pan;
		System.out.print("Enter a,b,c : ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		pan = b*b - 4*a*c;
		if (pan<0) {
			System.out.println("The equation has no real roots");
		}
		if (pan==0) {
			System.out.println("The equation has one root "+ (b*(-1)+ Math.pow(pan, 0.5))/(2*a));
		}
		if (pan>0) {
			System.out.println("The equation has two root "+ (b*(-1)+ Math.pow(pan, 0.5))/(2*a)+" and "+(b*(-1)-Math.pow(pan, 0.5))/(2*a));
		}
	}
		

}
