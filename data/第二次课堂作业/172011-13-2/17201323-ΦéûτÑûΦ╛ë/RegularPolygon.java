package work;

public class RegularPolygon {
	private double x,y,side;
	private int n;
	RegularPolygon(){
		x = 0;
		y = 0;
		side = 1.0;
		n = 3;
	}
	RegularPolygon(int newN,double newSide){
		x = 0;
		y = 0;
		side = newSide;
		n = newN;
	}
	RegularPolygon(int newN,double newCenterX,double newCenterY,double newSide){
		x = newCenterX;
		y = newCenterY;
		side = newSide;
		n = newN;
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
	public void setSide(double newSide){
		side = newSide;
	}
	public double getSide(){
		return side;
	}
	public void setN(int newN){
		n = newN;
	}
	public int getN(){
		return n;
	}
	public double getPerimeter(){
		return n*side;
	}
	public double getArea(){
		double area;
		area = (n*Math.pow(side, 2));
		return area;
	}

}
