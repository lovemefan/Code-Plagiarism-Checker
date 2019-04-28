package text;
import java.util.Scanner;
public class num2_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1,x2,y1,y2;
		System.out.println("Enter x1 and y1 :");
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.print("Enter x2 and y2 :");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double a,b,c;
		a=Math.pow(x2-x1,2);
		b=Math.pow(y1-y2,2);
		c=Math.pow(a+b,0.5);
		System.out.println("The distance between the two points is "+c);
	}
}
