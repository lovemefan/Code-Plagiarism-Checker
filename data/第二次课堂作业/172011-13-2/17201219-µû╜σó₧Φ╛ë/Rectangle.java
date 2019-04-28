package bbb;

public class Rectangle {
	public static void main(String[] args) {
		A rectangle1=new A(4,40);
		System.out.println("width: "+rectangle1.width+" heigth: "+rectangle1.heigth+" area: "+rectangle1.getArea()+" perimeter: "+rectangle1.getPerimeter());
		A rectangle2=new A(3.5,35.9);
		System.out.println("width: "+rectangle2.width+" heigth: "+rectangle2.heigth+" area: "+rectangle2.getArea()+" perimeter: "+rectangle2.getPerimeter());
		
	}

}

class A {
	double width;
	double heigth;
	
	A(){
		width=1;
		heigth=1;
	}
	
	A(double newWidth,double newHeigth){
		width=newWidth;
		heigth=newHeigth;
	}
	
	double getArea() {
		return width*heigth;
	}
	
	double getPerimeter() {
		return 2*(width+heigth);
	}
	
	void setWidth(double newWidth) {
		width=newWidth;
	}
	
	void setHeigth(double newHeigth) {
		heigth=newHeigth;
	}
}
