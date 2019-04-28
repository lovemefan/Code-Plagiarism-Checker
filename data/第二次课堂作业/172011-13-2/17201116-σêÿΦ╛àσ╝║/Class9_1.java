import java.util.Scanner;
public class Class9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        Rectangle r1 = new Rectangle(4,40);
        Rectangle r2 = new Rectangle(3.5,35.9);
        System.out.println("The width, height, area and circumference of the rectangle are respectively:" + r1.width + " " + r1.height + " " + r1.getArea() + " " + r1.getPerimeter());
        System.out.println("The width, height, area and circumference of the rectangle are respectively:" + r2.width + " " + r2.height + " " + r2.getArea() + " " + r2.getPerimeter());
	}

}
class Rectangle{
	double width = 1 ;
	double height = 1;
	Rectangle ()
	{
	}
	Rectangle(double width,double height)
	{
		this.width=width;
		this.height=height;
	}
	double getArea()
	{
		return width*height;
	}
	double getPerimeter()
	{
		return 2*(width+height);
	}
}