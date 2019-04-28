
import java.util.Scanner;

public class Distance {
	public static void main(String[] agrs){
		int x1;
		int x2;
		int y1;
		int y2;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter x1 and y1:");
		x1 = input.nextInt();
		y1 = input.nextInt();
		System.out.println("Enter x2 and y2:");
		x2 = input.nextInt();
		y2 = input.nextInt();
		double distance=Math.pow((int)Math.pow(x2-x1, 2)+(int)Math.pow(y2-y1, 2),0.5);
		System.out.println("The distance of the two points is "+distance);
	}

}
