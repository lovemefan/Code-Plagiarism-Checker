package work1015;

import java.util.Scanner;
public class work3d29 {
	public static void main(String args[]){
		Scanner enter=new Scanner(System.in);
		double x1,y1,r1,x2,y2,r2;
		System.out.println("Enter circle1's center x-,y-coordinates, and radius: ");
		x1=enter.nextDouble();
		y1=enter.nextDouble();
		r1=enter.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates, and radius: ");
		x2=enter.nextDouble();
		y2=enter.nextDouble();		
		r2=enter.nextDouble();
		//System.out.println(x1+" "+y1+" "+r1+" "+x2+" "+y2+" "+r2);
		
		double dis;
		dis=Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
		dis=Math.pow(dis, 0.5);
		if(dis<=Math.abs(r1-r2))
		{
			if(r1>r2)
			System.out.println("circle2 is inside circle1");
			else System.out.println("circle1 is inside circle2");
		}
		else if(dis<=r1+r2)
		{
			System.out.println("circle2 overlaps circle1");
		}
		else 
		{
			System.out.println("circle2 does not overlap circle1");
		}
	}
}
