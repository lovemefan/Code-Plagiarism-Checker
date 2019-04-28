
public class TestRegularPolygon {

	public static void main(String[] args) {
		RegularPolygon r1 =new RegularPolygon();
		RegularPolygon r2 =new RegularPolygon(6,4);
		RegularPolygon r3 =new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The r1's perimeter is "+r1.getPerimeter()+" area is "+r1.getArea());
		System.out.println("The r2's perimeter is "+r2.getPerimeter()+" area is "+r2.getArea());
		System.out.println("The r3's perimeter is "+r3.getPerimeter()+" area is "+r3.getArea());
	}

}
