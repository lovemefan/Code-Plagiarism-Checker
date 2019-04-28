class Rectangle {
	double width;
	double height;
	Rectangle(){
		width = 1;
		height = 1;
		}
	Rectangle(double newWidth ,double newHeight){
		width = newWidth;
		height = newHeight;
		}
	double getArea() {
		return width*height;			
	}
	double getPerimeter() {
		return (width+height)*2;
	}
	public static void main(String[] args) {
		Rectangle test1 = new Rectangle(4,40);
		Rectangle test2 = new Rectangle(3.5,35.9);
		System.out.println("The width and height of the one is " + test1.width + " and " + test1.height + " .Its area and perimeter are " + test1.getArea() + " " + test1.getPerimeter());
		System.out.println("The sidth and height of anthor one is " + test2.width + " and " + test2.height + " .Its area and perimeter are " + test2.getArea() + " " + test2.getPerimeter());
	}
}

	

