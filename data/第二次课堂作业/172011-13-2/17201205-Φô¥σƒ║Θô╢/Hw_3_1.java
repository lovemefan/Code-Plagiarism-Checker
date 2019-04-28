package HW;

import java.text.DecimalFormat;
import java.util.Scanner;

	public class Hw_3_1 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		DecimalFormat df = new DecimalFormat("#.0000");
		DecimalFormat df2 = new DecimalFormat("#.00");
		
		System.out.println("Enter a, b, c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		if ((b*b - 4*a*c) == 0){
			System.out.println("The equation has one root " + df2.format(( -b + Math.pow(b*b - 4*a*c, 0.5) ) /(2*a)));
			}
		if ((b*b - 4*a*c) < 0)
			System.out.println("The equation has no real roots");
		else{
			if ((b*b - 4*a*c) > 0){
		double r1 = ( -b + Math.pow(b*b - 4*a*c, 0.5) ) /(2*a);
		double r2 = ( -b - Math.pow(b*b - 4*a*c, 0.5) ) /(2*a);
		System.out.println("The equation has two roots :" + df.format(r1) + "and" + df.format(r2));
			}
		}
	}
}
