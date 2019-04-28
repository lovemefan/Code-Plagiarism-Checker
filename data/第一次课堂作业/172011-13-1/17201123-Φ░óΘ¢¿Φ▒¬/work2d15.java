package work;

import java.util.Scanner;
public class work2d15 {
	public static void main(String args[]){
		System.out.println("plz enter the first(x,y):");
		
		Scanner enter = new Scanner(System.in);
		double x1= enter.nextDouble();
		double y1= enter.nextDouble();
		
		System.out.println("plz enter the second(x,y):");
		
		double x2= enter.nextDouble();
		double y2= enter.nextDouble();
		
		double ans=Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1),2));
		System.out.print("The distance between the two points is "+ans);

	}
	
}
