package Lesson_2;

public class Rectangle//长方形类
{
	double width=1,height=1;
	
	public Rectangle() {
		
	}
	
	public Rectangle(double newWidth,double newHeight) {
		width=newWidth;
		height=newHeight;
	}//带参数的构造方法
	
	public double getArea() {
		double area=width*height;
		return area;
	}//返回矩形面积
	public double getPerimeter() {
		double perimeter=2*width*height;
		return perimeter;
	}//返回矩形周长
	
}
