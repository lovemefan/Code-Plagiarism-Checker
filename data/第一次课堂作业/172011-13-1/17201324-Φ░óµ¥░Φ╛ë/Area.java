package text;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter three points for a triangle:");
		Scanner in=new Scanner(System.in);
		float x1=in.nextFloat();
		float y1=in.nextFloat();
		float x2=in.nextFloat();
		float y2=in.nextFloat();
		float x3=in.nextFloat();
		float y3=in.nextFloat();
		double len1=Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		double len2=Math.pow(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2), 0.5);
		double len3=Math.pow(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2), 0.5);
		double s=(len1+len2+len3)/2;
		System.out.print("the area of the triangle is ");
		System.out.println(String.format("%.1f", (float)Math.pow(s*(s-len1)*(s-len2)*(s-len3), 0.5)));

	}

}
