import java.util.Scanner;
public class Class3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        double a,b,c;
        System.out.println("Enter a b c:");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        double flag=b*b-4*a*c;
        if (flag>0)
        {
        	double v1=(-b+Math.pow(flag, 0.5))/(2*a);
        	double v2=(-b-Math.pow(flag, 0.5))/(2*a);
        	System.out.println("The equation has two roots " + v1 + " and " + v2);
        }
        else if (flag==0)
        {
        	double v1=v1=(-b+Math.pow(flag, 0.5))/(2*a);
        	System.out.println("The equation has one root " + v1);
        }
        else 
        {
        	System.out.println("The equation has no real roots");
        }
	}
}
