import java.util.Scanner;

public class points {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter x1 and y1");
		double x11 = input.nextDouble();
		double y11 = input.nextDouble();
		
		System.out.println("Please enter x2 and y2");
		double x12 = input.nextDouble();
		double y12 = input.nextDouble();
		double i = (x12-x11)*(x12-x11)+(y12-y11)*(y12-y11);
		double point = Math.pow(i, 0.5);
		
		System.out.println("The distance the two points is " + point);
	}
}
