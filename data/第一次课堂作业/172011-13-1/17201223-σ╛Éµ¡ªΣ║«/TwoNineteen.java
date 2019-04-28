import java.util.Scanner;
public class TwoNineteen {
	public static void main(String[] args){
		double a,b,c,d,e,f,s,area;
		Scanner input =new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		a=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		b=Math.pow(a, 0.5);
		c=(x1-x3)*(x1-x3)+(y1-y3)*(y1-y3);
		d=Math.pow(c, 0.5);
		e=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
		f=Math.pow(e, 0.5);
		s=(b+d+f)/2;
		area=Math.pow(s*(s-b)*(s-d)*(s-f), 0.5);
		System.out.println("The area of the triangle is "+area);
	}
}
