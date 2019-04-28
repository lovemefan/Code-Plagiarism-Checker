package work1015;

import java.util.Scanner;
public class work3d1 {
	public static void main(String args[]){
		Scanner enter = new Scanner(System.in);
		
		System.out.print("Enter a, b, c:");
		double a,b,c;
		a=enter.nextDouble();
		b=enter.nextDouble();
		c=enter.nextDouble();
		
		double temp;
		temp=Math.pow(b, 2)-4*a*c;
		if(temp>0)
		{
			double temp1,temp2;
			temp1=(-1*b+Math.pow(temp, 0.5))/(2*a);
			temp2=(-1*b-Math.pow(temp, 0.5))/(2*a);
			System.out.print("The equation has two roots "+temp1+" and "+temp2);
		}
		else if(temp==0)
		{
			double temp1;
			temp1=(-1*b)/(2*a);
			System.out.print("The equation has one root "+temp1);
		}
		else 
		{
			System.out.print("The equation has no real roots");
		}
		
	}
}
