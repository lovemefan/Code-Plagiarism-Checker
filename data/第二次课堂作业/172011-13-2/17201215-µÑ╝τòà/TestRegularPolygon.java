import java.util.Scanner;

public class TestRegularPolygon {
	public static void main(String[] args) {
		RegularPolygon r1 = new RegularPolygon();
		RegularPolygon r2 = new RegularPolygon();
		RegularPolygon r3 = new RegularPolygon();
		
		r1.setn(3);
		r1.setside(1);
		r1.setx(0);
		r1.sety(0);
		
		r2.setn(6);
		r2.setside(4);
		r2.setx(0);
		r2.sety(0);
		
		r3.setn(10);
		r3.setside(4);
		r3.setx(5.6);
		r3.sety(7.8);
		
		System.out.println("The perimeter is " + r1.getPerimeter() + ", the area is " + r1.getArea());
		System.out.println("The perimeter is " + r2.getPerimeter() + ", the area is " + r2.getArea());
		System.out.println("The perimeter is " + r3.getPerimeter() + ", the area is " + r3.getArea());

	}

}

class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	public void setn(int n) {
		this.n = n;
	}
	public void setside(double side) {
		this.side = side;
	}
	public void setx(double x) {
		this.x = x;
	}
	public void sety(double y) {
		this.y = y;
	}
	
	double getPerimeter() {
		return n * side;
	}
	
	double getArea() {
		return (n * side * side) / (4 * Math.tan(Math.PI / n));
	}

}