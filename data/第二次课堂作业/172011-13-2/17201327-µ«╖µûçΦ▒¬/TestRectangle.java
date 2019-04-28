
public class TestRectangle {

	public static void main(String[] args) {
		double width1 = 4,height1 = 40,width2 = 3.5,height2 = 35.9;
		Rectangle a = new Rectangle(width1,height1);
		Rectangle b = new Rectangle(width2,height2);
		double area1 = a.getArea();
		double perimeter1 = a.getPerimeter();
		double area2 = b.getArea();
		double perimeter2 = b.getPerimeter();
		System.out.println("The first rectangle'width,height,area and perimeter are "
		+ width1 + " " + height1 + " " + area1 + " " + perimeter1);
		System.out.println("The second rectangle'width,height,area and perimeter are "
		+ width2 + " " + height2 + " " + area2 + " " + perimeter2);
	}
	
}
