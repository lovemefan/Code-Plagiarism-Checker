package Test2_15_;

import java.util.Scanner;
public class Text2_15 {
	public static void main(String[] args){
		double x1 =0, x2 = 0, y1 = 0, y2 = 0,distance = 0;
		System.out.println("Enter x1 and y1:");	
		Scanner s = new Scanner(System.in);
		x1 =s.nextDouble();
		y1 =s.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2 =s.nextDouble();
		y2 =s.nextDouble();
		distance = Math.pow((Math.pow((x1-x2),2) + Math.pow((y1-y2), 2)),0.5);
		System.out.println("The distance of the two points is  :" + distance);
		
	}
}
