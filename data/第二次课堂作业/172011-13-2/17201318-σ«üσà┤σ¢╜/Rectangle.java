
public class Rectangle {
	//Main method
	public static void main(String[] agrs){
		
		Rectangle rectangle1 = new Rectangle(4 , 40);
		System.out.println("The area and perimeter of rectangle of width :"
				+ rectangle1.width + "and hight:" + rectangle1.hight + 
				" is " + rectangle1.getArea() + " " + rectangle1.getPerimeter());
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("The area and perimeter of rectangle of width :"
				+ rectangle2.width + "and hight:" + rectangle2.hight + 
				" is " + rectangle2.getArea() + " " + rectangle2.getPerimeter());
	}
	 
	double width = 1;
	double hight = 1;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	 public Rectangle(double newWidth, double newHight){
		width = newWidth;
		hight = newHight;
	}
	
	 public double getArea(){
		 return width * hight;
	 }
	 
	 public double getPerimeter(){
		 return 2 * (width + hight);
	 }

}
