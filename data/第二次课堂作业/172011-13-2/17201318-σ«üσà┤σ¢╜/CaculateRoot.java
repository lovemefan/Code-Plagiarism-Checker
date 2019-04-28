
import java.util.Scanner;

public class CaculateRoot {
	public static void main(String[] args){
		System.out.print("Enter a, b, c:");
        Scanner input = new Scanner(System.in);
        float a = input.nextFloat();
        float b = input.nextFloat();
        float c = input.nextFloat();
        try{
        	if(Math.pow(b, 2) - 4 * a * c < 0){
        		System.out.println("The equation has " + 
        	"real roots");
        	}
        	else if(Math.pow(b, 2) - 4 * a * c == 0){
        		System.out.println("The equation has one root " +
        	(float)-b / 2 * a);
        	}
        	else if(Math.pow(b, 2) - 4 * a * c > 0){
        		System.out.println("The equation has two roots " +
        	 (float)(-b + Math.pow(Math.pow(b,2) - 4 * a * c, 0.5)) / 2 * a 
        	 + " and " + (float)(-b - Math.pow(Math.pow(b,2) - 4 * a * c, 0.5)) / 2 * a);
        	}
        }
        finally{
        	input.close();
        }
		
	}
}
