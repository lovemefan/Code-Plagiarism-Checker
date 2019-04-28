
public class Practice9_9 {
	public static void main(String[] args) {
		ReglularPolygon r1 = new ReglularPolygon();
		System.out.println("The " + r1.getn() +"-regular polygon's area and perimeter is " + r1.getArea() + " and " +r1.getPerimeter());
		ReglularPolygon r2 = new ReglularPolygon(6,4);
		System.out.println("The " + r2.getn() +"-regular polygon's area and perimeter is " + r2.getArea() + " and " +r2.getPerimeter());
		ReglularPolygon r3 = new ReglularPolygon(10,4,5.6,7.8);
		System.out.println("The " + r3.getn() +"-regular polygon's area and perimeter is " + r3.getArea() + " and " +r3.getPerimeter());
	}

}
class ReglularPolygon{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	ReglularPolygon(){
	}
	ReglularPolygon(int n,double side){
		this.n = n;
		this.side = side;
	}
	ReglularPolygon(int n,double side,double x,double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	int getn() {
		return n;
	}
	double getside() {
		return side;
	}
	double getx() {
		return x;
	}
	double gety() {
		return y;
	}
	public void setn() {
		this.n= n;
	}
	public void setside() {
		this.side= side;
	}
	public void setx() {
		this.x= x;
	}
	public void sety() {
		this.y= y;
	}
	double setn(int n) {
		return n;
	}
	double getPerimeter() {
		return n * side;
	}
	double getArea() {
		return n * side * side/(4.0 * Math.tan(Math.PI / (double) n));
	}
}

