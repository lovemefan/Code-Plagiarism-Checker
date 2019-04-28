import java.util.*;

public class Rectangle {
	double width;
	double height;
	
	public Rectangle()
	{
		width = 1;
		height = 1;
	}
	
	public Rectangle(double width,double height)
	{
		this.width = width;
		this.height = height;
	}
	
	double getArea()
	{
		return width*height;
	}
	
	double getPerimeter()
	{
		return 2*(width+height);
	}
	
	public static void main(String[] args) 
	{
		Rectangle test1 = new Rectangle(4,40);
		System.out.println("test1 width is :"+test1.width+
				" test1 height is : "+test1.height+
				" test1 area is :"+test1.getArea()+
				" test1 perimeter is : "+test1.getPerimeter());
		
		System.out.println();
		
		Rectangle test2 = new Rectangle(3.5,35.9);
		System.out.println("test2 width is :"+test2.width+
				" test2 height is : "+test2.height+
				" test2 area is :"+test2.getArea()+
				" test2 perimeter is : "+test2.getPerimeter());
		
	}
}
