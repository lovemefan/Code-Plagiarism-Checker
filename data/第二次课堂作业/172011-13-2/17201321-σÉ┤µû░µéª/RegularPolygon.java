
public class RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
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
	public int getN(){
		return n;
	}
	public void setN(int newN){
		n = newN;
	}
	public double getSide(){
		return side;
	}
	public void setSide(double newSide){
		side = newSide;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setXY(double newX,double newY){
		x = newX;
		y = newY;
	}
	public double getPerimeter(){
		return n*side;
	}
	public double getArea(){
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
		
}
