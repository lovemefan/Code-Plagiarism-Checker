package work;

import java.util.Scanner;

public class C3_1 {
	public static void main(String[] args){
		 Scanner input=new Scanner(System.in);
		 System.out.print("Enter a,b,c:");
		 double a=input.nextDouble();
		 double b=input.nextDouble();
		 double c=input.nextDouble();
		 double d=b*b-4*a*c;
		 if  (d > 0)
		 {
			 double X1=(-b+Math.pow(d, 0.5))/2*a;
		     double X2=(-b-Math.pow(d, 0.5))/2*a;
		     System.out.println("The equation has two roots"+X1+"and"+X2);
		 }
		 else if (d==0)
		 {
			 double X1=-b/2*a;
		     System.out.println("The equation has one root"+X1);
		 }
		 else
		 {
			 System.out.println("The equation has no real roots");
		 }
			 
			     }
}
