package class2;

import java.util.Scanner;

public class question1{

	public static void main(String[] args){
	
	 Scanner input =new Scanner(System.in);
	 System.out.print("Enter a b c : ");
	  double a=input.nextDouble();
	  double b=input.nextDouble();
	  double c=input.nextDouble();
	  double v=Math.pow(b,2)-4*a*c;
	  if (v>0){
		  double i=(Math.pow(v, 0.5)-b)/2*a;
	      double k=(0-Math.pow(v, 0.5)-b)/2*a;
	  
		  System.out.println("The equation has two roots "+i+" and "+k);
	}
	  else if(v==0){
		  double k=(0-Math.pow(v, 0.5)-b)/2*a;
		  
		  System.out.println("The equation  has one root "+k);
	  }
	  else if(v<0){
		  System.out.println("The equation  has no real roots");
	  }
	}}
