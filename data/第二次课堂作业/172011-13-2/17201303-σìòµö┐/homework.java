import java.util.Scanner;
public class homework {
	private static Scanner input;
	public static void main(String[] args){
		System.out.println("Enter a,b,c");
		Scanner input=new Scanner(System.in);
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d=Math.pow(b, 2)-4*a*c;
		if(d<0){
			System.out.println("The equation has no real roots");
		}
		else if (d==0){
			double r =(-b+Math.pow(d, 0.5))/2*a;
			System.out.println("The equation has one real root"+r);
		}
		else{
			double r1 = (-b+Math.pow(d, 0.5))/2*a;
			double r2 = (-b-Math.pow(d, 0.5))/2*a;
			System.out.println("The equation has two real roots"+ r1 +"and" + r2 );
		}
	}
}
