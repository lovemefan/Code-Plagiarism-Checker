package RegularPolygon;//9.9

public class RegularPolygonMain {
	public static void main(String[] args) {
		RegularPolygon r1,r2,r3;
		r1 = new RegularPolygon();
		r2 = new RegularPolygon(6,4.0);
		r3 = new RegularPolygon(10,4.0,5.6,7.8);
		System.out.println("The regularPolygon'perimeter is " + r1.getPerimeter() + " and regularPolygon'perimeter is " +r1.getArea());	
    	System.out.println("The regularPolygon'perimeter is " + r2.getPerimeter() + " and regularPolygon'perimeter is " +r2.getArea());
		System.out.println("The regularPolygon'perimeter is " + r3.getPerimeter() + " and regularPolygon'perimeter is " +r3.getArea());
	}

}
