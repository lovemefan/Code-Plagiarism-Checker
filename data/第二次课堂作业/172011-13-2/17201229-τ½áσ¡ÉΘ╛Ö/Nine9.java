
public class Nine9 {

	public static void main(String[] args) {
		RegularPolygon a1 = new RegularPolygon();
		RegularPolygon a2 = new RegularPolygon(6,4);
		RegularPolygon a3 = new RegularPolygon(10,4,5.6,7.8);

		System.out.println("Perimeter: "+ a1.getPerimeter() +"     Area:" + a1.getArea());
		System.out.println("Perimeter: "+ a2.getPerimeter() +"     Area:" + a2.getArea());
		System.out.println("Perimeter: "+ a3.getPerimeter() +"     Area:" + a3.getArea());
	}

}

class RegularPolygon{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	RegularPolygon(){}
	
	public RegularPolygon(int n,double side){
		this.n=n;
		this.side=side;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int n,double side,double x,double y){
		this.n=n;
		this.side=side;
		this.x = x;
		this.y = y;
	}
	
	public double getPerimeter(){
		return n*side;
	}
	
	public double getArea(){
		return n*side*side/(4*Math.tan(Math.PI/n));
	}
}