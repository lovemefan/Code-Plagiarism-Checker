class RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;			
	}
	  RegularPolygon(int N,double Side){
		 n = N;
		 side = Side;
		 x = 0;
		 y = 0;
	}
	  RegularPolygon(int N2,double Side2,double X,double Y) {
		 n = N2;
		 side = Side2;
		 x = X;
		 y= Y;
	 }
	 double getPerimeter() {
		 return n*side;
	 }
	double getArea() {
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
	int getNumber() {
		return n;
	}
	void setNumber(int Number) {
		n = Number;
	}
	double getSide() {
		return side;
		
	}
	void setSide(double Side) {
		side = Side;
		
	}
	double getX() {
		return x;
	}
	void setX(double X2) {
		x = X2;
		
	}
	double getY() {
		return y;
	}
	void setY(double Y2) {
		y = Y2;
		
	}
	public static void main(String[] args) {
		RegularPolygon R1 = new RegularPolygon();
		RegularPolygon R2 = new RegularPolygon(6,4);
		RegularPolygon R3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("Their perimeter and area are " + R1.getPerimeter() + "," + R1.getArea() + ";"
		+R2.getPerimeter() + "," + R2.getArea() + ";" + R3.getPerimeter() + "," + R3.getArea()	+ "."	);
	
		
	}
	
	
	
	
	

}
