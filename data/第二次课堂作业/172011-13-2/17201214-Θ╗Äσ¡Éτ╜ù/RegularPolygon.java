import java.util.*;

public class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	public RegularPolygon()
	{
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int n,double side)
	{
		x = 0;
		y = 0;
		this.n = n;
		this.side = side;
	}
	
	public RegularPolygon(int n,double side,double x,double y)
	{
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	public int getN()
	{
		return n;
	}
	
	public void setN(int n)
	{
		this.n = n;
	}
	
	public double getSide()
	{
		return side;
	}
	
	public void setSide(double side)
	{
		this.side = side;
	}
	
	public double getX()
	{
		return x;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public double getPerimeter()
	{
		return side*n;
	}
	
	public double getArea()
	{
		return (n*Math.pow(side, 2))/(4*Math.tan(Math.PI/n));
	}
	
	public static void main(String[] args) 
	{
		RegularPolygon test1 = new RegularPolygon();
		RegularPolygon test2 = new RegularPolygon(6,4);
		RegularPolygon test3 = new RegularPolygon(10,4,5.6,7.8);
		
		System.out.println("Test1 perimeter is: "+test1.getPerimeter()+" Test1 area is: "+test1.getArea());
		System.out.println();
		System.out.println("Test2 perimeter is: "+test2.getPerimeter()+" Test2 area is: "+test2.getArea());
		System.out.println();
		System.out.println("Test3 perimeter is: "+test3.getPerimeter()+" Test3 area is: "+test3.getArea());
	}
}
