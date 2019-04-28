 package homework; 

public class Rectangle {
        public static void main(String[] args){
        	SimpleRectangle rectangle1=new SimpleRectangle(4,40);
        	System.out.println("The area of the width "+rectangle1.width+" height "+rectangle1.height+" perimeter is "+rectangle1.getPerimeter()+" ,and area is "+rectangle1.getArea());
        	SimpleRectangle rectangle2=new SimpleRectangle(3.5,35.9);
        	System.out.println("The area of the width "+rectangle2.width+" height "+rectangle2.height+" perimeter is "+rectangle2.getPerimeter()+" ,and area is "+rectangle2.getArea());
        }
}

class SimpleRectangle{
	double width,height;
	SimpleRectangle(){
		width=1;
		height=1;
	}
	
	SimpleRectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
		double getArea(){
			return width*height;
		}
		double getPerimeter(){
			return 2*(width+height);
	}
		void setRectangle(double newWidth,double newHeight){
			width=newWidth;
			height=newHeight;
		}
}