                                                
public class RectTangle {
	private double width=1;
	private double height=1;
	
	public RectTangle(){
		
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	public double getWidth(){
		return width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public double getHeight(){
		return height;
	}
	public double getArea(){
		return height*width;
	}
	public double getPerimeter(){
		return (height+width)*2;
	}
}
