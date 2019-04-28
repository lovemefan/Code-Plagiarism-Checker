import java.util.Scanner;
public class Function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double derta,r1,r2;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a, b, c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		derta = Math.pow(b, 2) - 4 * a * c;
		if(derta < 0){
			System.out.println("The equation has no real roots");
		}
		else if(derta == 0){
			System.out.println("The equation has one root " + (-b / (2 * a)));
		}
		else{
			System.out.println("The equation has two roots " + ((-b + Math.pow(derta, 0.5)) / (2 * a)) + " and " + ((-b - Math.pow(derta, 0.5)) / (2 * a)));
		}
	}

}
