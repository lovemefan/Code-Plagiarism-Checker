package 第二次作业;

public class RegularPolygon {
	private int n=3;
	private double side=1;
	private double x=0,y=0;
	
	public RegularPolygon(){
		this.n=3;
		this.side=1;
		this.x=0;
		this.y=0;
	}
	
	public RegularPolygon(int n,double side){
		this.n=n;
		this.side=side;
		this.x=0;
		this.y=0;
	}
	public RegularPolygon(int n,double side,double x,double y){
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	
	public int getN(){
		return n;
	}
	public void setN(int n){
		this.n=n;
	}
	public double getSide(){
		return side;
	}
	public void setSide(double side){
		this.side=side;
	}
	public double getX(){
		return x;
	}
	public void setX(double x){
		this.x=x;
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y=y;
	}
	
	public double getPerimeter(){
		double per;
		per=n*side;
		return per;
	}
	public double getArea(){
		double area;
		double temp=Math.PI/n;
		area=(n*Math.pow(side, 2))/(4*Math.tan(temp));
		return area;
	}
	
	public static void main(String args[]){
		RegularPolygon reg1=new RegularPolygon();
		RegularPolygon reg2=new RegularPolygon(6,4);
		RegularPolygon reg3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("Reg1 : "+reg1.getPerimeter()+" "+reg1.getArea());
		System.out.println("Reg2 : "+reg2.getPerimeter()+" "+reg2.getArea());
		System.out.println("Reg3 : "+reg3.getPerimeter()+" "+reg3.getArea());
		
	}
}

