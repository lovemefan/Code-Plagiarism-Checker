package classTest1;

import java.util.Scanner;

public class Classtest219 {
	public static void main(String[] args){
	double x1,x2,y1,y2,x3,y3,dis1,dis2,dis3,area,s; 
	Scanner input = new Scanner(System.in);
	 System.out.println("Enter three points for a triangle:");
	 x1 = input.nextDouble();
	 y1 = input.nextDouble();
	 x2 = input.nextDouble();
	 y2 = input.nextDouble();
	 x3 = input.nextDouble();
	 y3 = input.nextDouble();
	 dis1 = Math.pow(Math.pow((x2-x1),2)+Math.pow((y2-y1),2), 0.5);
	 dis2 = Math.pow(Math.pow((x3-x1),2)+Math.pow((y3-y1),2), 0.5);
	 dis3 = Math.pow(Math.pow((x3-x2),2)+Math.pow((y3-y2),2), 0.5);
	 s = (dis1 + dis2 + dis3)/2;
	 area = Math.pow(s*(s-dis1)*(s-dis2)*(s-dis3),0.5);
	 System.out.println("The area of the triangle is"+area);
	}
}
