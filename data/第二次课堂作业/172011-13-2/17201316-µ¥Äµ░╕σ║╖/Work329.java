package Work329;
import java.util.Scanner;

public class Work329 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter circle1's center x-,y-coordinates,and radius:");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.print("Enter circle2's center x-,y-coordinates,and radius:");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		if(Math.abs(r1-r2) >= Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2))) {
			System.out.println("circle2 is inside circle1");
		}
		else if(Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2)) <= r1+r2) {
			System.out.println("circle2 is overlaps circle1");
		}
		else {
			System.out.println("circle2 dose not overlaps circle1");
		}
	}
}
