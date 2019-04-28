package Lesson_2;

public class RegularPolygon//多边形类
{
	int n=3;
	double side=1;
	double x=0;
	double y=0;
	
	public RegularPolygon() {
		
	}
	
	public RegularPolygon(int n,double side) {
		this.n=n;
		this.side=side;
		this.x=0;
		this.y=0;
	}//重载构造方法
	
	public RegularPolygon(int n,double side,double x,double y) {
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}//重载构造方法
	
	public int getN(){
		return n;
	}
	public double getSide() {
		return side;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}//访问数据
	
	public int setN(int n){
		this.n=n;
		return n;
	}
	public double setSide(double side) {
		this.side=side;
		return side;
	}
	public double setX(double x) {
		this.x=x;
		return x;
	}
	public double setY(double y) {
		this.y=y;
		return y;
	}//修改数据
	
	public double getPerimeter() {
		double perimeter=n*side;
		return perimeter;
	}//返回周长
	public double getArea() {
		double area=n*side*side/4*Math.tan(Math.PI/n);
		return area;
	}//返回面积
}
