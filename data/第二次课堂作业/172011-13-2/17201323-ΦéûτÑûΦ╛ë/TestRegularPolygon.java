package work;

public class TestRegularPolygon {
	public static void main (String[] args){
		RegularPolygon regularPolygon1 = new RegularPolygon();
		RegularPolygon regularPolygon2 = new RegularPolygon(6,4);
		RegularPolygon regularPolygon3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println ("regularPolygon1 perimeter: " + regularPolygon1.getPerimeter() + "area: " + regularPolygon1.getArea());
		System.out.println ("regularPolygon2 perimeter: " + regularPolygon2.getPerimeter() + "area: " + regularPolygon2.getArea());
		System.out.println ("regularPolygon3 perimeter: " + regularPolygon3.getPerimeter() + "area: " + regularPolygon3.getArea());
	}

}
