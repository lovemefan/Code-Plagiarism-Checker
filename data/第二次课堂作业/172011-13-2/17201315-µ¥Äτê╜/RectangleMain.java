package Rectangle;//9.1

public class RectangleMain {
	public static void main(String[] args) {
		Rectangle r1,r2;
		r1 = new Rectangle();
		r2 = new Rectangle();
		r1 = new Rectangle(4.0,40.0);
		r2 = new Rectangle(3.5,35.9);
		System.out.println("Rectangle1's width is " + r1.getWidth());
		System.out.println("Rectangle1's height is " + r1.getHeight());
		System.out.println("Rectangle1's area is " + r1.getArea());
		System.out.println("Rectangle1's perimeter is " + r1.getPerimeter());
		System.out.println("Rectangle2's width is " + r2.getWidth());
		System.out.println("Rectangle2's height is " + r2.getHeight());
		System.out.println("Rectangle2's area is " + r2.getArea());
		System.out.println("Rectangle2's perimeter is " + r2.getPerimeter());
	}

}



 