package RegularPolygon;//9.9

public class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	public RegularPolygon() {
		
	}
	public void setN( int n) {
		this.n = n;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getN() {
		return n;
	}
	public double getSide(double side) {
		return side;
	}
	public double getX(double x) {
		return x;
	}
	public double getY(double y) {
		return y;
	}
	public RegularPolygon(int n,double side) {
		this.n = n;
		this.side = side;
	}
	public RegularPolygon(int n,double side,double x,double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	public double getPerimeter(){
		double perimeter = 0;
		perimeter = n * side;
		return perimeter;
	}
	public double getArea(){
		double area = 0;
		area = (n * Math.pow(side, 2) / (4*Math.tan(Math.PI/n)));
		return area;
	}
}
