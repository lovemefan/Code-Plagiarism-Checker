package project2;
import java.util.Scanner;
public class P3_1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a,b,c: ");
        double a=input.nextDouble();
        double b=input.nextDouble();
        double c=input.nextDouble();
        double i=b*b-4*a*c;
        if(i<0)
        {
        	System.out.println("The equation has no real roots");
        }
        else if(i==0)
        {
        	System.out.println("The equation has one root "+(-b)/(2*a));
        }
        else
        {
        	System.out.println("The equation has two roots "+((-b)+Math.pow(i, 0.5))/(2*a)+"and "+((-b)-Math.pow(i, 0.5))/(2*a));
        }
        input.close();
	}

}
