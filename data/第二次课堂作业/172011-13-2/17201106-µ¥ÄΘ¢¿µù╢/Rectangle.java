package 第二次作业;

public class Rectangle {
	private double width,hight;
	
	public Rectangle(){
		this.width=5;  
		this.hight=6;
	}
	public Rectangle(int width,int hight){
		this.width=width;
		this.hight=hight;
	}
	public Rectangle(double width,double hight){
		this.width=width;
		this.hight=hight;
	}
	public Rectangle(int width,double hight){
		this.width=width;
		this.hight=hight;
	}
	public Rectangle(double width,int hight){
		this.width=width;
		this.hight=hight;
	}
	
	public double getArea()
	{
		double area;
		area=width*hight;
		return area;
	}
	public double getPerimeter()
	{
		double perimeter;
		perimeter=2*(width+hight);
		return perimeter;
	}
	
	public static void main(String[] args){
		System.out.println("Rectangle1:");
		Rectangle rec=new Rectangle(4,40);
		System.out.println(rec.getArea());
		System.out.println(rec.getPerimeter());
		
		System.out.println("Rectangle2:");
		Rectangle rec2=new Rectangle(3.5,35.9);
		System.out.println(rec2.getArea());
		System.out.println(rec2.getPerimeter());
	}
}


