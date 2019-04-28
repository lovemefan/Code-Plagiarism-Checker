import java.util.Scanner;

public class RectangleMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle();

		System.out.print("Enter rectangle1's width and height: ");
		rectangle1.setWidth(input.nextDouble());
		rectangle1.setHeight(input.nextDouble());
		System.out.println("Rectangle1's area is : " + rectangle1.getArea());
		System.out.println("Rectangle1's perimeter is : " + rectangle1.getPerimeter());

		System.out.print("Enter rectangle2's width and height: ");
		rectangle2.setWidth(input.nextDouble());
		rectangle2.setHeight(input.nextDouble());
		System.out.println("Rectangle2's area is : " + rectangle2.getArea());
		System.out.println("Rectangle2's perimeter is : " + rectangle2.getPerimeter());

		input.close();
	}

}

class Rectangle {
	private double width;
	private double height;

	public Rectangle() {
		width = 1;
		height = 1;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return 2 * (height + width);
	}
}