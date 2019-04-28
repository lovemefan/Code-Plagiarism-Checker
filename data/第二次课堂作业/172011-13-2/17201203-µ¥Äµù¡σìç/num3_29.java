package ¿ÎÌÃ×÷Òµ;
import java.util.Scanner;
public class num3_29 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		 System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
		 double x1,y1,r1;
		 x1 =input.nextDouble();
    	 y1 =input.nextDouble();
    	 r1 =input.nextDouble();
    	 System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
    	 double x2,y2,r2,a,b,c;
    	 x2 =input.nextDouble();
    	 y2 =input.nextDouble();
    	 r2 =input.nextDouble();
    	 a = Math.pow(x1-x2,2);
    	 b = Math.pow(y1-y2,2);
    	 c = Math.pow(a+b,0.5);
    	 if (Math.abs(r1-r2)>=c){
    		 System.out.print("circle2 overlaps circle1");
    	 }
    	 else if(c <= r1+r2){
    		 System.out.println("circle2 overlaps circle");
    	 }
    	 else
    		 System.out.println("circle2 does not overlap circle");
	}

}
