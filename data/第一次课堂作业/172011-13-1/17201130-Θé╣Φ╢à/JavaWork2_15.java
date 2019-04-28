package HomeWork;
import java.util.Scanner;
public class JavaWork2_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter X1 and Y1:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.println("Enter X2 and Y2:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double a = Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2);
        double distance = Math.pow(a,0.5);
        System.out.println("The distance between the two points is "+ distance); 
	}

}
