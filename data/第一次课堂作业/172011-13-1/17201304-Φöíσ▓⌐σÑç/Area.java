package area;

import java.util.Scanner;

public class Area {
	public static void main(String[] args){
		double x1 , y1 , x2 , y2 , x3 , y3 , s , l1 , l2 , l3 , area;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input x1 : ");
		x1 = input.nextDouble();
		System.out.println("Please input y1 : ");
		y1 = input.nextDouble();
		System.out.println("Please input x2 : ");
		x2 = input.nextDouble();
		System.out.println("Please input y2 : ");
		y2 = input.nextDouble();
		System.out.println("Please input x3 : ");
		x3 = input.nextDouble();
		System.out.println("Please input y3 : ");
		y3 = input.nextDouble();
		l1 = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2),0.5);
		l2 = Math.pow(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2),0.5);
		l3 = Math.pow(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2),0.5);
		s = (l1 + l2 + l3) / 2;
		area = Math.pow(s*(s-l1)*(s-l2)*(s-l3),0.5);
		System.out.println("The intrest is " + area );
	}
}
