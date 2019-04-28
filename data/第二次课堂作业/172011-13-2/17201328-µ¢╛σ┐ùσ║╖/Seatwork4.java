import java.util.Scanner;

public class Seatwork4 {
	public static void main(String[] args){
		System.out.println("Enter the circle1's x-,y-coordinates, and radius");
		double x1 = 0, y1 = 0, radius1 = 0;
		Scanner input1 = new Scanner(System.in);
		x1 = input1.nextDouble();
		y1 = input1.nextDouble();
		radius1 = input1.nextDouble();
		System.out.println("Enter the circle2's x-,y-coordinates, and radius");
		Scanner input2 = new Scanner(System.in);
		double x2 = 0, y2 = 0, radius2 = 0;
		x2 = input2.nextDouble();
		y2 = input2.nextDouble();
		radius2 = input2.nextDouble();
		double distance = 0;
		distance = Math.pow( (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ), 0.5);
		if (distance < Math.abs(radius1-radius2) || distance == Math.abs(radius1-radius2)){
				System.out.println("circle2 is inside circle1");
		}
		else if ( distance < (radius1 + radius2) || distance == (radius1 + radius2) ){
			System.out.println("circle2 overlaps circle1");
		}
		else {
			System.out.println("circle2 does not overlaps circle1");
		}
	}
}
