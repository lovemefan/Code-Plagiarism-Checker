package test;

public class exe9_1 {
	public static void main(String[] args) {
		Rectangle r1,r2;
		r1 = new Rectangle();
		r2 = new Rectangle();
		r1.Rectangle(4, 40);
		r2.Rectangle(3.5, 35.9);
		System.out.print(r1.getPerimeter()+"  ");
		System.out.println(r1.getArea());
		System.out.print(r2.getPerimeter()+"  ");
		System.out.println(r2.getArea());

	}

}

class Rectangle{
	double width,height=1;
	public Rectangle(){
		
	}
	public void Rectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
	double getArea() {
		return width*height;
	}
	double getPerimeter(){
		return (width+height)*2;
	}
}
