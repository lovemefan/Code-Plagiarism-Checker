import java.util.Scanner;
public class TwoFifteen {
	public static void main(String[] args){
		double a,b;
		System.out.print("Enter x1 and y1:");
		Scanner input =new Scanner(System.in);
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.print("Enter x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		a=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		b=Math.pow(a, 0.5);
		System.out.println("The distance between the two points is "+b);
	}
}
