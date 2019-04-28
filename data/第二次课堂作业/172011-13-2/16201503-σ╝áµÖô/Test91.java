package test1013;


public class Test91 {

	public static void main(String[] args) {
		
		Rectangle rectangle1=new Rectangle(4,40);
		Rectangle rectangle2=new Rectangle(3.5,35.9);
		System.out.print("rectangle1 width is"+rectangle1.width+"height is"+rectangle1.height+"area is"+rectangle1.getArea()+"petimeter is"+rectangle1.getPerimeter()+"\n");
		System.out.print("rectangle2 width is"+rectangle2.width+"height is"+rectangle2.height+"area is"+rectangle2.getArea()+"petimeter is"+rectangle2.getPerimeter());

	}

}
class Rectangle{
	Double width=1.0;
	Double height=1.0;
	
	public Rectangle() {
	}
	
	public Rectangle(double newWidth,double newHeight) {
		width=newWidth ;
		height=newHeight ;
		}
	
	public double getArea() {
		return  width*height;
	}
	
	public double getPerimeter() {
		return width + height ;
	}
	
	
}
