import java.util.Scanner;

public class Seatwork3 {
	public static void main(String args[]) {
		System.out.println("Please enter x1 and y1");
		double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		Scanner input1 = new Scanner(System.in);
		x1 = input1.nextDouble();
		y1 = input1.nextDouble();
		System.out.println("Please enter x2 and y2");
		Scanner input2 = new Scanner(System.in);
		x2 = input2.nextDouble();
		y2 = input2.nextDouble();
		double dis = 0;
		dis = Math.pow( Math.pow((x1-x2),2) + Math.pow(y1-y2,2), 0.5);
		System.out.println("The distance between the two points is " + dis);
	}
}
