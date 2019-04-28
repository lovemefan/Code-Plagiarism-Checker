package helloworld;

import  java.util.Scanner;
import  java.text.DecimalFormat;
public class area {
	public static void main (String[] args){
		double x1=0,x2=0,y1=0,y2=0,x3=0,y3=0,s=0,area1=0,dis1=0,dis2=0,dis3=0;
	    Scanner input =new Scanner(System.in);
	    System.out.println("Enter three points for a triangle:");
		x1=input.nextDouble();y1=input.nextDouble();
		x2=input.nextDouble();y2=input.nextDouble();
		x3=input.nextDouble();y3=input.nextDouble();
		dis1=Math.pow(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)),0.5);
		dis2=Math.pow(((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1)),0.5);
		dis3=Math.pow(((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3)),0.5);
		s=(dis1+dis2+dis3)/2;
		area1=Math.pow((s*(s-dis1)*(s-dis2)*(s-dis3)),0.5);
		DecimalFormat df = new DecimalFormat(".0");
	    System.out.println("The area of the triangle is:" + df.format(area1));
	    input.close();
	}

}