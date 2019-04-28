package text;

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter x1 and y1:");
		Scanner in=new Scanner(System.in);
		float x1=in.nextFloat();
		float y1=in.nextFloat();
		System.out.print("Enter x2 and y2:");
		float x2=in.nextFloat();
		float y2=in.nextFloat();
		System.out.print("The distance between the two points is "+Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5));
	}

}
