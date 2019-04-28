package work;
import java.util.Scanner;
public class work1 {
	public static void main(String[] args){
		double a=0,b=0,c=0,d=0,r1=0,r2=0;
		System.out.println("Enter a,b,c");
		Scanner input =new Scanner(System.in);
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		d=b*b-4*a*c;
		if(d<0){
			System.out.println("The equation has no real roots");
		}
	    else if(d==0){
		    r1=-b/2*a;
			System.out.println("The equation has one root "+r1);
		}
		else if(d>0){
			r1=(-b+Math.pow(d,0.5))/2*a;
			r2=(-b-Math.pow(d,0.5))/2*a;
			System.out.println("The equation has two roots "+r1 +"and"+r2);
			
	}
}
}
