package dmz;

public class Problem9_1_Rectangle {
	double width;
	double height;
	public static void main(String[] args) {//≤‚ ‘≥Ã–Ú
		Problem9_1_Rectangle rectangle1 = new Problem9_1_Rectangle(4,40);
		Problem9_1_Rectangle rectangle2 = new Problem9_1_Rectangle(3.5,35.9);
		System.out.println("The width, height,area and perimeter of the rectangle1 are : " + rectangle1.width + " " + rectangle1.height + " " + rectangle1.getArea() + " " + rectangle1.getPerimeter());
		System.out.println("The width, height,area and perimeter of the rectangle2 are : " + rectangle2.width + " " + rectangle2.height + " " + rectangle2.getArea() + " " + rectangle2.getPerimeter());
	}
	Problem9_1_Rectangle(){
		width = 1;
		height = 1;
	}
	Problem9_1_Rectangle(double width1,double height1){
		width = width1;
		height = height1;
	}
	double getArea() {
		return width * height;
	}
	double getPerimeter() {
		return width * 2 + height * 2;
	}

}
