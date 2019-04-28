package classtest;

import java.util.Scanner;

public class test3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a, b, c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double A = Math.pow(b, 2)-4 * a * c;
		double r1, r2;
		if(A > 0){
			r1= (-b+Math.pow(A, 0.5))/(2 * a);
			r2= (-b-Math.pow(A, 0.5))/(2 * a);
			System.out.println("The equation has two roots "+ r1 + "and "+ r2);
		}
		else if(A ==0){
			r1 = r2 = -b / (2 * a);
			System.out.println("The equation has one root "+ r1);
		}
		else{
			System.out.println("The equation has no real roots");
		}
		if(input != null) {
			input.close();
		}	
	}
}
