package lab2;

public class Work9_9 {

	public static void main(String[] args) {
		RegularPolygon regularpolygon1 = new RegularPolygon();
		System.out.println("The perimeter is:" + regularpolygon1.getPerimere() + "The area is:" + regularpolygon1.getArea());
		RegularPolygon regularpolygon2 = new RegularPolygon(6,4);
		System.out.println("The perimeter is:" + regularpolygon2.getPerimere() + "The area is:" + regularpolygon2.getArea());
		RegularPolygon regularpolygon3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The perimeter is:" + regularpolygon3.getPerimere() + "The area is:" + regularpolygon3.getArea());

	}

}
class RegularPolygon{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	public RegularPolygon(){
		
	}
    public RegularPolygon(int n0,int side0){
		n = n0;
		side = side0;
		x = 0;
		y = 0;
	}
    public RegularPolygon(int n0,int side0,double x0,double y0){
		n = n0;
		side = side0;
		x = x0;
		y = y0;
	}
    public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void sety(double y) {
		this.y = y;
    }
	public double getPerimere() {
		return n * side;
	}
	public double getArea() {
		return ((n * side * side) / 4 * Math.tan(Math.PI / n));
	}
}
