package pow;

import java.util.Scanner;

public class Pow {
	public static void main(String[] args){
		double x1 , y1 , x2 , y2 , l;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input x1 : ");
		x1 = input.nextDouble();
		System.out.println("Please input y1 : ");
		y1 = input.nextDouble();
		System.out.println("Please input x2 : ");
		x2 = input.nextDouble();
		System.out.println("Please input y2 : ");
		y2 = input.nextDouble();
		l = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2),0.5);
		System.out.println("The ditance between the two points is " + l);
	}
}
