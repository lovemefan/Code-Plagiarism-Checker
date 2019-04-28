package exercise2;
public class SimpleRectangle {
	public static void main(String[] args){
		SimpleRectangle Rectangle1=new SimpleRectangle();
		System.out.println("The area of the Rectangle of width "+Rectangle1.width+" and height "+Rectangle1.height+" is "+Rectangle1.getArea());
		SimpleRectangle Rectangle2=new SimpleRectangle(3,4);
		System.out.println("The area of the Rectangle of width "+Rectangle2.width+" and height "+Rectangle2.height+" is "+Rectangle2.getArea());
		Rectangle2.setData(5, 6);
		System.out.println("The area of the Rectangle of width "+Rectangle2.width+" and height "+Rectangle2.height+" is "+Rectangle2.getArea());
	}
	double width,height;
	SimpleRectangle(){
		width=height=1;
	}
	SimpleRectangle(double newWidth,double newHeight){
		width=newWidth;
		height=newHeight;
	}
    double getArea(){
    	return width*height;
    }
    void setData(double newWidth,double newHeight){
    	width=newWidth;
		height=newHeight;
    }
}

