import java.util.Scanner;

public class HomeWorkThree {
	
	public static void main(String args[]) {
		double x1,y1,x2,y2,ans;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter x1 and y1:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		
		System.out.println("Enter x2 and y2:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		
		ans = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2));
		System.out.println("The distance between the two points is " + ans);
	}
}