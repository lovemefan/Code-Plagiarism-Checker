import java.util.Scanner;

public class Roots {
	public static void main(String[] args){
		double a = 0,b = 0,c = 0,d = 0, r1 = 0, r2 = 0;
		System.out.println("Enter a, b, c");
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		d = Math.pow(b, 2) - 4 * a * c;
		if (d > 0){
			r1 = (b * (-1) + Math.pow(d, 0.5)) / (2 * a);
			r2 = (b * (-1) - Math.pow(d, 0.5)) / (2 * a);
			System.out.println("The equation has two roots "+r1+" and "+r2);
		}
		else if (d == 0){
			r1 = r2 = (b * (-1) + Math.pow(d, 0.5)) / (2 * a);
			System.out.println("The equation has one roots "+r1);
		}
		else 
			System.out.println("The equation has no real roots");
			
	}
	

}
