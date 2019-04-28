package HW;

import java.util.Scanner;

public class Hw_9_9 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		RegularPloygon rp1 = new RegularPloygon();
		RegularPloygon rp2 = new RegularPloygon(6,4);
		RegularPloygon rp3 = new RegularPloygon(10,4,5.6,7.8);
		
		rp1.showRP(rp1);
		rp2.showRP(rp2);
		rp3.showRP(rp3);
		
	}
}
class RegularPloygon  {
	private int n = 3;
	private double size  = 1 ;
	private double x  = 0 ;
	private double y  = 0 ;
	
	RegularPloygon (){
		int n = 3;
		double size  = 1 ;
		double x  = 0 ;
		double y  = 0 ;
	}	
	
	RegularPloygon (int n,double size,double x,double y) {
		this.n = n;
		this.size = size;
		this.x  = x ;
		this.y = y;
	}
	RegularPloygon (int n,double size) {
		this.n = n;
		this.size = size;
		double x  = 0 ;
		double y = 0;
	}
	
	
	double getPerimeter (int n,double size,double x,double y) {
		return (double)n * size ;
	}
	double getArea (int n,double size,double x,double y) {
		return ((n * size * size) / (4 * Math.tan(Math.PI / n)));
	}
	
	void showRP (RegularPloygon rp1){
		System.out.println("The perimeter is " + rp1.getPerimeter(n, size, x, y) + "\nThe area is " + rp1.getArea(n, size, x, y));
		}
	}