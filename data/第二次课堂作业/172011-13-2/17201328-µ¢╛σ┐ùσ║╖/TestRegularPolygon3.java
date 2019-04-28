
public class TestRegularPolygon3 {
	private int n = 10;
	private double side = 4;
	private double x = 5.6;
	private double y = 7.8;
	public TestRegularPolygon3(){
		
	}
	
	public TestRegularPolygon3(int n, double side){
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}
	
	public TestRegularPolygon3(int n, double side, double x, double y){
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
