package test;

public class exe9_9 {
	public static void main(String[] args) {
		RegularPolygon r1,r2,r3;
		r1=new RegularPolygon();
		r2=new RegularPolygon(6,4);
		r3=new RegularPolygon(10,4,5.6,7.8);
		
		System.out.println("r1 premiter is "+r1.getPerimeter()+" area is "+r1.getArea());
		System.out.println("r2 premiter is "+r2.getPerimeter()+" area is "+r2.getArea());
		System.out.println("r3 premiter is "+r3.getPerimeter()+" area is "+r3.getArea());
	}

}


class RegularPolygon{
	private int n;
	private double side;
	private double x,y;
	RegularPolygon(){
		n=3;
		side=1;
		x=0;
		y=0;
	}
	
	RegularPolygon(int newN,double newSide){
		n=newN;
		side=newSide;
		x=0;
		y=0;
	}
	
	RegularPolygon(int newN,double newSide,double newX,double newY){
		n=newN;
		side=newSide;
		x=newX;
		y=newY;
	}
	
	public void setN(int newN) {
		n=newN;
	}
	public int getN() {
		return n;
	}
	
	public void setSide(double newSide) {
		side=newSide;
	}
	public double getSide() {
		return side;
	}
	
	public void setX(double newX) {
		x=newX;
	}
	public double getX() {
		return x;
	}
	
	public void setY(double newY) {
		y=newY;
	}
	public double getY() {
		return y;
	}
	public double getPerimeter() {
		return n*side;
	}
	public double getArea() {
		double a;
		a=(n*Math.pow(side, 2)/(4*Math.tan(Math.PI/n)));
		return a;
	}
	
	
	
}