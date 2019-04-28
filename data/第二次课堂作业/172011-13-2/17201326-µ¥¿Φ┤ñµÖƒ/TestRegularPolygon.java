package test2;

public class TestRegularPolygon {
	public static void main(String[] args){
	RegularPolygon R1 = new RegularPolygon();
	RegularPolygon R2 = new RegularPolygon(6,4);
	RegularPolygon R3 = new RegularPolygon(10,4,5.6,7.8);
	System.out.println("The first one is " + R1.getArea() + " "+ R1.getPerimeter() + "The second one is " + R2.getArea() + " "+ R2.getPerimeter() + "The third one is " + R3.getArea() + " "+ R3.getPerimeter() );
	}
}
