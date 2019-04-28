package homework;

public class RegularPolygon {
	private int n;
	private double side,x,y;
	public RegularPolygon(){
		n=3;
		side=1;
		x=0;
		y=0;
	}
	public RegularPolygon(int n,double side){
		this.n=n;
		this.side=side;
		x=0;
		y=0;
	}
	public RegularPolygon(int n,double side,double x,double y){
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	public void setn(int n){
		this.n=n;
	}
	public void setside(double side){
		this.side=side;
	}
	public void setx(double x){
		this.x=x;
	}
	public void sety(double y){
		this.y=y;
	}
	public int getn(){
		return n;
	}
	public double getside(){
		return side;
	}
	public double getx(){
		return x;
	}
	public double gety(){
		return y;
	}
	public double getPerimeter(){
		return(n*side);
	}
	public double getArea(){
		return((n*side*side)/(4*Math.tan(Math.PI/n)));
	}

}
