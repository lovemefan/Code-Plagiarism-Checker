package work2;
import java.util.Scanner;

public class project {
	public static void main(String[] arg){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a, b, c :");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double r1 = 0;
		double r2 = 0;
		double r = 0;
		r = b*b-4*a*c;
		if(r < 0){
			System.out.println("The equation has no real roots");
		}else if(r == 0){
			r1 = (-b+r)/(2*a);
			System.out.println("The equation has one root "+ r1);
		}else if(r > 0){
			r1 = (-b+Math.pow(r, 0.5))/(2*a);
			r2 = (-b-Math.pow(r, 0.5))/(2*a);
			System.out.println("The equation has two roots "+ r1 + " and "+ r2 );	
		}
	}
}
