package dame;

import java.util.Scanner;

public class Root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        System.out.println("Enter a,b,c:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        if(Math.pow(b*b-4*a*c,0.5)>0){
        	double r1 = (-b+Math.pow(b*b-4*a*c,0.5))/2*a;
        	double r2 = (-b-Math.pow(b*b-4*a*c,0.5))/2*a;
        	System.out.println("The equation has tow roots " +r1+" and "+r2);
        }
        if(Math.pow(b*b-4*a*c,0.5)==0){
        	double x = -b/2*a;
        	System.out.println("The euation has one root "+x);
         }
        if(Math.pow(b*b-4*a*c,0.5)<0){
        	System.out.println("The equation has no real root");
        }
	}

}
