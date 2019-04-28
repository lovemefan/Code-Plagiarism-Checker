
import java.util.Scanner;
public class Equation {
	public static void main(String [] agrs){
		double a=0;
		double b=0;
		double c=0;
		System.out.println("Enter three numbers for the equation:");
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		double r1 = (-b+Math.sqrt((Math.pow(b, 2)-4*a*c)))/2*a;
		double r2 = (-b-Math.sqrt((Math.pow(b, 2)-4*a*c)))/2*a;
		double Criterion = Math.pow(b, 2)-4*a*c;
		if (Criterion>0){
			System.out.println("root1:" + r1 +"root2:" + r2);
		}else if (Criterion==0){
				System.out.println("root:" + r1);
			}else if (Criterion<0){
					System.out.println("The equation has no real roots");
				}
			
	}

}
