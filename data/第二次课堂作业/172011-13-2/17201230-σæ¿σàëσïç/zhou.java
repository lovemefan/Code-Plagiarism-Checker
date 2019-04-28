import java.util.Scanner;

public class zhou {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter three number:");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		if((b*b-4*a*c)>=0){
			if((b*b-4*a*c)>0){
			double r1=(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
			double r2=(-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);
			System.out.println("The equation has two roots "+r1+" and "+r2);
			}
			else 
			System.out.println("The equation has one root "+(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a));
		}
		else 
			System.out.println("The equation has no real root");
	}
}
