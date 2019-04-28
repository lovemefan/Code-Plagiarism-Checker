import java.util.Scanner;
public class Text_19 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
		double x1 = input.nextDouble(),y1 = input.nextDouble(),x2 = input.nextDouble(),y2 = input.nextDouble(),x3 = input.nextDouble(),y3 = input.nextDouble();
		double d1 = Math.pow(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0), 0.5);
		double d2 =  Math.pow(Math.pow(x3 - x1, 2.0) + Math.pow(y3 - y1, 2.0), 0.5);
		double d3 =  Math.pow(Math.pow(x2 - x3, 2.0) + Math.pow(y2 - y3, 2.0), 0.5);
		double s = (d1 + d2 + d3) / 2;
		double ANS = Math.pow(s * (s - d1) * ( s - d2) * (s - d3), 0.5)
;		System.out.printf("The area of the triangle is %.1f", ANS);
	}
}