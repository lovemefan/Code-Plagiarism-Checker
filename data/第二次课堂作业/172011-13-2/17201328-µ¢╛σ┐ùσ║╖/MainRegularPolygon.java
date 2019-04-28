
public class MainRegularPolygon {
	public static void main(String[] args){
		RegularPolygon  r1;
		TestRegularPolygon2  r2;
		TestRegularPolygon3  r3;
		r1 = new RegularPolygon();
		r2 = new TestRegularPolygon2();
		r3 = new TestRegularPolygon3();
		System.out.println("its perimerter is " + r1.getPerimeter(r1.getNumber(), r1.getSide())+ " and area is " + r1.getArea(r1.getNumber(), r1.getSide()));
		System.out.println("its perimerter is " + r2.getPerimeter(r2.getNumber(), r2.getSide())+ " and area is " + r2.getArea(r2.getNumber(), r2.getSide()));
		System.out.println("its perimerter is " + r3.getPerimeter(r3.getNumber(), r3.getSide())+ " and area is " + r3.getArea(r3.getNumber(), r3.getSide()));
	}
	
}
