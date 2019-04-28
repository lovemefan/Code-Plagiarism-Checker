
public class Fan {
	final static int SLOW = 1; 
	final static int MEDIUM = 2;
	final static int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	public Fan() {
		this.speed = this.SLOW;
		this.on = false;
		this.radius = 5;
		this.color = "blue";
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public boolean getOn() {
		return on;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		if (on) {
			return "speed:" + speed + " color:" + color + " radius:" + radius;
		}
		else{
			return "fan is off,color:" + color + " radius:" + radius;
		}
	}
}
