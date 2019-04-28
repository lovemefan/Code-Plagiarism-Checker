import java.util.Scanner;

public class area {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three points for a triangle:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
//		double x,y,z,a,b;
//		a=Math.pow(x2-x1, 2);
//		b=Math.pow(y2-y1, 2);
//		x=Math.pow(a+b, 0.5);
//		a=Math.pow(x3-x1, 2);
//		b=Math.pow(y3-y1, 2);
//		y=Math.pow(a+b, 0.5);
//		a=Math.pow(x2-x3, 2);
//		b=Math.pow(y2-y3, 2);
//		z=Math.pow(a+b, 0.5);
//      double ans,temp,s;
//		s=(x+y+z)/2;
//		temp = s*(s-x)*(s-y)*(s-z);
//		ans=Math.pow(temp, 0.5);
		double ans;
		ans=Math.abs(x1*y2-y1*x2+x2*y3-y2*x3+x3*y1-y3*x1)/2;
		System.out.println("The area of the triangle is "+ans);
	}
}
