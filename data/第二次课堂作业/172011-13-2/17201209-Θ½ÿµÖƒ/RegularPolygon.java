
public class RegularPolygon {
	public static void main(String[] args){
    //RegularPolygon regularpolygon1 = new  RegularPolygon();
     RegularPolygon regularpolygon1 = new  RegularPolygon(6,4);
     System.out.println("The regularpolygon1's area is "+regularpolygon1.getArea()+" perimeter is "+regularpolygon1.getPerimeter());
     
     RegularPolygon regularpolygon2 = new  RegularPolygon(10, 4, 5.6, 7.8);
     System.out.println("The regularpolygon2's area is "+regularpolygon2.getArea()+" perimeter is "+regularpolygon2.getPerimeter());
	}
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	RegularPolygon(){
		
	}
	RegularPolygon(int newN1, double newSide1){
		n = newN1;
		side = newSide1;
	}
	RegularPolygon(int newN2, double newSide2, double newX, double newY){
		n = newN2;
		side = newSide2;
		x = newX;
		y = newY;
	}
	public int getN(){
		return n;
	}
	public void setN(int n){
		this.n = n;
	}
	public double getSide(){
		return side;
	}
	public void setSide(double side){
		this.side = side;
	}
	public double getX(){
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
	double getArea(){
		return (n * side * side) /(4 * Math.tan(Math.PI / n));
	}
	double getPerimeter(){
		return n * side;
	}
}
