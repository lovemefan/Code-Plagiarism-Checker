package one;

public class Main {
	public static void main(String[] args){
		Rectangle Rectangle1 = new Rectangle(4,40);
		System.out.println("The area of the rectangle of width " + Rectangle1.width +
				" and height " + Rectangle1.height + " is " + Rectangle1.getArea());
		System.out.println("The perimeter of the rectangle of width " + Rectangle1.width +
				" and height " + Rectangle1.height + " is " + Rectangle1.getPerimeter());
		Rectangle Rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("The area of the rectangle of width " + Rectangle2.width +
				" and height " + Rectangle2.height + " is " + Rectangle2.getArea());
		System.out.println("The perimeter of the rectangle of width " + Rectangle2.width +
				" and height " + Rectangle2.height + " is " + Rectangle2.getPerimeter());
	}
	
}