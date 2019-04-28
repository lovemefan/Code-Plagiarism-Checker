package exercise2;

public class RegularPolygon {
	public static void main(String[] args){
		RegularPolygon regularPolygon1=new RegularPolygon();
		System.out.println("The regularPolygon1's perimeter is "+regularPolygon1.getPerimeter());
		System.out.println("The regularPolygon1's area is "+regularPolygon1.getArea());
		RegularPolygon regularPolygon2=new RegularPolygon(4,6);
		System.out.println("The regularPolygon2's perimeter is "+regularPolygon2.getPerimeter());
		System.out.println("The regularPolygon2's area is "+regularPolygon2.getArea());
		RegularPolygon regularPolygon3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The regularPolygon3's perimeter is "+regularPolygon3.getPerimeter());
		System.out.println("The regularPolygon3's area is "+regularPolygon3.getArea());
	}
	int n;
	double side,x,y;
	RegularPolygon(){
		n=3;
		side=1;
		x=0;
		y=0;
	}
	RegularPolygon(int n1,double side1){
		n=n1;
		side=side1;
		x=0;
		y=0;
	}
	RegularPolygon(int n1,double side1,double x1,double y1){
		n=n1;
		side=side1;
		x=x1;
	    y=y1;
	}
    double getPerimeter(){
    	return n*side;
    }
    double getArea(){
    	return (n*side*side)/(4*Math.tan(Math.PI/n));
    }
    	
    void setData(int n1,double side1,double x1,double y1){
    	n=n1;
		side=side1;
		x=x1;
	    y=y1;
    }

}
