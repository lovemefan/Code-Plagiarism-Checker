import java.util.Scanner;
public class Equation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a , b , c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double x,x1,x2,h;
		h = b*b-4*a*c;
			if(h > 0){
			      x1 = (Math.pow(h, 0.5)-b)/(2*a);
			      x2 = (-Math.pow(h, 0.5)-b)/(2*a);
			      System.out.println("The equation has two roots " + x1 + "and" + x2);
			}
			else if(h == 0){
				x1 = x2 = (Math.pow(h, 0.5)-b)/(2*a);
				System.out.println("The equation has one root " + x1);
			}
			else
				System.out.println("The equation has no real roots");
				
				
				
	}
		

}
