import java.util.Scanner;

public class $3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		double num1 = b * b - 4 * a * c;
		
		double area=Math.pow(num1, 0.5);
		
		double r1 = ((0 - b) + area)/(2 * a) ;
		double r2 = ((0 - b) - area)/(2 * a) ;
		
		if(area >= 0){
			if(area > 0){
				System.out.println("The equation has two roots" + r1 + " and " + r2);
				
			}
			else{
				System.out.println("The equation has one root" + r1);
			}
			
		}
		else{
			System.out.println("The equation has no real roots");
		}
		if (input !=null){
			input.close();

	}
	}
}
