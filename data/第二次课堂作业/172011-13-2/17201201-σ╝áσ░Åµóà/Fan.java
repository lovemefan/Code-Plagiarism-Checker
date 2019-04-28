
public class Fan {
    private static final boolean False = false;
	final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
	private String color = "blue";
	private int speed = SLOW;
	private boolean on = False;
	private double radius = 5;
	
	public Fan(){
	     color = "blue";
	     speed = SLOW;
	     on = False;
	     radius = 5;
	}
	
	public Fan(int speed,double radius,String color,boolean on){
		this.speed = speed;
		this.radius = radius;
		this.color = color;	
		this.on = on;
	}
//·ÃÎÊÆ÷
	public int getSpeed(){
		return speed;
	}
	
	public boolean geOn(){
		return on;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public String getColor(){
		return color;
	}
//ÐÞ¸ÄÆ÷	
	public void setFan(int speed,boolean on,double radius,String color){
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
	}
	
	public String toString(){
		if(on){
			return "The fan's speed is: " + speed + " color is: " + color + " radius is: " + radius;
		}
		else{
			return "fan is off! " + "The fan's color is: " + color + " radius is: " + radius;
		}
	}
}
