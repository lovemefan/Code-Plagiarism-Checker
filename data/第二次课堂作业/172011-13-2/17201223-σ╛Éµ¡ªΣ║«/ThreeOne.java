package homework;
import java.util.Scanner;
public class ThreeOne {
	public static void main(String[] args){
		double d,r1,r2;
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a,b,c:");
     double a=input.nextDouble();
     double b=input.nextDouble();
     double c=input.nextDouble();
     d=Math.pow(b,2)-4*a*c;
     r1=(-b+Math.pow(d,0.5))/(2*a);
     r2=(-b-Math.pow(d,0.5))/(2*a);
      if(d>0)
    	  System.out.println("The equation has two roots.r1="+ r1 +",r2="+r2);
      else if(d<0)
    	  System.out.println("The equation has one root.r="+r1);
      else
    	  System.out.println("The equation has no real roots.");
      
  }
}