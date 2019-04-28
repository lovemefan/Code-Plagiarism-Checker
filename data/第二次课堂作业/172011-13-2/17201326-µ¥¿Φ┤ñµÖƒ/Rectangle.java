package test2;

public class Rectangle {
	private double width = 1;
	
	private double height = 1;
	
	public Rectangle(){
		
	}
	
	public Rectangle(double width ,double height){
		this.height = height;
		this.width = width;
	}
	
	public double getWidth(){
		return this.width; 
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public double getArea(){ 
		return this.height * this.width;
	}
	
	public double getPrimeter(){
		return this.width * 2 + this.height * 2;
	} 
}