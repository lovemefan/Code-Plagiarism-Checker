package triangleArea;

import java.util.Scanner;

public class TriangleArea {
	public static void main(String[] args){
		double area,s;
		double[] point = new double[6]; 
		System.out.println("Enter three points for a triangle:");
		Scanner input = new Scanner(System.in);
		for(int i = 0;i < 6; i++){
			point[i] = input.nextDouble();
		}
		double d = Math.pow(Math.pow(point[2] - point[0], 2)+Math.pow(point[3] - point[1], 2), 0.5);
		double d1 = Math.pow(Math.pow(point[4] - point[0], 2)+Math.pow(point[5] - point[1], 2), 0.5);
		double d2 = Math.pow(Math.pow(point[4] - point[2], 2)+Math.pow(point[5] - point[3], 2), 0.5);
		s = (d+d1+d2)/2;
		area = Math.pow(s*(s-d)*(s-d1)*(s-d2), 0.5);
		System.out.printf("The area of the triangle is %4.1f",area);
		
	}

}
