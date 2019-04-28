package homework;

public class TextRegularPolygon {
	public static void main(String[] args){
		RegularPolygon regular1=new RegularPolygon();
		System.out.println("the perimeter and the area is "+regular1.getPerimeter()+
				" and "+regular1.getArea());
		RegularPolygon regular2=new RegularPolygon(6,4);
		System.out.println("the perimeter and the area is "+regular2.getPerimeter()+
				" and "+regular2.getArea());
		RegularPolygon regular3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("the perimeter and the area is "+regular3.getPerimeter()+
				" and "+regular3.getArea());
	}
}
class RegularPolygon{
	private int n=3;
	private double side=1;
	private double x=0;
	private double y=0;
	RegularPolygon(){	
	}
	RegularPolygon(int newn,double newside){
		n=newn;
		side=newside;
		x=0;
		y=0;
	}
	RegularPolygon(int newn,double newside,double newx,double newy){
		n=newn;
		side=newside;
		x=newx;
		y=newy;
	}
	double getPerimeter(){
		return n*side;
	}
	double getArea(){
		return (n*side*side)/(4*Math.tan(3.14/n));
	}
}