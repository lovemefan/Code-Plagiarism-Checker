package Text;

import java.util.Scanner;

public class Text1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a, b ,c :");
    float a = input.nextFloat();
    float b = input.nextFloat();
    float c = input.nextFloat();
     float d = b * b - 4 * a * c; 
      if(d > 0) {
    	  float r1 = (float) ((-b + Math.pow(d, 0.5f)) / 2f * a);
    	  float r2 = (float) ((-b - Math.pow(d, 0.5f)) / 2f * a);
           System.out.println("The equation has two roots " + r1 + "and" + r2);
        }
         else if(d < 0){
    	  System.out.println("The equation has on real roots ");
      }
           else {
        	   float r3 = -b /( 2 * a );
        	   System.out.println("The equation has one roots " + r3);
           }
    }
}
