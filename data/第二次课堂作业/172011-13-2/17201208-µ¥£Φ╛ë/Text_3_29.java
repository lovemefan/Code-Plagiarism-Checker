import java.util.Scanner;
public class Text_3_29 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1,y1,r1,x2,y2,r2;
		System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
		x1 = input.nextDouble();y1 = input.nextDouble();r1 = input.nextDouble();
		System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
		x2 = input.nextDouble();y2 = input.nextDouble();r2 = input.nextDouble();
		double dis = Math.pow((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5);
		if(dis <= Math.abs(r1 - r2))
			System.out.print("circle2 is inside circle1");
		else if(dis <= r1 + r2)
			System.out.print("circle2 overlaps circle1");
		else
			System.out.print("circle2 does not overlaps circle1");
	}
}