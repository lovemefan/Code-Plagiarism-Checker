
public class TestRegularPolygon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularPolygon r1,r2,r3;
		r1 = new RegularPolygon();
        r2 = new RegularPolygon(6,4);
        r3 = new RegularPolygon(10,4,5.6,7.8);
        System.out.println("The perimeter,area of r1 is:" + r1.getPerimeter() + " and " + r1.getArea());
        System.out.println("The perimeter,area of r2 is:" + r2.getPerimeter() + " and " + r2.getArea());
        System.out.println("The perimeter,area of r3 is:" + r3.getPerimeter() + " and " + r3.getArea());
	}

}
