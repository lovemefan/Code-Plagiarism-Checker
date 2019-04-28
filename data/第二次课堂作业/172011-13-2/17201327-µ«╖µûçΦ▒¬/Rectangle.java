
public class Rectangle {
	
	private double width;
	private double height;
	
	public Rectangle() {
		width = 1;
		height = 1;
	}
	
	public Rectangle(double width,double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getPerimeter() {
		return 2 * (this.height + this.width);
	}
}
