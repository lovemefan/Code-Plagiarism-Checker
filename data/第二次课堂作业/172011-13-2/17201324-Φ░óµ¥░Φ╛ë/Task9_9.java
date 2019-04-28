package task;

public class Task9_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularPolygon a=new RegularPolygon();
		RegularPolygon b=new RegularPolygon(6,4);
		RegularPolygon c=new RegularPolygon(10,4,5.6,7.8);
		System.out.println(a.getPerimeter()+"  "+a.getArea());
		System.out.println(b.getPerimeter()+"  "+b.getArea());
		System.out.println(c.getPerimeter()+"  "+c.getArea());

	}

}
class RegularPolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	public RegularPolygon() {
		n=3;
		side=1;
		x=0;
		y=0;
	}
	public RegularPolygon(int n,double side) {
		this.n=n;
		this.side=side;
		x=0;
		y=0;
	}
	public RegularPolygon(int n,double side,double x,double y) {
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
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
		return side*n;
	}
	public double getArea() {
		return n*Math.pow(side, 2)/4/Math.tan(Math.PI/n);
	}
}