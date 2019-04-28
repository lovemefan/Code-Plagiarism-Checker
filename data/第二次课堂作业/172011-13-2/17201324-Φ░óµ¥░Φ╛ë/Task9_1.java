package task;

public class Task9_1 {

	public static void main(String[] args) {//题目没说要写返回宽高的方法
		// TODO Auto-generated method stub
		Rectangle a=new Rectangle(4,40);
		Rectangle b=new Rectangle(3.5,35.9);
		System.out.println("The a rectangles width is 4");
		System.out.println("The a rectangles height is 40");
		System.out.println("The a rectangles area is "+a.getArea());
		System.out.println("The a rectangles perimeter is "+a.getPerimeter());
		System.out.println("The b rectangles width is 3.5");
		System.out.println("The b rectangles height is 35.9");
		System.out.println("The b rectangles area is "+b.getArea());
		System.out.println("The b rectangles perimeter is "+b.getPerimeter());
	}

}
class Rectangle{
	private double width;
	private double height;
	public Rectangle() {
		this.width=1.0;
		this.height=1.0;
	}
	public Rectangle(double width,double height) {
		this.width=width;
		this.height=height;
	}
	public double getArea() {
		return width*height;
	}
	public double getPerimeter() {
		return width*2+height*2;
	}
}