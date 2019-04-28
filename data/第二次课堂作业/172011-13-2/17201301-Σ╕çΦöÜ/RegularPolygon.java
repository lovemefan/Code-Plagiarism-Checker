
public class RegularPolygon {

	public static void main(String[] args) {
		RegularPolygon regular1 = new RegularPolygon();
		System.out.println("The perimeter of " + regular1.n + " regularpolygon with side of " + 
		regular1.side + " is " + regular1.getPerimeter());
		System.out.println("The area of " + regular1.n + " regularpolygon with side of " + 
				regular1.side + " is " + regular1.getArea());
		
		RegularPolygon regular2 = new RegularPolygon(6, 4);
		System.out.println("The perimeter of " + regular2.n + " regularpolygon with side of " + 
				regular2.side + " is " + regular2.getPerimeter());
		System.out.println("The area of " + regular2.n + " regularpolygon with side of " + 
				regular2.side + " is " + regular2.getArea());

		RegularPolygon regular3 = new RegularPolygon(10, 4, 5.6, 7.8);
		System.out.println("The perimeter of " + regular3.n + " regularpolygon with side of " + 
				regular3.side + " is " + regular3.getPerimeter());
		System.out.println("The area of " + regular3.n + " regularpolygon with side of " + 
				regular3.side + " is " + regular3.getArea());
	}
	
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
	public RegularPolygon(int newN, double newSide){
		this.n = newN;
		this.side = newSide;
		this.x = 0;
		this.y = 0;
	}
	
	public RegularPolygon(int newN, double newSide,double newX, double newY){
		this.n = newN;
		this.side = newSide;
		this.x = newX;
		this.y = newY;
	}
	
	public void setRegular(int newN, double newSide, double newX, double newY){
		this.n = newN;
		this.side = newSide;
		this.x = newX;
		this.y = newY;
	}
	
	public double getPerimeter(){
		return n * side;
	}
	
	public double getArea(){
		double area = (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
		return area;
	}

}
