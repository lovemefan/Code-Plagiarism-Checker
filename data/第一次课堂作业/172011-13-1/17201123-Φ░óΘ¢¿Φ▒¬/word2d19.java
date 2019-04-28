package work;

import java.util.Scanner;
public class word2d19 {
	public static void main(String args[]){
		System.out.println("plz enter three (x,y):");
		
		Scanner enter = new Scanner(System.in);
		double x1,x2,x3,y1,y2,y3;
		x1=enter.nextDouble();
		y1=enter.nextDouble();
		x2=enter.nextDouble();
		y2=enter.nextDouble();
		x3=enter.nextDouble();
		y3=enter.nextDouble();
		
		double s1,s2,s3;
		s1=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		s2=Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));
		s3=Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3),2));
		
		double s0=(s1+s2+s3)/2;
		
		double S=Math.pow(s0*(s0-s1)*(s0-s2)*(s0-s3), 0.5);
		
		String ans=String.format("%.1f",S);
		System.out.println("The area of the triangle is "+ans);
	}
}
