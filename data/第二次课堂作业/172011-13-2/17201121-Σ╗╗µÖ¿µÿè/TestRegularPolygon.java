package TestRegularPolygon;

public class TestRegularPolygon {
	
	public static void main(String[] args){
		RegularPolygon regular1 = new RegularPolygon();
		System.out.println("regular1\n perimeter:" + regular1.getPerimeter() + " area:" + regular1.getArea());
		RegularPolygon regular2 = new RegularPolygon(6,4);
		System.out.println("regular2\n perimeter:" + regular2.getPerimeter() + " area:" + regular2.getArea());
		RegularPolygon regular3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("regular3\n perimeter:" + regular3.getPerimeter() + " area:" + regular3.getArea());
	}
}
class RegularPolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	
	public RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int newNum, double newLen){//中心0.0
		n = newNum;
		side = newLen;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int newNum, double newLen, double newX, double newY){//中心x.y
		n = newNum;
		side = newLen;
		x = newX;
		y = newY;
	}
	
	public int getN(){
		return n;
	}
	
	public double getSide(){
		return side;
	}
	
	public double getX(){
		return x;
	}
		
	public double getY(){
		return y;
	}
	
	public void setN(int newNum){
		n = newNum;
	}

	public void setSide(double newLen){
		side = newLen;
	}

	public void setX(double X){
		x = X;
	}
	
	public void setY(double newY){
		y = newY;
	}
	
	public double getPerimeter(){
		return n*side;
	}
	
	public double getArea(){
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
}

