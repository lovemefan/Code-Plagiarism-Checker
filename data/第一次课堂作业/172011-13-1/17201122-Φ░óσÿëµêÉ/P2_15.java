package project;
import java.util.Scanner;
public class P2_15 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter x1 and y1: ");
		double x1,x2,y1,y2;
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.print("Enter x2 and y2: ");
        x2=input.nextDouble();
        y2=input.nextDouble();
        double distance=Math.pow((Math.pow((x1-x2), 2)+Math.pow((y1-y2),2)),0.5);
        System.out.println("The distance between the points is "+distance);
        input.close();
	}

}
