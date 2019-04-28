package classtest;

import java.util.Scanner;

public class test9_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Regularpolygon regularpolygon = new Regularpolygon();
		regularpolygon.setN(3);
		regularpolygon.setSide(1);
		regularpolygon.setX(0);
		regularpolygon.setY(0);
		System.out.println(regularpolygon.getPerimeter());
		System.out.println(regularpolygon.getArea());
		Regularpolygon regularpolygon1 = new Regularpolygon();
		System.out.print("Please enter n, side, x, y:");
		regularpolygon1.setN(input.nextInt());
		regularpolygon1.setSide(input.nextDouble());
		regularpolygon1.setX(input.nextDouble());
		regularpolygon1.setY(input.nextDouble());
		System.out.println(regularpolygon1.getPerimeter());
		System.out.println(regularpolygon1.getArea());
		if(input != null) {
			input.close();
		}
	}
}
class Regularpolygon{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	public Regularpolygon(){
		
	}
	public int getN(){
		return n;
	}
	public void setN(int n){
		this.n = n;
	}
	public double getSide(){
		return side;
	}
	public void setSide(double side){
		this.side = side;
	}
	public double getX(){
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getPerimeter(){
		return n * side;
	}
	public double getArea(){
		return (n * Math.pow(side, 2)) / (4 * Math.tan(3.14159 / n));
	}
	
	
}
