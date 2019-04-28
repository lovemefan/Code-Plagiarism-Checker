
public class RegularPolygon {

	private  int n = 3;
	private double side = 1;
	private double x = 0;
    private double y = 0;
	
    public RegularPolygon(){
    	n = 3;
    	side = 1;
    	setX(0);
    	setY(0);
    }
    
    public RegularPolygon(int n,double side){
    	 this.n = n;
    	 this.side = side;
    	 this.setX(0);
    	 this.setY(0);
    }
    
    public RegularPolygon(int n,double side,double x,double y){
    	this.n = n;
    	this.side = side;
    	this.setX(x);
    	this.setY(y);   	
    }
    
    public double getPerimeter(){
    	double perimeter;
    	perimeter = n * side;
    	return perimeter;
    }
    
    public double getArea(){
    	double area;
    	area = (n * Math.pow(side, 2))/(4 * Math.tan(3.141592/n));
    	return area;
    }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
