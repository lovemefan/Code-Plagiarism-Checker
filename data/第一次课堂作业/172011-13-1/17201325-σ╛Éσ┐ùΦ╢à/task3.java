package xuzhichao;

import java.util.Scanner;
public class task3 {
	public static void main(String[] args){
		System.out.print("Enter three points for a triangle:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double a = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		double b = Math.pow((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1),0.5);
		double c = Math.pow((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2),0.5);
		double s = (a+b+c)/2;
		double area = Math.pow((s*(s-a)*(s-b)*(s-c)), 0.5);
		System.out.print("The area of the triangle is:" + area);
		if(input != null){
    		input.close();
		}
	}

}
