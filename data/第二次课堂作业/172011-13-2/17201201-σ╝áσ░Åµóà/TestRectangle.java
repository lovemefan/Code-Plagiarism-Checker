
public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle1,rectangle2;
		//width1,height1,width2,height2;
		rectangle1 = new Rectangle(4,40);
		rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("The width "+rectangle1.getWidth()+" height " + rectangle1.getHeight() + " of the rectangle1: area is "+ rectangle1.getArea()+ 
				  " perimeter  is " +rectangle1.getPerimeter());
		System.out.println("The width "+rectangle2.getWidth()+" height " + rectangle2.getHeight() + " of the rectangle1: area is "+ rectangle1.getArea()+ 
				  " perimeter  is " +rectangle2.getPerimeter());
	}

}
