package dmz;

public class Problem9_9_RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	public static void main(String[] args) {
		Problem9_9_RegularPolygon RegularPolygon1 = new Problem9_9_RegularPolygon();
		Problem9_9_RegularPolygon RegularPolygon2 = new Problem9_9_RegularPolygon(6,4);
		Problem9_9_RegularPolygon RegularPolygon3 = new Problem9_9_RegularPolygon(10,4,5.6,7.8);
		System.out.println("The perimeter and area of RegularPolygon1 is " + RegularPolygon1.getPerimeter(RegularPolygon1.n, RegularPolygon1.side) + " " + RegularPolygon1.getArea(RegularPolygon1.n, RegularPolygon1.side));
		System.out.println("The perimeter and area of RegularPolygon2 is " + RegularPolygon2.getPerimeter(RegularPolygon2.n, RegularPolygon2.side) + " " + RegularPolygon2.getArea(RegularPolygon2.n, RegularPolygon2.side));
		System.out.println("The perimeter and area of RegularPolygon3 is " + RegularPolygon3.getPerimeter(RegularPolygon3.n, RegularPolygon3.side) + " " + RegularPolygon3.getArea(RegularPolygon3.n, RegularPolygon3.side));
	}
	Problem9_9_RegularPolygon(){
		this.n = 3;
		this.side = 1;
		this.x = 0;
		this.y = 0;
	}
	Problem9_9_RegularPolygon(int n,double side){
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}
	Problem9_9_RegularPolygon(int n,double side,double x,double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	double getPerimeter(int n,double side) {
		return n * side;
	}
	double getArea(int n,double side) {
		return (n * Math.pow(side, 2))/(4 * Math.tan(Math.PI/n));
	}

}
