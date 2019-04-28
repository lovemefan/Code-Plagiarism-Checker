package mayday001;

public class Ex9_9 {
	public static void main(String[] args){
		Regularpolygon re1=new Regularpolygon();
		System.out.println("默认周长:"+re1.getPerimeter()+"                                  面积:"+re1.getArea());
		Regularpolygon re2=new Regularpolygon(6,4);  
		System.out.println("Regularpolygon(6,4)周长:"+re2.getPerimeter()+"                  面积:"+re2.getArea());
		Regularpolygon re3=new Regularpolygon(10,4,5.6,7.8);
		System.out.println("Regularpolygon(10，4，5.6，7.8)周长:"+re3.getPerimeter()+"      面积:"+re3.getArea()); }
}

class Regularpolygon{
	private int n=3;
	private double side=1;
	private double x=0;
	private double y=0;
	Regularpolygon(){
	}
	Regularpolygon(int a,int b){
	n=a;
	side=b;
	x=0;
	y=0;
	}
	Regularpolygon(int a,int b,double c,double d){
	n=a;
	side=b;
	x=c;
	y=d;
	}
	public void setA(int a){
	n=a;
	}
	public void setSide(double b){
	side=b;
	}
	public void setC(double c){
	x=c;
	}
	public void setD(double d){
	y=d;
	}
	public int getA(){
	return n;
	}
	public double getSide(){
	return side;
	}
	public double getC(){
	return x;
	}
	public double getD(){
	return y;
	}
	public double getPerimeter(){
	return n*side;
	}
	public double getArea(){
	return (n*side*side)/(4*Math.tan(getPerimeter()/n));
	}
	}
	