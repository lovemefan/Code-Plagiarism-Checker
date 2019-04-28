package test;

import java.util.Scanner;

public class three {
	public static void main(String[] args){
		  Scanner input=new Scanner(System.in);
		  System.out.print("Enter X1 and Y1:");
		  double X1=input.nextDouble();
		  double Y1=input.nextDouble();
		  System.out.print("Enter X2 and Y2:");
		  double X2=input.nextDouble();
		  double Y2=input.nextDouble();
		  double distance=Math.pow((Math.pow((X1-X2),2)+Math.pow((Y1-Y2), 2)),0.5);
		  System.out.println("The distance between the points is"+distance);	  
	}
}
