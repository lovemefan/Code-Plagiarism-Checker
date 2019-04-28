import java.util.Scanner;

public class Test9_1 {


public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	Rectangle rec1 =  new Rectangle();
	System.out.println("Enter width and height of the rectangle1");
	rec1.setRectangle1(input.nextDouble()); 
	rec1.setRectangle(input.nextDouble());
	System.out.println("The area of rectangle is "+rec1.getArea());
	System.out.println("The prtieter ofrectangle is "+rec1.getPerimeter());
	Rectangle rec2 =  new Rectangle();
	System.out.println("Enter width and height of the rectangle2");
	rec2.setRectangle1(input.nextDouble()); 
	rec2.setRectangle(input.nextDouble());
	System.out.println("The area of rectangle is "+rec2.getArea());
	System.out.println("The prtieter ofrectangle is "+rec2.getPerimeter());
	
}
}
class Rectangle {
	double width = 1;
	double height = 1;
	Rectangle() {
		}
	 void setRectangle1(double newWidth){
		width = newWidth;
		
	}
	 void setRectangle(double newHeight){
		height = newHeight;
		
	}
	double getArea(){
		return width*height;  
	}
	double getPerimeter(){
		return 2*(width+height);
	}
}
