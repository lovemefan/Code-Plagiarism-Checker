package exercise;

public class Rectangle {
	public static void main (String[] args) {
		Rectangle rect1 = new Rectangle(4,40);
		Rectangle rect2 = new Rectangle(3.5,35.9);
		System.out.println("Rectangle1's Width:" + rect1.width);
		System.out.println("Rectangle1's Height:" + rect1.height);
		System.out.println("Rectangle1's area is " + rect1.getArea());
		System.out.println("Rectangle1's Perimeter is " + rect1.getPerimeter());
		System.out.println("Rectangle2's Width:" + rect2.width);
		System.out.println("Rectangle1's Height:" + rect2.height);
		System.out.println("Rectangle2's area:" + rect2.getArea());
		System.out.println("Rectangle2's Perimeter is " + rect2.getPerimeter());
	}
	private double width = 1,height = 1;
	public Rectangle() {
		
	}
	public Rectangle(double width,double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	public double getPerimeter() {
		return width + height;
	}
}

