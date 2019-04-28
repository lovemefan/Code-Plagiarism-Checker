package mayday001;

import java.util.Scanner;

public class Rootd {
	public static void main(String[] args){
		double a,b,c ,d,e= 0;
		System.out.println("please input three numbers.");
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		if(Math.pow(b, 2)-4*a*c==0){
			d = (-b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/(2*a);
			System.out.println("there only one root:" +d);
		}
		if(Math.pow(b, 2)-4*a*c>0){
			d = (-b+Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/(2*a);
			e = (-b-Math.pow(Math.pow(b, 2)-4*a*c, 0.5))/(2*a);
			System.out.println("there two roots :" +d+ "and" +e);
			
		}
		else{
			System.out.println("The equaion is no real roots.");
		}
	}
}
