package yangyufei;
import java.util.Scanner;
public class Work {

	public static void main( String [] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a,b,c");
		   double a = input.nextDouble();
		   double b = input.nextDouble();
		   double c = input.nextDouble();
		   double d = Math.pow(b*b-4*a*c, 0.5);
		   double r1 = (-b+d)/2*a;
		   double r2 = (-b-d)/2*a;
		   if (d>0){
			   System.out.println("The equaion has tow roots "+r1+" and "+r2);
		   }
		   if (d==0){
			   System.out.println("The equaion has one roots "+r1);
		   }
		   else {
			   System.out.println("The equaion has no roots");
		   }
	}
}
