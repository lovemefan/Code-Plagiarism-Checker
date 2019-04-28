
public class TestRegularPolygon {
	
	public static void main(String[] args) {
		RegularPolygon a,b,c;
		a = new RegularPolygon();
		b = new RegularPolygon(6,4);
		c = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The first perimeter and area is " + a.getPerimeter() + " and " + a.getArea());
		System.out.println("The second perimeter and area is " + b.getPerimeter() + " and " + b.getArea());
		System.out.println("The third perimeter and area is " + c.getPerimeter() + " and " + c.getArea());
	}
	
}
