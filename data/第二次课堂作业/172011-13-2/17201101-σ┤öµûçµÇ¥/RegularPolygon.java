package workTwo;

public class RegularPolygon {
	private int n=3;
	private double side=1;
	private double x=0;
	private double y=0;

	RegularPolygon(){
		
	}
	
	public RegularPolygon(int n,double side) 
	{
		this.n = n;
		this.side = side;
		x=0;
		y=0;
	}
	
	public RegularPolygon(int n,double side,double x,double y)
	{
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	public int getN() {
		return n;
	}
	
	public double getSIDE() {
		return side;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void Fan(int n,double side){
		this.n=n;
		this.side=side;
		x=0;
		y=0;
	}
	
	public void Fan(int n,double side,double x,double y){
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	
	public double getPerimeter(){
		return n*side;
	}
	
	public double getArea(){
		return ((n*side*side)/(4*Math.tan(Math.PI/n)));
	}
	
	public static void main(String[] args) {
		
		RegularPolygon edge1 = new RegularPolygon();
		System.out.println("the regularpolygon areas is "+edge1.getArea()+" perimeter is  "+edge1.getPerimeter());
		
		RegularPolygon edge2 = new RegularPolygon(6,4);
		System.out.println("the regularpolygon areas is "+edge2.getArea()+" perimeter is  "+edge2.getPerimeter());
		
		RegularPolygon edge3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("the regularpolygon areas is "+edge3.getArea()+" perimeter is  "+edge3.getPerimeter());
	}
}
