package assignments1;

public class work9_9 {
	public static void main(String[] args){
		RegularPolygon rp1 = new RegularPolygon();
		RegularPolygon rp2 = new RegularPolygon(6,4.0);
		RegularPolygon rp3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("rp1's perimetere is : "+rp1.getPerimetere()+" ,and the area is: "+rp1.getArea());
		System.out.println("rp2's perimetere is : "+rp2.getPerimetere()+" ,and the area is: "+rp2.getArea());
		System.out.println("rp3's perimetere is : "+rp3.getPerimetere()+" ,and the area is: "+rp3.getArea());
	}
}
class RegularPolygon{
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
	RegularPolygon(int n,double side){
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}
	RegularPolygon(int n,double side,double x,double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	void setn(int n){
		this.n = n;
	}
	void setside(double side){
		this.side = side;
	}
	void setx(double x){
		this.x = x;
	}
	void sety(double y){
		this.y = y;
	}
	int getn(){
		return n;
	}
	double getside(){
		return side;
	}
	double getx(){
		return x;
	}
	double gety(){
		return y;
	}
	double getPerimetere(){
		return side*n;
	}
	double getArea(){
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
}