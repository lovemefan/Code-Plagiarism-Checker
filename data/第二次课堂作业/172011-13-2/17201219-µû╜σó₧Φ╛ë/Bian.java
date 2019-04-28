package fff;

public class Bian {
	public static void main(String[] args) {
		A bian1=new A();
		System.out.println("perimeter: "+bian1.setPerimeter()+" area "+bian1.setArea());
		A bian2=new A(6,4);
		System.out.println("perimeter: "+bian2.setPerimeter()+" area "+bian2.setArea());
		A bian3=new A(10,4,5.6,7.8);
		System.out.println("perimeter: "+bian3.setPerimeter()+" area "+bian3.setArea());
	}

}

class A{
	private int n;
	private double side;
	private double x;
	private double y;
	A(){
		n=3;
		side=1;
		x=0;
		y=0;
	}
	A(int newN,double newSide){
		n=newN;
		side=newSide;
	}
	A(int newN,double newSide,double newX,double newY){
		n=newN;
		side=newSide;
		x=newX;
		y=newY;
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
	double setArea(){
		double b;
		b=(n*Math.pow(side, 2))/(4*Math.tan((Math.PI/n)));
		return b;
	}
	double setPerimeter(){
		return n*side;
	}
}