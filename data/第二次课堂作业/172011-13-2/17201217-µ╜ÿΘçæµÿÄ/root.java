import java.util.Scanner;
public class root {
    private static Scanner input;

	public static void main(String[] args) {
	    input = new Scanner(System.in);
	    System.out.print("Enter a,b,c:");
	    double a=input.nextDouble();
	    double b=input.nextDouble();
	    double c=input.nextDouble();
	    double d=b*b-4*a*c;
	    if(d<0){
	    	System.out.println("The equation has no real roots");
	    }
	    if(d==0){
	    	double r=(-b+Math.pow(d, 0.5))/(2*a);
	    	System.out.println("The equation has one roots");
	    	System.out.println("The root is " +r);
	    }
	    if(d>0){
	    	double r1=(-b-Math.pow(d, 0.5))/(2*a);
	    	double r2=(-b+Math.pow(d, 0.5))/(2*a);
	    	System.out.println("The equation has two roots");
	    	System.out.println("The root is" + r1 +r2);
	    }
    }
}
