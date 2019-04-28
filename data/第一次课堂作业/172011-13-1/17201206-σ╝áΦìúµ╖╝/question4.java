package class1;

import java.util.Scanner;

public class question4 {
	public static void main(String[] args){
		  
		  Scanner input =new Scanner(System.in);
		  System.out.print("Enter three points for a triangle: ");
		  double x1=input.nextDouble();
		  double y1=input.nextDouble();
		  double x2=input.nextDouble();
		  double y2=input.nextDouble();
		  double x3=input.nextDouble();
		  double y3=input.nextDouble();
		  double j1=Math.pow(x2-x1,2);
		  double i1=Math.pow(y2-y1,2);
		  double k1=Math.pow(i1+j1, 0.5);
		  double j2=Math.pow(x3-x1,2);
		  double i2=Math.pow(y3-y1,2);
		  double k2=Math.pow(i2+j2, 0.5);
		  double j3=Math.pow(x3-x2,2);
		  double i3=Math.pow(y3-y2,2);
		  double k3=Math.pow(i3+j3, 0.5);
		  double s=(k1+k2+k3)/2;
		  double S=Math.pow(s*(s-k1)*(s-k2)*(s-k3), 0.5);
		  System.out.println("The area of the triangle is ");
		  System.out.println(String.format("%.1f", S));

     }
}
