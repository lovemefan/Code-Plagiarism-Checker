package exercise;

public class n_Regular_Polygon {
	public static void main(String[] args) {
		n_Regular_Polygon[] nPogular = new n_Regular_Polygon[3];
		nPogular[0] =  new n_Regular_Polygon();
		nPogular[1] =  new n_Regular_Polygon(6,4);
		nPogular[2] =  new n_Regular_Polygon(10,4,5.6,7.8);
		System.out.println("This  regular polygon1's area is " + nPogular[0].getArea());
		System.out.println("This  regular polygon1's Perimeter is " + nPogular[0].getPerimeter());
		System.out.println("This  regular polygon2's area is " + nPogular[1].getArea());
		System.out.println("This  regular polygon2's Perimeter is " + nPogular[1].getPerimeter());
		System.out.println("This  regular polygon3's area is " + nPogular[2].getArea());
		System.out.println("This  regular polygon3's Perimeter is " + nPogular[2].getPerimeter());
	}
	
	private int n;
	private double side;
	private double x;
	private double y;
	
	public n_Regular_Polygon() {
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	public n_Regular_Polygon(int n,int side) {
		this.n = n;
		this.side = side;
		x = 0;
		y = 0;
	}
	public n_Regular_Polygon(int n,int side,double x,double y) {
		this.n = n;
		this.side = side;
		this.x = x;
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
	public double getPerimeter() {
		return n * side;
	}
	public double getArea() {
		double s = n * side;
		return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
	}
}
