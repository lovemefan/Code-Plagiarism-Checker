package project;
import java.util.Scanner;
public class P2_19 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
        double x1,x2,x3,y1,y2,y3;
        x1=input.nextDouble();
        y1=input.nextDouble();
        x2=input.nextDouble();
        y2=input.nextDouble();
        x3=input.nextDouble();
        y3=input.nextDouble();
        double line1=Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
        double line2=Math.pow(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2), 0.5);
        double line3=Math.pow(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2), 0.5);
 	    double s=(line1+line2+line3)/2;
 	    double area=Math.pow(s*(s-line1)*(s-line2)*(s-line3),0.5);
 	    System.out.println("The area of the triangle is "+(float)area);
 	    input.close();
	}

}
