package homework;

import java.util.Scanner;

public class homework3_1{
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a,b,c:");
		double r1,r2;
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double d=b*b-4*a*c;
		if(d>0){
			r1=(-b+Math.pow(d,0.5))/(2*a);
			r2=(-b-Math.pow(d,0.5))/(2*a);
			System.out.println("The equstion has tow roots "+r1+"and "+r2);
		}
		else if(d==0){
			r1=(-b+Math.pow(d,0.5))/(2*a);
			System.out.println("The equation has one root "+r1);
		
	}
		else{
			System.out.println("The equation has no real roots");
		}
}
}