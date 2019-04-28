public class PositiveNEdge {
	public static void main(String[] args){
		RegularPolygon a1 = new RegularPolygon();
		RegularPolygon a2 = new RegularPolygon(6,4);
		RegularPolygon a3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("a1 premiter is " + a1.getPerimeter() + " area is " + a1.getArea());
		System.out.println("a2 premiter is " + a2.getPerimeter() + " area is " + a2.getArea());
		System.out.println("a3 premiter is " + a3.getPerimeter() + " area is " + a3.getArea());
	}
}
class RegularPolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	RegularPolygon(){
		n = 3;
		side = 1.0;
		x = 0;
		y = 0;
	}
	RegularPolygon(int newN, double newSide){
		n = newN;
		side = newSide;
		x = 0;
		y = 0;
	}
	
	RegularPolygon(int newN, double newSide, double newCenterX, double newCenterY){
		n = newN;
		side = newSide;
		x = newCenterX;
		y = newCenterY; 
	}
	
	public void setN(int newN){
		n = newN;
	}
	public int getN(){
		return n;
	}
	
	public void setSide(double newSide){
		side = newSide;
	}
	public double getSide(){
		return side;
	}
	public void setCenterX(double newX){
		x = newX;
	}
	public double getCenterX(){
		return x;
	}
	public void setCenterY(double newY){
		y = newY;
	}
	public double getCenterY(){
		return y;
	}
	public double getPerimeter(){
		return n*side;
	}
	public double getArea(){
		double area;
		area = (n * Math.pow(side, 2)) / (4 * Math.tan((Math.PI / n)));
		return area;
	}
}

