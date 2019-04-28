import java.util.Scanner;
public class Class9_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		RegularPolygon r1 =new RegularPolygon();
		RegularPolygon r2 = new RegularPolygon(6,4);
		RegularPolygon r3 = new RegularPolygon(10,4,5.6,7.8);
//		r3.modifyn(10);
		System.out.println("The RegularPolygon's perimeter is " + r1.getPerimeter() + " Area is " + r1.getArea());
		System.out.println("The RegularPolygon's perimeter is " + r2.getPerimeter() + " Area is " + r2.getArea());
		System.out.println("The RegularPolygon's perimeter is " + r3.getPerimeter() + " Area is " + r3.getArea());
	}

}
class RegularPolygon{
	private int n=3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	RegularPolygon()
	{
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	RegularPolygon(int n,double side)
	{
		this.n=n;
		this.side=side;
	}
	RegularPolygon(int n,double side, double x,double y)
	{
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	void modifyn(int n)
	{
		this.n=n;
	}
	void modifyside(double side)
	{
		this.side=side;
	}
	void modifyx(double x)
	{
		this.x=x;
	}
	void modifyy(double y)
	{
		this.y=y;
	}
	double getPerimeter()
	{
		return n*side;
	}
	double getArea()
	{
		return n*Math.pow(side, 2)/(4*Math.tan(Math.PI/n));
	}
}