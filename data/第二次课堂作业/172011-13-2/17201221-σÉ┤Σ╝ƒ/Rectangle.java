
public class Rectangle {
	double width,height;

	public Rectangle(double Width,double Height){
		width=Width;
		height=Height;
	}
	public double getArea(){
		return (width*height);
		
	}
	public double getPerimeter(){
		return (2*(width+height));
	}

}
