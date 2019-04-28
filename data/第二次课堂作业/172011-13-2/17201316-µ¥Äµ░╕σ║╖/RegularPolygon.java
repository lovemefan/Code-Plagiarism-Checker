
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
		this.n = newN;
		this.side = newSide;
	}
	
	RegularPolygon(int newN,double newSide,double newX,double newY){
		this.n = newN;
		this.side = newSide;
		this.x = newX;
		this.y = newY;
	}
	
	public int getN(){
		return n;
	}
	
	public void setN(int newN){
		this.n = newN;
	}
	
	public double getSide(){
		return side;
	}
	
	public void setSide(double newSide){
		this.side = newSide;
	}
	
	public double getX(){
		return x;
	}
	
	public void setX(double newX){
		this.x = newX;
	}
	
	public double getY(){
		return y;
	}
	
	public void setY(double newY){
		this.y = newY;
	}
	
	public double getPerimeter(){
		return n*side;
	}
	
	public double getArea(){
		double area;
		area = n*Math.pow(side, 2)/(4*Math.tan(Math.PI/n));
		return area;
	}
}
