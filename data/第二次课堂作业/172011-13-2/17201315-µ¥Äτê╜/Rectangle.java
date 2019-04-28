package Rectangle;//9.1

public class Rectangle {
	private double width = 1,height = 1;
	
	
	public Rectangle() {
		
	}
	
    public Rectangle( double width,double height) {
	this.width = width;
	this.height = height;
	}

	public double getWidth() {
		return width;
		
	}
	public double getHeight() {
		return height;
	}
	public double getArea(){
		double area = 0;
		area = width * height;
		return area;
	}
	public double getPerimeter(){
		double perimeter = 0;
		perimeter = 2 * (width + height);
		return perimeter;
	}
}
