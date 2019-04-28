public class TestRectangle {
	public static void main(String[] args){
		Rectangle a1 = new Rectangle(4 , 40);
		System.out.println("width height Area Perimeter: " + a1.width +" "+ a1.height +" "+ a1.getArea() +" "+ a1.getPerimeter());
		Rectangle a2 = new Rectangle(3.5 , 35.9);
		System.out.println("width height Area Perimeter: " + a2.width +" "+ a2.height +" "+ a2.getArea() +" "+ a2.getPerimeter());	
	}

}
class Rectangle{
	double width = 1 , height = 1;
	Rectangle(){
	}
	Rectangle(double newWidth , double newHeight){
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
