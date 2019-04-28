package ื๗าต;
public class TestRectangle {
	public static void main(String[] args){
		Rectangle rec1=new Rectangle();
		System.out.println("input rectangle1's width and height");
		rec1.width=4;
		rec1.height=40;
		
		Rectangle rec2=new Rectangle();
		System.out.println("input rectangle2's width and height");
		rec2.width=3.5;
		rec2.height=35.9;
		
		System.out.println("rectangle1's width is "+rec1.width+" height is "+rec1.height
				+" Area is "+rec1.getArea()+" Perimeter is "+rec1.getPerimeter());
		System.out.println("rectangle2's width is "+rec2.width+" height is "+rec2.height
				+" Area is "+rec2.getArea()+" Perimeter is "+rec2.getPerimeter());
		
	}
}


class Rectangle{
	double width=1;
	double height=1;
	
Rectangle(){
	
}
void setWidth(double newWidth){
	width=newWidth;
}
void setHeight(double newHeight){
	height=newHeight;
}
double getArea(){
	return width*height;
}
double getPerimeter(){
	return width*2+height*2;
}

}
