import java.util.Scanner;
public class Area {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter three points for a triangle:");
	double x1 = input.nextDouble();
	double y1 = input.nextDouble();
	double x2 = input.nextDouble();
	double y2 = input.nextDouble();
	double x3 = input.nextDouble();
	double y3 = input.nextDouble();
	double s1,s2,s3,s,a;
	s1 = Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
	s2 = Math.pow((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3), 0.5);
	s3 = Math.pow((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3), 0.5);
	s = (s1+s2+s3)/2.0;
	a = Math.pow(s*(s-s1)*(s-s2)*(s-s3),0.5);
	String str = String.format("%.1f",a);
	System.out.print("The area of the trianle is " + str);
	}
}
