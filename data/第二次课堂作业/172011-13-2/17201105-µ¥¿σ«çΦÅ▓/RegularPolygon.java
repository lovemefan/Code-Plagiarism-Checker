package yangyufei;
import java.util.Scanner;
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
		System.out.println("The first  Reg :per: "+reg1.getPerimeter()+" area:"+reg1.getArea());
		System.out.println("The second Reg :per: "+reg2.getPerimeter()+" area:"+reg2.getArea());
		System.out.println("The third  Reg :per: "+reg3.getPerimeter()+" area:"+reg3.getArea());
		
	}
	
}