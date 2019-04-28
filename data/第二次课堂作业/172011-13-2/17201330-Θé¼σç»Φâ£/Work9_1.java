package lab2;

public class Work9_1 {

	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4,40);
		Rectangle rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("The area of the rectangle of width " + rectangle1.width + " and height " + rectangle1.height + 
				" is " + rectangle1.getArea());
		System.out.println("The perimeter of the rectangle of width " + rectangle1.width + " and height " + rectangle1.height + 
				" is " + rectangle1.getPerimeter());
		System.out.println("The area of the rectangle of width " + rectangle2.width + " and height " + rectangle2.height + 
				" is " + rectangle2.getArea());
		System.out.println("The perimeter of the rectangle of width " + rectangle2.width + " and height " + rectangle2.height + 
				" is " + rectangle2.getPerimeter());
	}

}
 class Rectangle{
	 double width = 1;
	 double height = 1;
	 public Rectangle(){
		 
	 }
	 public Rectangle(double newwidth,double newheight) {
		 width = newwidth;
		 height = newheight;
	 }
	 public double getArea() {
		 return width * height;
	 }
	 public double getPerimeter() {
		 return (width + height) * 2;
	 }
 }