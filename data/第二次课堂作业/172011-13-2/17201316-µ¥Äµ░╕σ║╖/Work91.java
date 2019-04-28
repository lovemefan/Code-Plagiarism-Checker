package Work91;

public class Work91 {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle(4,40);
		System.out.println("The area of width " + rectangle1.width + " and height " 
		+  rectangle1.height +" is " + rectangle1.getArea() + ", and the perimeter "
				+ rectangle1.getPerimeter());
		Rectangle rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("The area of width " + rectangle2.width + " and height " 
				+  rectangle2.height +" is " + rectangle2.getArea() + ", and the perimeter "
						+ rectangle2.getPerimeter());
	}
}

