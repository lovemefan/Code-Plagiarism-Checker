import java.util.Scanner;

public class SolveEquations{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a , b , c:");
		double a = input.nextDouble() , b = input.nextDouble() , c = input.nextDouble();
		if((Math.pow(b, 2)-4*a*c)>0){
			double r1 = (-b+Math.pow((Math.pow(b, 2)-4*a*c), 0.5)) / 2*a;
			double r2 = (-b+Math.pow((Math.pow(b, 2)-4*a*c), 0.5)) / 2*a;
			System.out.print("The equation has two toots " + r1 + " and " + r2);
		}
		else if((Math.pow(b, 2)-4*a*c) == 0){
			double r = -b / 2*a;
			System.out.print("The equation has one root " + r);
		}
		else
			System.out.print("The equation has no real toots");
		
	}
	

}
