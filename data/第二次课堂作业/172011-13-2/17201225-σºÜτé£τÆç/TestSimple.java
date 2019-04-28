
public class TestSimple {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle(4, 40);	
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);	
		System.out.println(rectangle1.getArea());
		System.out.println(rectangle1.getPerimeter());
		System.out.println(rectangle2.getArea());
		System.out.println(rectangle2.getPerimeter());
	}
}
