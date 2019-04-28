/*
 * File:Question2_15.java
 * Description:calculate the distance between two points
 * Programmer:ChenChao
 * Date:10/11/18
 */

import java.util.Scanner;

public class Question2_15 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float x1,y1,x2,y2;
		System.out.print("Enter x1 and y1:");
		x1=input.nextFloat();
		y1=input.nextFloat();
		System.out.print("Enter x2 and y2:");
		x2=input.nextFloat();
		y2=input.nextFloat();
		double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		System.out.print("The distance between the two points is " + distance);
		if (input != null){
			input.close();
		}
	}
}
