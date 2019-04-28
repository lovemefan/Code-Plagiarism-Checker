package ClassWork1;

import java.util.Scanner;

public class ClassWork2_15 {
	public static void main(String[] args){
		double x1,y1,x2,y2;
		System.out.println("Enter x1 and y1:");
		Scanner input=new Scanner(System.in);
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.println("Enter x2 and y2");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double distance=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		System.out.println("The distance between tow the points is:"+distance);
	}

}
