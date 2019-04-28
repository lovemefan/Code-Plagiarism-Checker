import java.util.Scanner;
public class Text_3_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double a,b,c;
	
		System.out.print("Enter a, b, c: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		double temp = b*b-4*a*c;
		if(temp > 0){
			double r1 = (-b + Math.pow(temp, 0.5)) / (2 * a);
			double r2 = (-b - Math.pow(temp, 0.5)) / (2 * a);
			System.out.printf("The equation has two roots %f and %f",r1,r2);
		}
		else if(temp == 0){
			double r = (-b + Math.pow(temp, 0.5)) / (2 * a);
			System.out.printf("The equation has one root %f",r);
		}
		else{
			System.out.print("The equation has no real roots");
		}
	}
}
