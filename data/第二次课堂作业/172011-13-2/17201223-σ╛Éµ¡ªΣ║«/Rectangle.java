package homework;

public class Rectangle {
	double width,height;
	public Rectangle(){
		width=1;
		height=1;
	}
	public Rectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
	public double getArea(){
		return (width*height);
		
	}
	public double getPerimeter(){
		return (2*(width+height));
	}

}
