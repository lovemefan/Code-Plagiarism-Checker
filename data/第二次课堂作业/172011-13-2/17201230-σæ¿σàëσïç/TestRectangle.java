package homework;

public class TestRectangle {
	public static void main(String[] args){
		Rectangle rectangle1=new Rectangle(4,40);
		System.out.println("The area,perimeter of the rectangle of width "+rectangle1.width+
				" height "+rectangle1.height+" is "+rectangle1.getArea()+","+rectangle1.getPerimater());
		Rectangle rectangle2=new Rectangle(3.5,35.9);
		System.out.println("The area,perimeter of the rectangle of width "+rectangle2.width+
				" height "+rectangle2.height+" is "+rectangle2.getArea()+","+rectangle2.getPerimater());
	}
}
class Rectangle{
	double width;
	double height;
	Rectangle(){
	width=1;
	height=1;
	}
	Rectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
	double getArea(){
		return width*height;
	}
	double getPerimater(){
		return 2*(width+height);
	}
	void setRectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
}

	