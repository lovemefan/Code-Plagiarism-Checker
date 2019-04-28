package work;

public class RegularPolygon {
    private int n=3;
    private double side=1;
    private double x=0;
    private double y=0;
    public RegularPolygon(){
    	
    }
    public RegularPolygon(int n1,double side1){
    	n=n1;
    	side=side1;
    }
    public RegularPolygon(int n2,double side2,double x,double y){
    	n=n2;
    	side=side2;
    	this.x=x;
    	this.y=y;
    }
    public void setN(int n){
    	this.n=n;
    }
    public void setSide(double side){
    	this.side=side;
    }
    public void setX(double x){
    	this.x=x;
    }
    public void setY(double y){
    	this.y=y;
    }
    public int getN(){
    	return n;
    }
    public double getSide(){
    	return side;
    }
    public double getX(){
    	return x;
    }
    public double getY(){
    	return y;
    }
    public double getPerimeter(){
    	return n*side;
    }
    public double getArea(){
    	return (n*side*side)/(4*Math.tan(Math.PI/n));
    }
}
