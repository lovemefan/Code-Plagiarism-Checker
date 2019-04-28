import java.util.Scanner;

public class Pan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the data of a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		if((Math.pow(b,2)-4*a*c)<0){
			System.out.println("The equation has no real roots");
		}
		else if((Math.pow(b,2)-4*a*c)==0){
			System.out.println("The equation has one root " + -b/(2*a));
		}
		     else{
		    	 System.out.println("The equation has two roots " + 
		     (-b+Math.pow(Math.pow(b,2)-4*a*c, 0.5))/(2*a) + " and " 
		     + (-b-Math.pow(Math.pow(b,2)-4*a*c, 0.5))/(2*a));
		     }
		

	}

}
