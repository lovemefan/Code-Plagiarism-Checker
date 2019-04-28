package task;

import java.util.Scanner;

public class Task3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a,b,c:");
		double a,b,c;
		Scanner in=new Scanner(System.in);
		a=in.nextDouble();
		b=in.nextDouble();
		c=in.nextDouble();
		double d=Math.pow(b, 2)-4*a*c;
		if (d<0) {
			System.out.println("The question has no real roots");
		}else if(d==0) {
			System.out.println("The question has one root"+(-b/2*a));
		}else {
			System.out.println("The question has two roots "+((-b+Math.pow(d, 0.5))/2*a)+" and "+((-b-Math.pow(d, 0.5))/2*a));
		}
		

	}

}
