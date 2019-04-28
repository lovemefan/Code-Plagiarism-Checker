package work1015;

public class Rectangle {
	private double width,hight;
	
	public Rectangle(){//创建矩形的无参构造方法
		this.width=3;  //创建width和height为指定值的矩形的构造方法
		this.hight=4;
		System.out.println("w:"+width+" h:"+hight);
	}
	public Rectangle(int width,int hight){
		this.width=width;
		this.hight=hight;
		System.out.println("w:"+width+" h:"+hight);
	}
	public Rectangle(double width,double hight){
		this.width=width;
		this.hight=hight;
		System.out.println("w:"+width+" h:"+hight);
	}
	public Rectangle(int width,double hight){
		this.width=width;
		this.hight=hight;
		System.out.println("w:"+width+" h:"+hight);
	}
	public Rectangle(double width,int hight){
		this.width=width;
		this.hight=hight;
		System.out.println("w:"+width+" h:"+hight);
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
	/*
	public static void main(String args[]){
		System.out.println("The first Rectangle:");
		Rectangle rec=new Rectangle(4,40);
		System.out.println(rec.getArea());//第一次忘记将rec对象加在函数前面
		System.out.println(rec.getPerimeter());//想直接调用函数 不熟练 很蠢
		
		System.out.println("The second Rectangle:");
		Rectangle rec2=new Rectangle(3.5,35.9);
		System.out.println(rec2.getArea());
		System.out.println(rec2.getPerimeter());
	}*/
}
