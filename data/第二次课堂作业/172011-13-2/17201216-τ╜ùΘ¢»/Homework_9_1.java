import java.util.Scanner;

public class Homework_9_1 {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(40 ,4);
		Rectangle rect2 = new Rectangle(35.9, 3.5);
		
		System.out.printf("height = %.1f, width = %.1f ,area = %.1f, perimeter = %.1f\n"
			, rect1.getHeight(), rect1.getWidth(), rect1.getArea(), rect1.getPerimeter());
		
		System.out.printf("height = %.1f, width = %.1f ,area = %.1f, perimeter = %.1f\n"
			, rect2.getHeight(), rect2.getWidth(), rect2.getArea(), rect2.getPerimeter());
	}
	
}

class Rectangle {
	private double height,width;
	
	Rectangle() {
	}
	
	Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	double getArea() {
		return height * width;
	}
	double getPerimeter() {
		return 2 * (height + width);
	}
	double getHeight() {
		return height;
	}
	double getWidth() {
		return width;
	}
}