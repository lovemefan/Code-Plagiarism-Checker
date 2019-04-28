package dame;

public class Exe9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Rectangle c1;
    c1=new Rectangle();
    c1.Rectangle(4,40);
    double area = c1.getArea();
    double  perimeter = c1.getPerimeter();
    System.out.println("The first rectangle's area is "+area+" and perimeter is "+perimeter);
    
    Rectangle c2;
    c2 = new Rectangle();
    c2.Rectangle(3.5, 35.9);
    double area1 = c2.getArea();
    double perimeter1 = c2.getPerimeter();
    System.out.println("The second rectangle's area is "+area1+" and perimeter is "+perimeter1);
	}

}
class Rectangle{
	 double width ;
	 double height ;
	 Rectangle(){//定义初始值
		 width = 1;
		 height = 1;
	 }
	public void Rectangle(double Newwidth,double Newheight){
		 width = Newwidth;
		 height = Newheight;
	 }
	 public double getArea(){
		 double Area = width*height ;
		 return Area;
	 }
	 public double getPerimeter(){
		 double Perimeter =(width+height)*2;
		 return Perimeter;
	 }
 }