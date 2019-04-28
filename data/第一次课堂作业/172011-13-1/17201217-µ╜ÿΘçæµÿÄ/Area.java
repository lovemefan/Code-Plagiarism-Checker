import java.util.Scanner;
public class Area {
    private static Scanner input;

	public static void main(String[] args) {
	    input = new Scanner(System.in);
	    System.out.printf("Enter three points for a triangle: x1 y1 x2 y2 x3 y3");
	    double x1=input.nextDouble();
	    double y1=input.nextDouble();
	    double x2=input.nextDouble();
	    double y2=input.nextDouble();
	    double x3=input.nextDouble();
	    double y3=input.nextDouble();
	    //s1,s2,s3分别为三条边，a,b,c为中间变量,area表示其面积
	    double a1=x1-x2;
		double b1=y1-y2;
		double c1=Math.pow(a1, 2)+Math.pow(b1, 2);
		double s1=Math.pow(c1, 0.5);
		double a2=x1-x3;
		double b2=y1-y3;
		double c2=Math.pow(a2, 2)+Math.pow(b2, 2);
		double s2=Math.pow(c2, 0.5);
		double a3=x3-x2;
		double b3=y3-y2;
		double c3=Math.pow(a3, 2)+Math.pow(b3, 2);
		double s3=Math.pow(c3, 0.5);
		double s=(s1+s2+s3)/2;
		double area=Math.pow(s*(s-s1)*(s-s2)*(s-s3), 0.5);
		System.out.println("The area of the triangle is " + area);
}
}
