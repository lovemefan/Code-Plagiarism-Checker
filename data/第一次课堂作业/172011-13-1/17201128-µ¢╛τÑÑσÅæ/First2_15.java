package HomeWork;
import java.util.Scanner;
public class First2_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter x1 and y1:");
		Scanner input =new Scanner(System.in);
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.println("Entre x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double d=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2));
		System.out.println("The distance between the two points is "+d);
	}

	
}

