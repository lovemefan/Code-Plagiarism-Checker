package one;

public class Rectangle {
	public double width = 1;
	public double height = 1;
	Rectangle() {
	}
	Rectangle(double newWidth,double newHeight){
		width = newWidth;
		height = newHeight;
	}
	double getArea(){
		return height*width;
	}
	double getPerimeter(){
		return (height + width)*2;
	}
	void setWidth(double newWidth){
		width = newWidth;
	}
	void setHeight(double newHeight){
		height = newHeight;
	}

}
