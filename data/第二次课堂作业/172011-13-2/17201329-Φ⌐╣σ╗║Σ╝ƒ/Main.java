
public class Main {
	public static void main(String [] agrs){
		RectTangle a;
		a = new RectTangle();
		a.setHeight(40);
		a.setWidth(4);
		System.out.println(a.getWidth());
		System.out.println(a.getHeight());
		System.out.println(a.getArea());
		System.out.println(a.getPerimeter());
		RectTangle b;
		b = new RectTangle();
		b.setHeight(3.5);
		b.setWidth(35.9);
		System.out.println(b.getWidth());
		System.out.println(b.getHeight());
		System.out.println(b.getArea());
		System.out.println(b.getPerimeter());
	}

}
