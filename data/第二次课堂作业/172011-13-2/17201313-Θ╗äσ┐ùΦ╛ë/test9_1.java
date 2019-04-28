package classtest;

import java.util.Scanner;

public class test9_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rectangle rectangle1 = new Rectangle();
		rectangle1.width = 5;
		rectangle1.height = 3;
		System.out.println("Rectangle1's area is : "+rectangle1.getArea());
		System.out.println("Rectangle1's perimeter is : "+rectangle1.getPerimeter());
		Rectangle rectangle2 = new Rectangle();
		System.out.print("Enter rectangle2's width and height: ");
		rectangle2.setWidth(input.nextDouble());
		rectangle2.setHeight(input.nextDouble());
		System.out.println("Rectangle2's area is : " + rectangle2.getArea());
		System.out.println("Rectangle2's perimeter is : " + rectangle2.getPerimeter());
		if(input != null) {
			input.close();
		}	
	}
}

class Rectangle{
	double width;
	double height;
	Rectangle(){
		width = 1;
		height = 1;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	double getArea(){
		return width * height;
	}
	double getPerimeter(){
		return 2 * (height + width);
	}
}