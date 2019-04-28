package project2;

public class P9_1 {

	public static void main(String[] args) {
		Rectangle rectangle1=new Rectangle(4,40);
		Rectangle rectangle2=new Rectangle(3.5,35.9);
		System.out.println("weight: "+rectangle1.width+" height: "+rectangle1.height+" area: "+rectangle1.getArea()+" perimeter: "+rectangle1.getPerimeter());
		System.out.println("weight: "+rectangle2.width+" height: "+rectangle2.height+" area: "+rectangle2.getArea()+" perimeter: "+rectangle2.getPerimeter());
	}

}
class Rectangle{
	double width=1;
    double height=1;
	Rectangle(){

	}
	Rectangle(double width,double height){
		this.width=width;
		this.height=height;
	}
	double getArea() {
		return width*height;
	}
	double getPerimeter() {
		return 2*(width+height);
	}
}
