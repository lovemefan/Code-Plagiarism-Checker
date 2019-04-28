
public class Rectangle {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle();
		System.out.println("The area of the rectagle of width "+rectangle1.width+" and height "+rectangle1.height
				+" is "+rectangle1.getArea()+" the perimeter is "+rectangle1.getPerimeter());
		
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("The area of the rectagle of width "+rectangle2.width+" and height "+rectangle2.height
				+" is "+rectangle2.getArea()+" the perimeter is "+rectangle2.getPerimeter());
	}
	double width,height;
	Rectangle(){
		width = 4;
		height = 40;
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
}
