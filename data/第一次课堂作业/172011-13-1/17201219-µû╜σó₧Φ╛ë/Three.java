package aaa;
import java.util.Scanner;
public class Three {
	public static void main(String[] args) {
		double x1=0,y1=0,x2=0,y2=0;
		Scanner input = new Scanner(System.in);	
		System.out.print("Enter x1 and y1: ");
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.print("Enter x2 and y2: ");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double a=Math.pow(x2-x1, 2);
		double b=Math.pow(y2-y1, 2);
		double c=Math.pow(a+b, 0.5);
		System.out.print("The distance bewteen the two points is "+ c);
	}

}
