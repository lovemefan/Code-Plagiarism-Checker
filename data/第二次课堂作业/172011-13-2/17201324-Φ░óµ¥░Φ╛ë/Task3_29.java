package task;

import java.util.Scanner;

public class Task3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter circles center x-,y-coordinates,and radius:");
		double x1,y1,x2,y2,r1,r2;
		Scanner in=new Scanner(System.in);
		x1=in.nextDouble();
		y1=in.nextDouble();
		r1=in.nextDouble();
		System.out.print("Enter circles center x-,y-coordinates,and radius:");
		x2=in.nextDouble();
		y2=in.nextDouble();
		r2=in.nextDouble();
		double d=Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
		if (d<Math.abs(r1-r2)) {
			if(r1>r2) {
				System.out.println("circle2 is inside circle1");
			}else {
				System.out.println("circle1 is inside circle2");
			}
		}else if(d<=r1+r2) {
			System.out.println("circle2 overlaps circle1");
		}else {
			System.out.println("circle2 dose not overlaps circle1");
		}

	}

}
