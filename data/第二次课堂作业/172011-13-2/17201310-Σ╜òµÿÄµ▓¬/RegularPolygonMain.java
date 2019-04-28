
public class RegularPolygonMain {

	public static void main(String[] args) {
		Polygon polygon1 = new Polygon();
		System.out.println("The perimeter of polygon1 is: " + polygon1.getPerimeter());
		System.out.println("The area of polygon1 is: " + polygon1.getArea());

		Polygon polygon2 = new Polygon(6, 4);
		System.out.println("The perimeter of polygon2 is: " + polygon2.getPerimeter());
		System.out.println("The area of polygon2 is: " + polygon2.getArea());
		
		Polygon polygon3 = new Polygon(10, 4, 5.6, 7.8);
		System.out.println("The perimeter of polygon3 is: " + polygon3.getPerimeter());
		System.out.println("The area of polygon3 is: " + polygon3.getArea());
	}

}

class Polygon {
	private int n;
	private double side;
	private double x;
	private double y;

	public Polygon() {
		n = 3;
		side = 1;
		x = 0.0;
		y = 0.0;
	}

	public Polygon(int n, double side) {
		this.n = n;
		this.side = side;
		x = 0.0;
		y = 0.0;
	}

	public Polygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}

	public void setN(int n) {
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
	
	public double getSide() {
		return side;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getPerimeter() {
		return n * side;
	}
	
	public double getArea() {
		return  n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
	}
}