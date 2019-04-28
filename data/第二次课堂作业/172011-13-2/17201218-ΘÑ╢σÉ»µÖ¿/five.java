package workone;

public class five {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4.0,40);
		Rectangle rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("rectangle1:");
		System.out.println("width: " + rectangle1.width + "\theight: " + rectangle1.height + 
                "\tarea: " + rectangle1.getArea() + "\tperimeter: " + rectangle1.getPerimeter());
		System.out.println("rectangle2:");
        System.out.println("width: " + rectangle2.width + "\theight: " + rectangle2.height + 
                "\tarea: " + rectangle2.getArea() + "\tperimeter: " + rectangle2.getPerimeter());
	}
}
class Rectangle {

    double width = 1;
    double height = 1;

    public Rectangle() {
    }

    public Rectangle(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

}