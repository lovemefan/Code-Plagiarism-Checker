import java.util.Scanner;

public class Exe2_15 {
	public static void main(String[] args) {
		//Create a Scanner object
		Scanner input = new Scanner(System.in);
				
		//Prompt the user to enter x1 and y1
		System.out.print("Enter x1 and y1: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		System.out.print("Enter x2 and y2: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		double distance = Math.pow((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)), 0.5);
		
		System.out.println("The distance between two points is " + distance);
		
	}
}
