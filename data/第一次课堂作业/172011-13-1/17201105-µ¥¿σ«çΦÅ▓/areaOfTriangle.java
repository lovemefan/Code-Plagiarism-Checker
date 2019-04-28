package yangyufei;
import java.util.Scanner;
public class areaOfTriangle {

		public static void main(String[] args) {
			System.out.print("Enter three points for a triangle: ");
			Scanner input = new Scanner(System.in);
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double x3 = input.nextDouble();
			double y3 = input.nextDouble();
			double a = Math.pow( ( Math.pow ( (x2-x1) , 2 ) + Math.pow( (y2-y1) , 2 ) ),0.5);
			double b = Math.pow( ( Math.pow ( (x3-x2) , 2 ) + Math.pow( (y3-y2) , 2 ) ),0.5);
			double c = Math.pow( ( Math.pow ( (x1-x3) , 2 ) + Math.pow( (y1-y3) , 2 ) ),0.5);
			double s = ( a + b + c ) / 2;
			double area = Math.pow(( s * ( s - a ) * ( s - b ) * ( s - c ) ),0.5);
			System.out.print("The area of the triangle is " +  area);
		}

	}