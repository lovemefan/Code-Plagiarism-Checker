import java.util.Scanner;
public class Task3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1 and y1 : ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		System.out.print("Enter x2 and y2 : ");
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = (a-c)*(a-c)+(b-d)*(b-d);
		double f = Math.pow(e, 0.5);
		System.out.println("The distance between the two points is " + f);	
}
}
