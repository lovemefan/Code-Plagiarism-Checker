package test;
import java.util.Scanner;

public class exe2_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x1,y1,x2,y2;
		System.out.print("Enter x1 and y1 :");
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.print("Enter x2 and y2 :");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double dis,a;
		a=Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
		dis=Math.pow(a, 0.5);
		System.out.println("The distance between the two points is "+dis);
}
}