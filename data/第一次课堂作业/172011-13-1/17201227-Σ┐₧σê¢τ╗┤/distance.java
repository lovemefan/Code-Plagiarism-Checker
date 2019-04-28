package helloworld;

import  java.util.Scanner;

public class distance {
	public static void main (String[] args){
		double x1=0,x2=0,y1=0,y2=0,dis=0;
	    Scanner input =new Scanner(System.in);
	    System.out.println("Enter x1 and y1:");
		x1=input.nextDouble();y1=input.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2=input.nextDouble();y2=input.nextDouble();
		dis=Math.pow(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)),0.5);
	    System.out.println("The distance between the two points is:" + dis);
	    input.close();
	}

}