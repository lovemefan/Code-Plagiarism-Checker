
public class Test9_9 {
 
	public static void main (String[] args){
		PegularPolygon peg1 = new PegularPolygon();
		PegularPolygon peg2 = new PegularPolygon(6,4);
		PegularPolygon peg3 = new PegularPolygon(10,4,5.6,7.8);
		System.out.println("the preimeter of pegularpolygon1 is "+peg1.getPerimeter()+"and area of pegularpolygon1 is "+peg1.getArea());
		System.out.println("the preimeter of pegularpolygon2 is "+peg2.getPerimeter()+"and area of pegularpolygon2 is "+peg2.getArea());
		System.out.println("the preimeter of pegularpolygon3 is "+peg3.getPerimeter()+"and area of pegularpolygon3 is "+peg3.getArea());
	}
}
class PegularPolygon{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	PegularPolygon(){
	
	}
	PegularPolygon(double side,int n){
		this.side = side;
		this.n = n;
		
	}
	PegularPolygon(double side,int n,double x,double y){
		this.x = x;
		this.y = y;
		this.side = side;
		this.n = n;
		
	}
	void setN(int n){
		this.n = n;
		
	}
	void setSide(double side){
		this.side = side;
		
	}
	void setX(double x){
		this.x = x;
		
	}
	void setY(double y){
		this.y = y;
	}
	int getN(int n){
		return n;
	}
	double getSide(double side){
		return side;
	}
	double getX(double x){
		return x;
	}
	double getY(double y){
		return y;
	}
	double getPerimeter(){
		return n*side;
			
	}
	double getArea(){
		return n*side*side/(4*Math.tan(Math.PI /n));
	}
}