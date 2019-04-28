import java.util.Scanner;

public class distance {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter weight in pounds:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.println("Enter height in inches:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double dis,x,y;
		x=Math.pow(x2-x1, 2);
		y=Math.pow(y2-y1, 2);
		dis=Math.pow(x+y, 0.5);
		System.out.println("BMI is "+dis);
	}
}
