package test1013;

import java.util.Scanner;

public class Test31 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a,b,c:");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double d=Math.pow(b, 2)-4*a*c;
		double r=0,r1=0,r2=0;
		
		if(d==0) {
			 r=(-1*b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
		     System.out.print("The equation has root:"+r);}
		else if(d>0) {
			      r1=(-1*b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
		          r2=(-1*b-Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/2*a;
		          System.out.print("The equation has two roots:"+r1+"and"+r2);}
		    else 
		        	System.out.print("The equation has no real roots");
	 

	}

}
