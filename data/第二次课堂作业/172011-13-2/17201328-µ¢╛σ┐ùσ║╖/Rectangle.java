import java.util.Scanner;

public class Rectangle {
	private double height = 1;
	private double width = 1;
	public Rectangle(){
		
	}
	
	public void setNumber(double height, double width){
		this.height = height;
		this.width = width;
	}
	
	public double getArea(){
		double area = 0;
		area = height * width;
		return area;
	}
	
	public double getPerimter(){
		double perimter = 0;
		perimter = height * 2 + width * 2;
		return perimter;
	}
}
