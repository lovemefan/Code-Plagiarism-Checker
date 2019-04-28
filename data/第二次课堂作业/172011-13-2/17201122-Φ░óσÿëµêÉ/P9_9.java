package project2;

import java.math.BigDecimal;

public class P9_9 {

	public static void main(String[] args) {
		RegularPolygon regular0=new RegularPolygon();
		RegularPolygon regular1=new RegularPolygon(6,4);
		RegularPolygon regular2=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("regular0's perimeter: "+regular0.getPerimeter()+" area: "+regular0.getArea());
		System.out.println("regular1's perimeter: "+regular1.getPerimeter()+" area: "+regular1.getArea());
		System.out.println("regular2's perimeter: "+regular2.getPerimeter()+" area: "+regular2.getArea());

	}

}
class RegularPolygon{
	private int n=3;
	private double side=1;
	private double x=0;
	private double y=0;
	RegularPolygon(){
	}
	RegularPolygon(int new_n,double new_side) {
	n=new_n;
	side=new_side;

	}
	RegularPolygon(int n,double side,double x,double y) {
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	public int getN() {
		return n;
	}
	public double getSide() {
		return side;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setN(int n) {
		this.n=n;
	}
	public void setSide(double side) {
		this.side=side;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	double getPerimeter() {
		return n*side;
	}
	double getArea() {
		BigDecimal bSide=new BigDecimal(Double.valueOf(side).toString());
		double p=Math.tan(Math.PI/n);
		return (n*bSide.multiply(bSide).doubleValue())/(4*p);
	}
}