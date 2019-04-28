package HomeWork;
import java.util.Scanner;
public class First2_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Entre three points for a triangle:");
		Scanner input=new Scanner(System.in);
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double b1=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2));
		double b2=Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1), 2));
		double b3=Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3), 2));
		double s=(b1+b2+b3)/2;
		double area=Math.sqrt(s*(s-b1)*(s-b2)*(s-b3));
		System.out.println("The area of the triangle is "+area);
	}

}
