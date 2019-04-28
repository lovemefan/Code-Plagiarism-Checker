package test1013;




public class Test99 {
	
	public static void main(String[] args) {
	
	
		Regularpolygon regularPolygon1=new Regularpolygon();
		Regularpolygon regularPolygon2=new Regularpolygon(6,4);
		Regularpolygon regularPolygon3=new Regularpolygon(10,4,5.6,7.8);
		
		System.out.println("regularpolygon1 perimeter is"+regularPolygon1.getPerimeter()+"area is"+regularPolygon1.getArea());
		System.out.println("regularpolygon2 perimeter is"+regularPolygon2.getPerimeter()+"area is"+regularPolygon2.getArea());
		System.out.println("regularpolygon3 perimeter is"+regularPolygon3.getPerimeter()+"area is"+regularPolygon3.getArea());
	}
		
	static class Regularpolygon {
		private int n=3;
		private double side=1;
		private double x=0;
		private double y=0;

	public Regularpolygon(){
		
	}

	Regularpolygon(int newN1,double newSide1){
		n=newN1;
		side=newSide1;
		x=0;
		y=0;
	}
	Regularpolygon(int newN1,double newSide1,double newX,double newY ){
		n=newN1;
		side=newSide1;
		x=newX;
		y=newY;
	}
	public void setN(int newN) {
		n=newN ;
	}
	public void setSide(double newSide) {
		side=newSide;
	}
	public void setX(double newX) {
		x=newX ;
	}
	public void setY(double newY) {
		y=newY;
	}
	public int getN() {
		return n;
	}
	public double getSide() {
		return side;
	}
	public double getx() {
		return x;
	}
	public double gety() {
		return y;
	}
	public double getPerimeter() {
		return n*side;
	}
	public double getArea() {
		return (n*side*side)/(4*Math.tan(getPerimeter()/n));
	}
			

	}}





