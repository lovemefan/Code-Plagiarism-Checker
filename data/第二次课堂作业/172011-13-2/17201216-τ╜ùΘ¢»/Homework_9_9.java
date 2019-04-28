import java.util.Scanner;

public class Homework_9_9 {
	public static void main(String[] args) {
		RegularPolygon regularPolygon1 = new RegularPolygon();
		RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
		RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
		
		System.out.println("regularPolygon1's area = " + regularPolygon1.getArea() + ", perimeter = " + regularPolygon1.getPerimeter());
		System.out.println("regularPolygon2's area = " + regularPolygon2.getArea() + ", perimeter = " + regularPolygon2.getPerimeter());
		System.out.println("regularPolygon3's area = " + regularPolygon3.getArea() + ", perimeter = " + regularPolygon3.getPerimeter());
	}
}


class RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	
	RegularPolygon() {
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	
	RegularPolygon(int n, double side) {
		this.n = n;
		this.side = side;
		x = 0;
		y = 0;
	}
	
	RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	int getN() {
		return n;
	}
	double getSide() {
		return side;
	}
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}
	void setN(int n) {
		this.n = n;
	}
	void setSide(double side) {
		this.side = side;
	}
	void setX(double x) {
		this.x = x;
	}
	void setY(double y) {
		this.y = y;
	}
	double getPerimeter() {
		return n * side;
	}
	double getArea() {
		return (n * side * side) / (4 * Math.tan(Math.PI / n));
	}
}