package mayday001;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args){
		System.out.println("please input the width and heigth : ");
		Scanner input = new Scanner(System.in);
		double width =input.nextDouble();
		double heigth =input.nextDouble();
		newRectangle myRectangle = new newRectangle(width,heigth);
		System.out.println("the area is "+myRectangle.getArea());
		System.out.println("the perimeter is "+myRectangle.getPerimeter());
	}
}

class newRectangle{
	double width,heigth;
	public newRectangle(){
	
	}
	public newRectangle(double width1,double heigth1){
		width = width1;
		heigth = heigth1;
	}
	public double getArea(){
		return width*heigth;
	}
	public double getPerimeter(){
		return 2*(width+heigth);
	}
}
