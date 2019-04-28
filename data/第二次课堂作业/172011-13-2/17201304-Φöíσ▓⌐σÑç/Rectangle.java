package rectangle;

public class Rectangle {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle();
		System.out.println("The area of the rectangle of width " + rectangle1.width + " height " + rectangle1.height + " is " +  rectangle1.getArea() + ", The perimeter is " + rectangle1.getPerimeter());
		
		Rectangle rectangle2 = new Rectangle(4,40);
		System.out.println("The area of the rectangle of width " + rectangle2.width + " height " + rectangle2.height + " is " +  rectangle2.getArea() + ", The perimeter is " + rectangle2.getPerimeter());
		
		Rectangle rectangle3 = new Rectangle(3.5,35.9);
		System.out.println("The area of the rectangle of width " + rectangle3.width + " height " + rectangle3.height + " is " +  rectangle3.getArea() + ", The perimeter is " + rectangle3.getPerimeter());
		
	}
	double width, height;
	
	Rectangle(){
		width = 1;
		height = 1;
	}
	
	Rectangle(double newWidth, double newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}
	
	double getArea(){
		return width * height;
	}
	
	double getPerimeter(){
		return 2 * (width + height);
	}
	
	void setRectangle(double newWidth,double newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}

}
