package HomeWork;
import java.util.Scanner;
public class JavaWork2_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter three points for a triangle:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double a = Math.pow(x2-x1,2)+Math.pow(y2-y1,2);
		double b = Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2);
		double c = Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2);
		double a1 = Math.pow(a,0.5);
		double b1 = Math.pow(b,0.5);
		double c1 = Math.pow(c,0.5);
		double s=(a1+b1+c1)/2;
		double area =Math.pow(s*(s-a1)*(s-b1)*(s-c1), 0.5);
		System.out.println("the area of the triangle is "+area);	
	}

}
