import java.util.Scanner;

public class RootsOfEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter a ,b ,c: ");
			double a = input.nextDouble();
			double b = input.nextDouble();
			double c = input.nextDouble();
			double x = b * b - 4 * a * c;
			double r1;
			double r2;
			if(x > 0) {
				r1 = (-b + Math.pow(x, 0.5)) / 2 * a;
				r2 = (-b - Math.pow(x, 0.5)) / 2 * a;
				System.out.println("The equation has two roots " + r1 + " and " + r2 );
			}
			else if(x == 0 ){
				r1 = -b / 2 * a;
				System.out.println("The equation has one roots " + r1);
			}
			else {
				System.out.println("The equation has no root "); 
			}
		}
		finally {
			input.close();
		}
	}

}
