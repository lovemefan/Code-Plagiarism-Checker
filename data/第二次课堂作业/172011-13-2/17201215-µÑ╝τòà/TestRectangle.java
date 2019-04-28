
public class TestRectangle {
	public static void main(String[] args) { 
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		r1.width = 4;
		r1.height = 40;
		r2.width = 3.5;
		r2.height = 35.9;
		System.out.println("Rectangle width is " + r1.width + ", height is " + r1.height + ", area is "
		+ r1.getArea() + ", perimeter is " + r1.getPerimeter() );
		System.out.println("Rectangle width is " + r2.width + ", height is " + r2.height + ", area is "
		+ r2.getArea() + ", perimeter is " + r2.getPerimeter() );
	}
}
class Rectangle {
	double width;
	double height;
	double getArea() {
		return width * height;
	}
	
	double getPerimeter() {
		return (width + height) * 2;
	}
}