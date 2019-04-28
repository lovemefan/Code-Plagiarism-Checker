package equation;

import java.util.Scanner;

public class Equation {
	public static void main(String[] args){
		double a, b, c ,x1 ,x2;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a : ");
		a = input.nextDouble();
		System.out.println("Please input b : ");
		b = input.nextDouble();
		System.out.println("Please input c : ");
		c = input.nextDouble();
		if (Math.pow(b, 2) - 4 * a * c > 0){
			x1 =(- b + Math.pow(Math.pow(b, 2) - 4 * a * c , 0.5)) / (2 * a);
			x2 =(- b - Math.pow(Math.pow(b, 2) - 4 * a * c , 0.5)) / (2 * a);
			System.out.println("The equation has two roots " + x1 + "and " + x2);
		}
		else if (Math.pow(b, 2) - 4 * a * c == 0){
			x1 =(- b + Math.pow(Math.pow(b, 2) - 4 * a * c , 0.5)) / (2 * a);
			System.out.println("The equation has one root " + x1);
		}
		else if (Math.pow(b, 2) - 4 * a * c < 0) 
			System.out.println("The equation has no real root ");
		
	}
}
