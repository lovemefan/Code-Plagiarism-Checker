package DIS;

import java.util.Scanner;

public class DIS {
	public static void main(String[] args){
		System.out.println("Enter x1 and y1:");
		Scanner input = new Scanner(System.in);
		
		double x1 = input.nextInt();
		double y1 = input.nextInt();
		
		System.out.println("Enter x2 and y2:");
		
		double x2 = input.nextInt();
		double y2 = input.nextInt();
		
		double dis = Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		
		System.out.println("The distance between the two points is "+dis);
	}
}
