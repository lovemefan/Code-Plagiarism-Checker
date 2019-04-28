package work;

public class TestRegularPolygon {
	public static void main(String[] args){
    RegularPolygon c1=new RegularPolygon();
    System.out.println("N   Side   X     Y   Perimeter       Area");
    System.out.println(c1.getN()+"   "+c1.getSide()+"   "+c1.getX()+"   "+c1.getY()+"   "+c1.getPerimeter()+"        "+c1.getArea());
    RegularPolygon c2=new RegularPolygon(6,4);
    System.out.println(c2.getN()+"   "+c2.getSide()+"   "+c2.getX()+"   "+c2.getY()+"   "+c2.getPerimeter()+"       "+c2.getArea());
    RegularPolygon c3=new RegularPolygon(10,4,5.6,7.8);
    System.out.println(c3.getN()+"  "+c3.getSide()+"   "+c3.getX()+"   "+c3.getY()+"   "+c3.getPerimeter()+"       "+c3.getArea());
	}
}