package work;

public class C9_1 {
	public static void main(String[] args){
		Rectangle m1 = new Rectangle(4,40);
		Rectangle m2= new Rectangle(3.5,35.9);
		 System.out.println(m1.width +" "+ m1.height+" "+  m1.getArea() +" "+ m1.getPerimeter());
		 System.out.println(m2.width +" "+ m2.height +" "+ m2.getArea() +" "+ m2.getPerimeter());
		
	}
}
	class Rectangle{
		double width =1;
		double height=1;
	Rectangle(){
		double width =1;
		double height=1;
	}
	Rectangle(double newWidth,double newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}
	double getArea(){
		return width * height;
	}
	double getPerimeter(){
		return 2*(width + height);
	}
		void setWidth(double newWidth){
			width = newWidth;
		}
		void setHeight(double  newHeight){
			height = newHeight;
		}
	}
