package hw;
	import java.util.Scanner; 
	
	import java.text.DecimalFormat;
	
public class Hw_2_19 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("Enter three points for a triangle:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double l1 = Math.pow(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)),0.5);
		double l2 = Math.pow(((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2)),0.5);
		double l3 = Math.pow(((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3)),0.5);
		double s = ( l1 + l2 + l3 ) / 2;
 		double area = Math.pow( (s * ( s- l1 ) * (s - l2) *(s - l3)),0.5);
 		
		System.out.println("The area of the triangle is " + df.format(area));
		//1.5 -3.4 4.6 5 9.5 -3.4
	}
}
