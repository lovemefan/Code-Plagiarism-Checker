package work;

public class TestRectangle1 {
	public static void main(String[] args){
		Rectangle rectangle1=new Rectangle();
		System.out.println("The area of the rectangle of width "+rectangle1.width + " and height " + rectangle1.height + " is " + rectangle1.getArea());
		System.out.println("The perimeter of the rectangle of width "+rectangle1.width + " and height " + rectangle1.height + " is " + rectangle1.getPerimeter());
		Rectangle rectangle2=new Rectangle(4,40);
		System.out.println("The area of the rectangle of width "+rectangle2.width + " and height " + rectangle2.height + " is " + rectangle2.getArea());
		System.out.println("The perimeter of the rectangle of width "+rectangle2.width + " and height " + rectangle2.height + " is " + rectangle2.getPerimeter());
		Rectangle rectangle3=new Rectangle(3.5,35.9);
		System.out.println("The area of the rectangle of width "+rectangle3.width + " and height " + rectangle3.height + " is " + rectangle3.getArea());
		System.out.println("The perimeter of the rectangle of width "+rectangle3.width + " and height " + rectangle3.height + " is " + rectangle3.getPerimeter());
	}
}
