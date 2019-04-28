import java.util.Scanner;
public class Test31 {

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a,b,c");
			double a = input.nextDouble();
			double b = input.nextDouble();
			double c = input.nextDouble();
			double i1 = (-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
			double i2 = (-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);	
			if((b*b-4*a*c)>0){
				System.out.println("The euation has two roots"+i1+i2);}
			else if((b*b-4*a*c) == 0){
				System.out.println("The euation has one roots"+i1);}
			else {
				System.out.println("The euation has no real roots");}
		}
	}

