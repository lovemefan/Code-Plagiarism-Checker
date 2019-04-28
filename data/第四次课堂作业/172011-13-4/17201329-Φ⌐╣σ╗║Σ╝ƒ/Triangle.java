
public class Triangle extends GeometricObject {
	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;
	
	public Triangle(){
		
	}
	
	public Triangle(double side1,double side2,double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getArea(){
		double p = (side1 + side2 +side3)/2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
	
	public double gerPerimeter(){
		return side1 + side2 + side3;
	}
	
	@Override
	public String toString(){
		return "Triangle side1 = " + side1 + " side2 = " + side2 + "side3 = " + side3;
	}
}
