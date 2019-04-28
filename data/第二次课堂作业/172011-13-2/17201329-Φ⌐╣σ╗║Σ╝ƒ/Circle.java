
import java.util.Scanner;

public class Circle {
	public static void main(String [] args){
		double x1;
		double y1;
		double x2;
		double y2;
		double r1;
		double r2;
		System.out.println("Enter two points and radius of circle(x1,y1),(x2,y2),r1,r2:");
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		r1 = input.nextDouble();
		r2 = input.nextDouble();
		if (Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2))>=(r1+r2)){
			System.out.println("The two circles separate each other");
		}else if ((Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2))+r1)<=r2){
			System.out.println("The two circles ,one contains another");
		}else if ((Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2))+r2)<=r1){
			System.out.println("The two circles ,one contains another");
		}else{
			System.out.println("The two circles is overlaped");
		}
	}

}
