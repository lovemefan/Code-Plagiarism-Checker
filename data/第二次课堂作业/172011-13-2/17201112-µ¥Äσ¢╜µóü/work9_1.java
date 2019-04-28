package assignments1;                              

class Rectangle{
	double width;
	double height;
	Rectangle(){
		width = 1;
		height = 1;
	}
	Rectangle(double width,double height){
		this.width = width;
		this.height = height;
	}
	double getArea(){
		return width*height;
	}
	double getPerimeter(){
		return 2*(width+height);
	}
}

public class work9_1 {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle();
		System.out.println("the default width and height of the rectangle is "+rectangle1.width+" and "+rectangle1.height);
		Rectangle rectangle2 = new Rectangle(4,40);
		System.out.println("the width and height of the rectangle2 is "+rectangle2.width+" and "+rectangle2.height+" ,and the area is "+rectangle2.getArea()+" ,and the perimeter is "+rectangle2.getPerimeter());
		Rectangle rectangle3 = new Rectangle(3.5,35.9);
		System.out.println("the width and height of the rectangle3 is "+rectangle3.width+" and "+rectangle3.height+" ,and the area is "+rectangle3.getArea()+" ,and the perimeter is "+rectangle3.getPerimeter());
	}
}
