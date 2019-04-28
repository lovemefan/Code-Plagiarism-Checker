package exercise2;
import java.util.Scanner;
public class exercise3_1 {
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a, b, c:");
	double a=input.nextDouble();
	double b=input.nextDouble();
	double c=input.nextDouble();
	double s=b*b-4*a*c;
	if(s>0){
		double r1=(-b+Math.pow(s,0.5))/(2*a);
		double r2=(-b-Math.pow(s,0.5))/(2*a);
		System.out.println("The equation has two roots "+r1+" and "+r2);
	}
	else if(s==0){
		double r1=(-b)/(2*a);
		double r2=r1;
		System.out.println("The equation has one root "+r1);
	}
	else{
		System.out.println("The equation has no real roots");
	}
	}

}
