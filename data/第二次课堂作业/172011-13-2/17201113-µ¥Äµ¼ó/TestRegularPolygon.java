package homework;

public class TestRegularPolygon {
	public static void main(String[] args){
		RegularPolygon polygon1=new RegularPolygon();
		RegularPolygon polygon2=new RegularPolygon(6,4);
		RegularPolygon polygon3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The perimeter of a regular polygon with "+polygon1.getEdg()+" edgs and "+polygon1.getLength()+" length is "+polygon1.getPerimeter());
		System.out.println("The area of a regular polygon with "+polygon1.getEdg()+" edgs and "+polygon1.getLength()+" length is "+polygon1.getArea());
		System.out.println("The perimeter of a regular polygon with "+polygon2.getEdg()+" edgs and "+polygon2.getLength()+" length is "+polygon2.getPerimeter());
		System.out.println("The area of a regular polygon with "+polygon2.getEdg()+" edgs and "+polygon2.getLength()+" length is "+polygon2.getArea());
		System.out.println("The perimeter of a regular polygon with "+polygon3.getEdg()+" edgs and "+polygon3.getLength()+" length is "+polygon3.getPerimeter());
		System.out.println("The area of a regular polygon with "+polygon3.getEdg()+" edgs and "+polygon3.getLength()+" length is "+polygon3.getArea());
	}

}
