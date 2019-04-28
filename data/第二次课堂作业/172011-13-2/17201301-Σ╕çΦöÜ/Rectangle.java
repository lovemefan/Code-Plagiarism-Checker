
public class Rectangle {
    /** Main method */
	public static void main(String[] args) {
		// Create a rectangle with width 1 and height 1
		Rectangle rectangle1 = new Rectangle();
		rectangle1.setRec(4, 40);
		System.out.println("The area of the rectangle of width " +
		rectangle1.width + " and the height " + rectangle1.height +
		" is " + rectangle1.getArea());
		System.out.println("The perimeter of the rectangle of width " +
				rectangle1.width + " and the height " + rectangle1.height +
				" is " + rectangle1.getPerimeter());
		
		// Create a rectangle with width 3.5 and height 35.9
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("The area of the rectangle of width " +
				rectangle2.width + " and the height " + rectangle2.height +
				" is " + rectangle2.getArea());
		System.out.println("The perimeter of the rectangle of width " +
				rectangle2.width + " and the height " + rectangle2.height +
				" is " + rectangle2.getPerimeter());
		
	}

	private double width;
	private double height;
	/** Construct a rectangle with width 1 and height 1 */
	public Rectangle(){
		this.width = 1;
		this.height = 1;
	}
	
	/** Construct a rectangle with a specified width and height */
	public Rectangle(double newWidth, double newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}
	
	/** Return the area of this rectangle */
	public double getArea(){
		return width * height;
	}
	
	/** Return the perimeter of this rectangle */
	public double getPerimeter(){
		return 2 * (width + height);
	}
	
	/** Set a new width and height for this rectangle */
	public void setRec(double newWidth, double newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}
}
