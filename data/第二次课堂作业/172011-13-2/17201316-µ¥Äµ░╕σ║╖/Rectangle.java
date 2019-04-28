package Work91;

public class Rectangle {
	double width = 1;
	double height = 1;
	
	Rectangle() {
		
	}
	
	Rectangle(double newWidth,double newHeight) {
		this.width = newWidth;
		this.height = newHeight;
	}
	
	double getArea() {
		return width * height;
	}
	
	double getPerimeter() {
		return 2*(width + height);
	}
}