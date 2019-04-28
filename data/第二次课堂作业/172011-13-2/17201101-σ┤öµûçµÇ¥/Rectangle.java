package workTwo;

public class Rectangle {
	public static void main(String[] args){
		
		 Rectangle one= new Rectangle(4,40);
		 System.out.println("the width is  "+one.width+"and the height is  "+one.height);
		 System.out.println("the area is   "+one.getArea() + "and the perimeter is  "+one.getPerimeter());
		 
		 Rectangle two= new Rectangle(3.5,35.9);
		 System.out.println("the width is  "+two.width+"and the height is  "+two.height);
		 System.out.println("the area is  "+two.getArea() + "and the perimeter is  "+two.getPerimeter());
	}
	
	
	double width=1;
	double height=1;

	 Rectangle(){
		
		 
	 }
    
	 
    Rectangle(double newWidth,double newHeight){
        width = newWidth;
    	height=newHeight;
    }	
    
    double getArea(){
    	return width*height;
    }
    double getPerimeter(){
    	return 2*(width+height);
    }
    
}
  
