package HelloWorld;

public class TestRectangle {
	public static void main(String[] args) {
		   Rectangle r1=new Rectangle(4,40);
		   Rectangle r2=new Rectangle(3.5,35.9);
		   System.out.println("The area of the rectangle of width"+r1.width+"and height"+r1.height+"is"+r1.getArea());
		   System.out.println("The perimeter of the rectangle of width"+r1.width+"and height"+r1.height+"is"+r1.getPerimeter());
		    System.out.println("The area of the rectangle of width"+r2.width+"and height"+r2.height+"is"+r2.getArea());
		    System.out.println("The perimeter of the rectangle of width"+r2.width+"and height"+r2.height+"is"+r2.getPerimeter());
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
	   double getPerimeter(){
		   return 2*width+2*height;
	   }
	   void setWidth(double newWidth){
		   width=newWidth;
	   }
	   void setHeight(double newHeight){
		   height=newHeight;
	   }
	   }

