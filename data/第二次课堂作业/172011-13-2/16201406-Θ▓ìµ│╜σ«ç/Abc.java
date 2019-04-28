import java.util.Scanner;

class Abc {
	public static void main(String[] args) {
		System.out.println("Enter a,b,c:");
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = b*b-4*a*c;
		double r1 = (-b+Math.pow(d, 0.5))/2*a;
		double r2 = (-b-Math.pow(d, 0.5))/2*a;
		if(d>0)
			System.out.println("The equation has two roots " + r1 + " and " + r2);
		else if(d==0)
			System.out.println("The equation has one root " + r1);
		else if(d<0)
			System.out.println("The equation has no real roots");
	
	}
	

}
