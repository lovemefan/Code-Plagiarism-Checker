package test2;

public class TestRectangle {
	public static void main(String[] args){
		Rectangle R1,R2;
		R1 = new Rectangle(4,40);
		R2 = new Rectangle(3.5,35.9);
		System.out.println("The first one's properties are:" + R1.getWidth() + " " + R1.getHeight() + " " + R1.getArea() + " " + R1.getPrimeter());
		System.out.println("The second one's properties are:" + R2.getWidth() + " " + R2.getHeight() + " " + R2.getArea() + " " + R2.getPrimeter());
	}
}
