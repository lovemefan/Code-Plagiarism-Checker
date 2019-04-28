package dmz;
import java.util.Scanner;
public class Problem2_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle : ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double s = (distanceBetweenTwoPoints(x1,x2,y1,y2) + distanceBetweenTwoPoints(x1,x3,y1,y3) + distanceBetweenTwoPoints(x3,x2,y3,y2))/2;
		double area = Math.sqrt(s * (s - distanceBetweenTwoPoints(x1,x2,y1,y2)) * (s - distanceBetweenTwoPoints(x1,x3,y1,y3)) * (s - distanceBetweenTwoPoints(x3,x2,y3,y2)));
		System.out.printf("THe area of the triangle is %2.1f",area);
	}
	public static double distanceBetweenTwoPoints(double a,double b,double c,double d) {
		return (Math.sqrt(Math.pow((b - a),2) + Math.pow((d - c),2)));
	}
}
