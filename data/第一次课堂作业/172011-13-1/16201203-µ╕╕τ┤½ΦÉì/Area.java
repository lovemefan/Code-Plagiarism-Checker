package onetime;
import java.util.Scanner;
public class Area {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double x1=scan.nextDouble();
		double y1=scan.nextDouble();
		double x2=scan.nextDouble();
		double y2=scan.nextDouble();
		double x3=scan.nextDouble();
		double y3=scan.nextDouble();
		double a1=Math.pow((Math.pow(x1-x2,2)+Math.pow(y1-y2, 2)), 0.5);
		double a2=Math.pow((Math.pow(x1-x3,2)+Math.pow(y1-y3, 2)), 0.5);
		double a3=Math.pow((Math.pow(x2-x3,2)+Math.pow(y2-y3, 2)), 0.5);
		double s=(a1+a2+a3)/2;
		double area=Math.pow(s*(s-a1)*(s-a2)*(s-a3), 0.5);
		System.out.println("The area of the triangle is"+area);
	}

}
