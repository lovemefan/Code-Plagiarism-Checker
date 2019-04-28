package HW;

import java.util.Scanner;

public class Hw_9_1 {
	
		public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		Rectangle Rectangle_1 = new Rectangle(4.0 , 40.0);
		Rectangle Rectangle_2 = new Rectangle(3.5 , 35.9);
		Rectangle_1.showPA(Rectangle_1);
		Rectangle_2.showPA(Rectangle_2);
		}
	}
class Rectangle {
	double width = 1;
	double height = 1;
	Rectangle (){
		double width = 1;
		double height = 1;
	}
	
	Rectangle (double width,double height){
		this.width = width;
		 this.height = height;
	}
	
	double getArea (double width , double height){
		return width * height ;
	}
	double Perimeter (double width , double height){
		return 2 * width + 2 * height;
	}
	void showPA (Rectangle rec1){
		System.out.println("The rectangle`s Area is " + rec1.getArea(rec1.width, rec1.height) + " Perimeter is " + rec1.Perimeter(rec1.width, rec1.height));
	}
}
