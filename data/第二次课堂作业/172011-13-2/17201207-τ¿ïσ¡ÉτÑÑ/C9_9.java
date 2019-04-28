package work;

public class C9_9 {

	public static void main(String[] args){
		RegularPolygon m0 = new RegularPolygon ();
		RegularPolygon m1 = new RegularPolygon (6,4);
		RegularPolygon m2 = new RegularPolygon (10,4,5.6,7.8);
		 System.out.println(m0.getPerimeter() +" "+ m0.getArea());
		 System.out.println(m1.getPerimeter() +" "+ m1.getArea());
		 System.out.println(m2.getPerimeter() +" "+ m2.getArea());
		
	}
}
	class RegularPolygon{
		private int n = 3;
		private double side =1;
		private double x=0;
		private double y=0;
		RegularPolygon(){
			 int n =3;
			 double side =1;
			 double x=0;
			 double y=0;;
	}
		RegularPolygon(int n,double side){
		this.n = n;
		this.side = side;
	}
	    RegularPolygon(int n,double side,double x,double y){
	    	this.n = n;
			this.side = side;
			this.x = x;
			this.side = y;
	    }
	    double getPerimeter(){
			return n * side;
		}
		double getArea(){
			return ((n*side*side)/(4*Math.tan(Math.PI/n)));
		}
		void setN(int newN){
			n = newN;
		}
		void setSide(double  newSide){
			side = newSide;
		}
		void setX(double  newX){
			x = newX;
		}
		void setY(double  newY){
			y = newY;
		}
		
	}

