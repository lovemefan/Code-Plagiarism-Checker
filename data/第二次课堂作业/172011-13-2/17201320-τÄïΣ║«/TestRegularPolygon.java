
public class TestRegularPolygon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularPolygon r1 = new RegularPolygon();
		RegularPolygon r2 = new RegularPolygon(6,4);
		RegularPolygon r3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("r1's area and perimeter is :" + r1.getArea() + " " + r1.getPerimeter());
		System.out.println("r2's area and perimeter is :" + r2.getArea() + " " + r2.getPerimeter());
		System.out.println("r3's area and perimeter is :" + r3.getArea() + " " + r3.getPerimeter());
	}

}

class RegularPolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y =0;
	}
	int getN() {
		return n;
	}
	void setN(int newN) {
		n = newN;
	}
	double getSide() {
		return side;
	}
	void setSide( double newSide) {
		side = newSide;
	}
	double getX() {
		return x;
	}
	void setX(double newX) {
		x = newX;
	}
	double getY() {
		return y;
	}
	void setY(double newY) {
		y = newY;
	}
	RegularPolygon(int newN,double newSide){
		n = newN;
		side = newSide;
		x = 0;
		y = 0;
	}
	RegularPolygon(int newN,double newSide,double newX,double newY){
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	}
	double getPerimeter() {
		return side * n;
	}
	double getArea() {
		return (n * side * side) / (4 * Math.tan(Math.PI / n));
	}
}
