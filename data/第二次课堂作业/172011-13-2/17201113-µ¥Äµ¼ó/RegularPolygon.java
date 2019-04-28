package homework;

public class RegularPolygon {
		private int n;
		private double side;
		private double x;
		private double y;
		RegularPolygon(){
			n=3;
			side=1;
			x=0;
			y=0;
		}
		
		RegularPolygon(int newN,double newSide){
			n=newN;
			side=newSide;
		}
		
		RegularPolygon(int newN,double newSide,double newX,double newY){
			n=newN;
			side=newSide;
			x=newX;
			y=newY;
		}
		
		double getPerimeter(){
			return n*side;
		}
		
		double getArea(){
			return n*side*side/(4*Math.tan(Math.PI/n));
		}
		
		int getEdg(){
			return n;
		}
		
		double getLength(){
			return side;
		}
		
		void setPolygon(int newN,double newSide,double newX,double newY){
			n=newN;
			side=newSide;
			x=newX;
			y=newY;
		}
	}


