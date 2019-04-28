package work;

public class Rectangle {
	public static void main(String[] args) {
		Rectangle tangle1 = new Rectangle(4,40);
		System.out.println("The width: " + tangle1.width + " height: " + tangle1.height + " area: " + tangle1.area + "and perimeter are: " + tangle1.perimeter);
		
		Rectangle tangle2 = new Rectangle(3.5,35.9);
		System.out.println("The width: " + tangle2.width + " height: " + tangle2.height + " area: " + tangle2.area + "and perimeter are: " + tangle2.perimeter);
		
	}
	double width,height,area,perimeter;
	
	Rectangle() {
		width = 1;
		height = 1;
	}
	Rectangle(double newWidth,double newHeight) {
		this.width = newWidth;
	    this.height = newHeight;
		}
double getArea() {
	return width*height;
}
double getPerimeter() {
	return 2*(width + height);
}
void setWidth(double newWidth) {
	width = newWidth;
}
void setHeight(double newHeight) {
	height =newHeight;
}
	
}
