import java.util.Scanner;
public class Three1 {
	
     public static void main(String[] args){
    	 System.out.println("please enter the a,b,and c:");
    	 Scanner input = new Scanner(System.in);
    	 double a = input.nextDouble();
    	 double b = input.nextDouble();
    	 double c = input.nextDouble();
    	 double delta = b*b-4*a*c;
    	 if (delta > 0)
    	     System.out.println("X1 = " +(delta-b)/2*a + " x2 = " + (-delta-b)/2*a);
    	 else if (delta == 0)
    		 System.out.println("x = " + (-b)/2*a);
    	 else if(delta < 0)
    		 System.out.println("The equation has no real roots");
     }
}
