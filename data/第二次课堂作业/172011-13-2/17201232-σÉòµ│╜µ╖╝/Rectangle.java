
public class Rectangle {
	double width;
	double height;
	public  Rectangle(){
		width = 1;
		height = 1;				
	}
	public Rectangle(double width ,double height){
		this.width = width;
		this.height = height;
	}
    double getArea(){
    	return width * height;
    }
    double getPerimeter(){
    	return 2*(width + height);
    }
    
public static void main(String[] args){
	Rectangle rectangle1 = new Rectangle(4,40);
	System.out.println("  The width is :  " + rectangle1.width+
			"  The height is :  " + rectangle1.height+
			"  The Areas is :  " + rectangle1.getArea()+
			"  The Perimeters is :  " + rectangle1.getPerimeter());
	
	Rectangle rectangle2 = new Rectangle(3.5,35.9);
	System.out.println("  The width is :  " + rectangle2.width+
			"  The height is :  " + rectangle2.height+
			"  The Areas is :  " + rectangle2.getArea()+
			"  The Perimeters is :  " + rectangle2.getPerimeter());
	
}    

}
