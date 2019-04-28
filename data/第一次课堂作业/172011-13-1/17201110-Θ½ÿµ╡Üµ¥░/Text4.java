package Text1;

import java.util.Scanner;

public class Text4 {
   public static void main(String args[]) {
	   Scanner input = new Scanner(System.in);
       System.out.println("Enter x1 and y1 :");
       double x1 = input.nextDouble();
       double y1 = input.nextDouble();
       System.out.println("Enter x2 and y2 :");
       double x2 = input.nextDouble();
       double y2 = input.nextDouble();
       System.out.println("Enter x3 and y3 :");
       double x3 = input.nextDouble();
       double y3 = input.nextDouble();
       double distance1 = Math.pow(( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) ),0.5);
       double distance2 = Math.pow(( Math.pow(x3-x1,2) + Math.pow(y3-y1,2) ),0.5);
       double distance3 = Math.pow(( Math.pow(x3-x2,2) + Math.pow(y3-y2,2) ),0.5);
       double s = (distance1 + distance2 + distance3 ) / 2;
       double S = Math.pow(s * (s - distance1) * (s - distance2) * (s - distance3),0.5);
       String S1 = String .format("%.1f",S);
       double S2 = Double.parseDouble(S1);
       System.out.println("The area of the triangle is " + S2);
   }
   
}
