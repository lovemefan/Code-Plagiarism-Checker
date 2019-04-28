package test2;

public class Fan {
    final int SLOW = 1;
	final int MIDIUM = 2;
	final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = new String(" ");
	
	public Fan (int speed, boolean on,double radius,String color){
		this.color = color;
		this.on = on;
		this.radius = radius;
		this.speed = speed;
	}
	Fan(){
		this.color = "blue";
		this.on = false;
		this.radius = 5;
		this.speed = SLOW;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public void setOn(boolean on){
		this.on = on;
	}
	
	public boolean getOn(){
		return this.on;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		String R = new String("");
		if (this.on){
			R = String.valueOf(this.speed) + this.color + String.valueOf(this.radius);
		} else {
			R = "fan is off" + this.color + String.valueOf(this.radius);
		}
		return R;
	}
}

