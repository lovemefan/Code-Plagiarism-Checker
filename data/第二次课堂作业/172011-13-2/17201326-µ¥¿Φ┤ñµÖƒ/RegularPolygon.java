package test2;

public class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	public RegularPolygon(){
		this.n = 3;
		this.side = 1;
		this.x = 0;
		this.y = 0;
	}
	
	public RegularPolygon(int n, double side){
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}
	
	public RegularPolygon(int n, double side,double x, double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	public int getN(){
		return this.n;
	}
	
	public double getSide(){
		return this.side;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void setN(int n){
		this.n = n;
	}
	
	public void setSide(double side){
		this.side = side;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getPerimeter(){
		double Perimeter = this.side * 4;
		return Perimeter;
	}
	
	public double getArea(){
		double Area = this.n * this.side* this.side / (4 * Math.tan(Math.PI / this.n));
		return Area;
	}
}
