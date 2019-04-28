package workone;
import java.util.Scanner;

public class one {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a,b,c");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d,r1,r2,r3;
		d = b*b-4*a*c;
		if(d<0) {
			System.out.print("The equatain has no real roots");
			}
		if(d==0) {
			r1=(-b)/2*a;
			System.out.print("The equatain has one roots"+r1);
		}
		if(d>0) {
			r3=b*b-4*a*c;
			r1=((-b)+Math.pow(r3, 0.5))/2*a;
			r2=((-b)-Math.pow(r3, 0.5))/2*a;
			System.out.print("The equatain has two roots"+r1+"and"+r2);
		}
	}
	
	

}
