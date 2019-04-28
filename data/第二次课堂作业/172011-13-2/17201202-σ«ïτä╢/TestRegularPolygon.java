package ื๗าต;

public class TestRegularPolygon {
	public static void main(String[] args){
		RegularPolygon r1=new RegularPolygon();
		RegularPolygon r2=new RegularPolygon(6,4);
		RegularPolygon r3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("regularpolygon1's perimeter is "+r1.getPerimeter()
		+" area is "+r1.getArea());
		System.out.println("regularpolygon2's perimeter is "+r2.getPerimeter()
		+" area is "+r2.getArea());
		System.out.println("regularpolygon3's perimeter is "+r3.getPerimeter()
		+" area is "+r3.getArea());
			
	}

}

class RegularPolygon{
	int n=3;
	double side=1;
	double x=0;
	double y=0;
	
	RegularPolygon(){
		
	}
	RegularPolygon(int N,double SIDE){
		x=0;
		y=0;
		n=N;
		side=SIDE;
	}
	RegularPolygon(int N,double SIDE,double X,double Y){
        x=X;
        y=Y;
        n=N;
        side=SIDE;
	}
	int N(){
		return n;
	}
	double Side(){
		return side;
	}
	double X(){
		return x;
	}
	double Y(){
		return y;
	}
	void setN(int newN){
		n=newN;
	}
	void setSide(double newSide){
		side=newSide;
	}
	void setX(double newX){
		x=newX;
	}
	void setY(double newY){
		y=newY;
	}
	double getPerimeter(){
		return n*side;
	}
	double getArea(){
		return (n*side*side)/4*Math.tan(Math.PI/n);
	}
	
}
