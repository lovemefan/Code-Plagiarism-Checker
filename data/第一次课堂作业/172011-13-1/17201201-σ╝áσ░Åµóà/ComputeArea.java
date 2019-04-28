import java.util.Scanner;

public class ComputeArea {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
        double b1,b2,b3,s,area;
        b1 =Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
        b2 =Math.pow(Math.pow(x3-x1,2)+Math.pow(y3-y1,2),0.5);
        b3 =Math.pow(Math.pow(x2-x3,2)+Math.pow(y2-y3,2),0.5);
        s = (b1+b2+b3)/2;
        area = Math.pow(s*(s-b1)*(s-b2)*(s-b3),0.5);
        System.out.println("The area of the triangle is " + area);
	}

}
