package HelloWorld;
import java.util.Scanner;
public class EquationRoots {
public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a,b,c:");
	double a=input.nextDouble();
	double b=input.nextDouble();
	double c=input.nextDouble();
	double d=Math.pow(b,2)-4*a*c;
	if(d>0){
		double r1=(-b+Math.pow((Math.pow(b,2)-4*a*c),0.5))/(2*a);
		double r2=(-b-Math.pow((Math.pow(b,2)-4*a*c),0.5))/(2*a);
		System.out.println("The equation has two roots"+r1+"and"+r2);
	}
	if(d==0){
		double r=(-b+Math.pow((Math.pow(b,2)-4*a*c),0.5))/(2*a);
		System.out.println("The equation has one root"+r);
	}
	if(d<0)
		System.out.println("The equation has no real roots");
	
}
}
