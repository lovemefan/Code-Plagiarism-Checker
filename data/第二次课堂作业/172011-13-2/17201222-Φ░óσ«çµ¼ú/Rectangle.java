package nice;

public class Rectangle {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle(4,40);
	System.out.println("The rectangle's width is " + rectangle1.width +" height is "
			+ rectangle1.height +" area is " + rectangle1.getArea() + " perimeter is "
			+ rectangle1.getPerimeter() );
	Rectangle rectangle2 = new Rectangle(3.5,35.9);
	System.out.println("The rectangle's width is " + rectangle2.width +" height is "
			+ rectangle2.height +" area is " + rectangle2.getArea() + " perimeter is "
			+ rectangle2.getPerimeter() );
	}
	double width, height;
	Rectangle(){
		width = 1;
		height = 1;
	}
	Rectangle(double newWidth, double newHeight){
		width = newWidth;
		height = newHeight;
	}
	double getArea(){
		return width * height;
	}
	double getPerimeter(){
		return (width + height) * 2;
	}
	void setWidth(double newWidth){
		width = newWidth;
	}
	void setHeight(double newHeight){
		height = newHeight;
	}
	

}
