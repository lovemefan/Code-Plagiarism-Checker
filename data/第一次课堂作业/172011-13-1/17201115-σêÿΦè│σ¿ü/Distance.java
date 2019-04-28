package dame;

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        System.out.println("Enter x1 and y1:");
         double x1 = input.nextDouble();
         double y1 = input.nextDouble();
        System.out.println("Enter x2 and y2:");
         double x2 = input.nextDouble();
         double y2 = input.nextDouble();
        double distance = Math.pow((Math.pow((x1-x2),2)+Math.pow((y1-y2),2)),0.5);
        System.out.println("The distance between the tow points is "+distance);
	}

}
