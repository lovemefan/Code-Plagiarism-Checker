package aaa;
import java.util.Scanner;
public class Gen {
	public static void main(String[] args) {
		double a=0,b=0,c=0,d=0,r1=0,r2=0;
		Scanner input =new Scanner (System.in);
		System.out.print("Enter a,b,c: ");
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		d=b*b-4*a*c;
		if(d>0){
			r1=(-b+Math.pow(d, 0.5))/(2*a);
			r2=(-b-Math.pow(d, 0.5))/(2*a);
			System.out.print("The equation has two roots "+r1+"and "+r2);
		}
		else if(d==0){
			r1=(-b-Math.pow(d, 0.5))/(2*a);
			System.out.print("The equation has one root "+r1);
		}
		else{
			System.out.print("The equation has no real roots ");
		}
	}

}
