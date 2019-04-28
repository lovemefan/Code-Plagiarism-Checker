package mypackage;
import java.util.Scanner;
public class TwoFifteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter x1 and y1 :");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.println("Enter x2 and y2 :");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double a=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		System.out.println(Math.pow(a,0.5));
		

	}

}
