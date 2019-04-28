package Distance;

import java.util.Scanner;

public class Distance {
	public static void main(String[] args){
		double x1,y1,x2,y2,dis,a,b;
		System.out.println("Enter x1 and y1: ");
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		//Scanner input2 = new Scanner(System.in);
		y1 = input.nextDouble();
		System.out.println("Enter x2 and y2: ");
		//Scanner input3 = new Scanner(System.in);
		x2 = input.nextDouble();
		//Scanner input4 = new Scanner(System.in);
		y2 = input.nextDouble();
		a = Math.pow((x2-x1), 2);
		b = Math.pow((y2-y1), 2);
		dis = Math.pow((a+b), 0.5);
		System.out.println("The distance between the two points is "+dis );
	}

}
