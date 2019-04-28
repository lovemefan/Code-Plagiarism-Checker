package regularpolygon;

public class RegularPolygon {
	public static void main(String[] args){
		RegularPolygon regularPolygon1 = new RegularPolygon();
		System.out.println("the regularpolygon1 \nperimeter is " + regularPolygon1.getPerimeter() + "\narea is " +  regularPolygon1.getarea());
		RegularPolygon regularPolygon2 = new RegularPolygon(6,4);
		System.out.println("the regularpolygon2 \nperimeter is " + regularPolygon2.getPerimeter() + "\narea is " +  regularPolygon2.getarea());
		RegularPolygon regularPolygon3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("the regularpolygon3 \nperimeter is " + regularPolygon3.getPerimeter() + "\narea is " +  regularPolygon3.getarea());
	}
	private int n;
	private double side, x, y;
	
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	
	RegularPolygon(int newN,double newSide){
		this.n = newN;
		this.side = newSide;
		x = 0;
		y = 0;
	}
	
	RegularPolygon(int newN,double newSide,double newX,double newY){
		this.n = newN;
		this.side = newSide;
		this.x = newX;
		this.y = newY;
	}
	
	void getRegularPolygon(){
		System.out.println("The regularpolygon is\n" + n + "\n" + side + "\n" + x + "\n" + y);
	}
	
	void setRegularPolygon(int newN,double newSide,double newX,double newY){
		this.n = newN;
		this.side = newSide;
		this.x = newX;
		this.y = newY;
	}
	
	double getPerimeter(){
		return n * side;
	}
	
	double getarea(){
		return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI/n));
	}
}
