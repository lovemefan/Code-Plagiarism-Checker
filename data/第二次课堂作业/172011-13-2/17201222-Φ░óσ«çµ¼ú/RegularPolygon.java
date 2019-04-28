package nice;

public class RegularPolygon {
	public static void main(String[] args){
		RegularPolygon regularPolygon1 = new RegularPolygon();
		System.out.println("Perimeter is "+ regularPolygon1.getPerimeter() + " Area is "
				+ regularPolygon1.getArea());
		RegularPolygon regularPolygon2 = new RegularPolygon(6,4);
		System.out.println("Perimeter is "+ regularPolygon2.getPerimeter() + " Area is "
				+ regularPolygon2.getArea());
		RegularPolygon regularPolygon3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("Perimeter is "+ regularPolygon3.getPerimeter() + " Area is "
				+ regularPolygon3.getArea());
	}
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	public RegularPolygon(){
		
	}
	public void setN(int newN){
		n = newN;
	}
	public void setSide(double newSide){
		side = newSide;
	}
	public void setX(double newX){
		x = newX;
	}
	public void setY(double newY){
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
	RegularPolygon(int N,int Side){
		n = N;
		side = Side;
	}
	RegularPolygon(int newN,double newSide,double newX,double newY){
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	    
	}
	double getPerimeter(){
		return n*side;
	}
	double getArea(){
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
	

}
