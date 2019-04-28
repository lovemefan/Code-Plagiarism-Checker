import java.util.Scanner;
public class Distance {
private static Scanner input;

public static void main(String[] args) {
	input = new Scanner(System.in);
	System.out.print("Enter x1 and y1:");
	//System.out.println("Enter x2 and y2:");
	double x1=input.nextDouble();
	double y1=input.nextDouble();
	System.out.print("Enter x2 and y2£º");
	double x2=input.nextDouble();
	double y2=input.nextDouble();
	double x=x1-x2;
	double y=y1-y2;
	double c=Math.pow(x, 2)+Math.pow(y, 2);
	double distance=Math.pow(c, 0.5);
	System.out.println("The distance between the two points is" + distance);
}
}
