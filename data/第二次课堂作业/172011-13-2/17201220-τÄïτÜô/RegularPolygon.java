package four;

public class RegularPolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	double area;
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	RegularPolygon(int newN,double newSide){
		n = newN;
		side = newSide;
	}
	RegularPolygon(int newN,double newSide,double newX,double newY){
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	}
	public void setN(int newN){
		n = newN;
	}
	public void setSide(double newSide){
		side = newSide;
	}
	public void setX(double newX){
		x = newX;
	}
	public void setY(double newY){
		y = newY;
	}
	int getN(){
		return n;
	}
	double getSide(){
		return side;
	}
	double getX(){
		return x;
	}
	double getY(){
		return y;
	}
	double getPerimeter(){
		return n*side;
	}
	double getArea(){
		area = (n*Math.pow(side, 2))/(4*Math.tan((Math.PI/n)));
		return area;
	}

}
