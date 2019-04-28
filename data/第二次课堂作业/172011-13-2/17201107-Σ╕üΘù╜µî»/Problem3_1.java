package dmz;
import java.util.Scanner;

public class Problem3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double r1 = (-b+Math.pow((Math.pow(b,2)-4*a*c),0.5))/(2*a);
		double r2 = (-b-Math.pow((Math.pow(b,2)-4*a*c),0.5))/(2*a);
		if (Math.pow(b,2)-4*a*c>0) 
		{System.out.print("The equation has two roots"+r1+"and"+r2);}
		else if (Math.pow(b,2)-4*a*c==0) 
		{System.out.print("The equation has one roots"+r1);}
		else 
		{System.out.print("The equation has no real roots");}
}
}