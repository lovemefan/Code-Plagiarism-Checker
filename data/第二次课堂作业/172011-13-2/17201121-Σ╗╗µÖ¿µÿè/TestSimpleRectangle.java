package TestSimpleRectangle;

public class TestSimpleRectangle {
	public static void main(String[] args){
		
		SimpleRectangle rectangle1 = new SimpleRectangle(4,40);
		System.out.println("The perimeter and area of the rectangle of width "
	    + rectangle1.width +" and height " + rectangle1.height +" is "+ rectangle1.getPerimeter() +" and "+ rectangle1.getArea());
		
		SimpleRectangle rectangle2 = new SimpleRectangle(3.5,35.9);
		System.out.println("The perimeter and area of the rectangle of width "
		+ rectangle2.width +" and height " + rectangle2.height +" is "+ rectangle2.getPerimeter() +" and "+ rectangle2.getArea());	
	}
}

class SimpleRectangle {
	double width,height;
	
	SimpleRectangle() {
		width = 1;
		height = 1;
	}
	
	SimpleRectangle(double newWidth,double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	double getPerimeter() {
		return (width+height)*2;
	}
	
	double getArea(){
		return width*height;
	}
}

