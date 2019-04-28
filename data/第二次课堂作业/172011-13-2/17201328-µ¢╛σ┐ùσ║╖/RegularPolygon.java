
public class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	public RegularPolygon(){
		
	}
	
	public RegularPolygon(int n, double side){
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}
	
	public RegularPolygon(int n, double side, double x, double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	public int getNumber(){
		return n;
	}
	
	public double getSide(){
		return side;
	}
	
	public double getDestinationX(){
		return x;
	}
	
	public double getDestinationY(){
		return y;
	}
	
	public void setNumber(int n){
		this.n = n;
	}
	
	public void setSide(double side){
		this.side = side;
	}
	
	public void setDestinationX(double x){
		this.x = x;
	}
	
	public void setDestinationY(double y){
		this.y = y;
	}
	
	public double getPerimeter(int n, double side){
		double perimeter = 0;
		perimeter = n * side;
		return perimeter;
	}
	
	public double getArea(int n, double s){
		double area = 0;
		area = (n * s * s) / (4 * Math.tan(Math.PI / n));
		return area;
	}
}
