package yangyufei;

public class Rectangle {
	public static void main(String[] args){
		SimpleRectangle rectangle1 = new SimpleRectangle(4,40);
		SimpleRectangle rectangle2 = new SimpleRectangle(3.5,35.9);
		System.out.println("rectangle 1 width is " + rectangle1.width +" rectangle 1 height is " + rectangle1.height +" area is " + rectangle1.getArea() + " permiter is " + rectangle1.getPerimeter());
		
		System.out.println("rectangle 2 width is " + rectangle2.width +" rectangle 1 height is " + rectangle2.height +" area is " + rectangle2.getArea() + " permiter is " + rectangle2.getPerimeter());
	}
   static class SimpleRectangle {
	  double width;
	  double height;
	  SimpleRectangle(){
		width = 1;
		height = 1;
	  }
	  SimpleRectangle(double newWidth, double newHeight){
		width = newWidth;
	 	height = newHeight;
	 }
	
	 public double getArea(){
	 	double area = width * height;
		return area;
	}
	
	public double getPerimeter(){
		double perimeter = (width + height) * 2;
		return perimeter;
	}
}
}