package Zuoye;

import java.util.Scanner;

public class Zuoye4 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");
		double a1=input.nextDouble();
		double a2=input.nextDouble();
		double a3=input.nextDouble();
		double a4=input.nextDouble();
		double a5=input.nextDouble();
		double a6=input.nextDouble();
		double i=Math.pow((a1-a3)*(a1-a3)+(a2-a4)*(a2-a4), 0.5);
		double j=Math.pow((a1-a5)*(a1-a5)+(a2-a6)*(a2-a6), 0.5);
		double k=Math.pow((a3-a5)*(a3-a5)+(a4-a6)*(a4-a6), 0.5);
		double s=(i+j+k)/2;
		double area=Math.pow(s*(s-i)*(s-j)*(s-k), 0.5);
		System.out.println("The area of the triangle is:"+area);
	}
}
