import java.util.Scanner;
public class allRectangle {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4,40);
		System.out.println("The width is " +r1.width +" and the height is " +r1.height +"'s rectangle area is " + r1.getArea() + " and the perimeter is " + r1.getPerimeter());
		Rectangle r2 = new Rectangle(3.5,35.9);
		System.out.println("The width is " +r2.width +" and the height is " +r2.height +"'s rectangle area is " + r2.getArea() + " and the perimeter is " + r2.getPerimeter());
	}	
}
class Rectangle{
	double width =1,height = 1;
	Rectangle(){
	}
	Rectangle(double newwidth,double newheight){
		width = newwidth;
		height = newheight;
	}
	double getArea() {
		return width * height;
	}
    double getPerimeter() {
    	return 2 * (width + height);
    }
}

