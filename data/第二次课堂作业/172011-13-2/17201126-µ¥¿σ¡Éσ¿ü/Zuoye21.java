package Zuoye;

import java.util.Scanner;

public class Zuoye21 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a,b,c:");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double d=b*b-4*a*c;
		double equation1=0;
		double equation2=0;
		if(b*b-4*a*c<=0){
			System.out.println("The equation has no real root");
		}
		else if(b*b-4*a*c==0){
			equation1=(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
			System.out.println("The equation has one root:"+equation1);
		}
		else if(b*b-4*a*c>=0){
			equation1=(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
			equation2=(-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);
			System.out.println("The equation has two root:"+equation1+" and "+equation2);

			
		}

		
	}

}
