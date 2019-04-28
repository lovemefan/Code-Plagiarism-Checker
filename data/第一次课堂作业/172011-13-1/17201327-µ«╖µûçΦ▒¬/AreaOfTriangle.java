import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
		System.out.print("Enter three points for a triangle:");
		Scanner input = new Scanner(System.in);
		double[] points = new double[6];
		double distance1,distance2,distance3;
		while (true) {
			for (int i = 0;i < 6;i++) {
				points[i] = input.nextDouble();
			}
			//计算三条边的长
		    distance1 = Math.sqrt(Math.pow(points[0]-points[2],2) + Math.pow(points[1]-points[3],2));
			distance2 = Math.sqrt(Math.pow(points[0]-points[4],2) + Math.pow(points[1]-points[5],2));
			distance3 = Math.sqrt(Math.pow(points[2]-points[4],2) + Math.pow(points[3]-points[5],2));
			if ((distance1 + distance2) > distance3 && (distance1 + distance3) > distance2 && (distance2 + distance3) > distance1) {
				break;
			}
			else {
				System.out.print("This is not a triangle\nEnter three points for a triangle:");
			}
		}
		double s = (distance1 + distance2 +distance3) / 2;
		double area = Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
		System.out.printf("The area of the triangle is %.2f",area);
	}

}
