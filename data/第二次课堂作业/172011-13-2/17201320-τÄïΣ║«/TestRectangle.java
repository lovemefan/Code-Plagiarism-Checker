
public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(4,40);
		Rectangle r2 = new Rectangle(3.9,35.9);
		System.out.println("The area of r1 is " + r1.getArea() + " and perimeter is " + r1.getPerimeter() );
		System.out.println("The area of r2 is " + r2.getArea() + " and perimeter is " + r2.getPerimeter() );
	}
}
class Rectangle{
	double width;
	double height;
	Rectangle(){
		width = 1;
		height = 1;
	}
	Rectangle(double newwidth,double newheight){
		width = newwidth;
		height = newheight;
	}
	double getArea() {
		return width * height;
	}
	double getPerimeter() {
		return 2 * (width + height);
	}
}

