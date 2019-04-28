package function;

import java.util.Scanner;

public class function {
	public static void main(String[] args){
		double a,b,c,r1 = 0,r2 = 0,r = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a,b,c:");
		
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		if (b*b-4*a*c>0){
			r1 = (-b+Math.pow(b*b-4*a*c,0.5))/2*a;
			r2 = (-b-Math.pow(b*b-4*a*c,0.5))/2*a;
			System.out.println("The equation has two roots" +r1+ "and" +r2);
		}
		
		if (b*b-4*a*c==0){
			r = -b/2*a;
			System.out.println("The equation has one roots" +r);
		}
		
		if (b*b-4*a*c<0){
			System.out.println("The equation has no real roots");
		}
	}

}
