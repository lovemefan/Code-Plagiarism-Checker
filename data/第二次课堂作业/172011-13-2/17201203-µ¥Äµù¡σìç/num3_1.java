package ¿ÎÌÃ×÷Òµ;
import java.util.Scanner;
public class num3_1 {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("Enter a,b,c");
	double a,b,c,r1,r2;
	a = input.nextDouble();
	b = input.nextDouble();
	c = input.nextDouble();
	if (Math.pow(b,2)-(4 * a *c)>0){
	r1=(-b + Math.pow((Math.pow(b, 2) - (4 * a * c)), 0.5)) / 2 * a;
	r2=(-b - Math.pow((Math.pow(b, 2) - (4 * a * c)), 0.5)) / 2 * a;
	System.out.print("The equation has two roots + r1 + r2");
	}else if (Math.pow(b,2)-(4 * a * c) == 0){
		r1=(-b + Math.pow((Math.pow(b, 2) - (4 * a * c)), 0.5)) / 2 * a;
	    System.out.print("The equation has one root + r1");
	}else{
		System.out.print("The equation has no real roots");
	}
	
  }
}