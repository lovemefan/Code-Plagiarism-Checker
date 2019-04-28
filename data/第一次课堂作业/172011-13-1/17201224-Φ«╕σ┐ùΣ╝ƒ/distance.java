package work;
import java.util.Scanner;
public class distance {		
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		double min = 0;
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.print("Enter x2 and y2:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		min = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1), 0.5);
		System.out.print("The distacne between the two points is: " + min);
	}
}
