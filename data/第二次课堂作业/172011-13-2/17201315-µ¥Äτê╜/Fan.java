package Fan;//9.8

public class Fan {
	final int SLOW = 1,MEDIUM = 2,FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	public Fan() {
		
	}
	public void setSpeed( int speed) {
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
	public int getSpeed() {
		return speed;
	}
	public boolean getOn() {
		return on;
	}
	public  double getRadius() {
		return radius;
	}
	public String getColor() {
		return color;
	}
	public String toString() {
		String description;
		if (getOn()) {
			description = "The fan'speed is " + getSpeed() +  "\nThe fan'radius is " + getRadius() +"\nThe fan'color is " + getColor();
		}
		else {
			description = "The fan is off \nThe fan'radius is " + getRadius() +"\nThe fan'color is " + getColor();
		}
		return description;
	}
}
